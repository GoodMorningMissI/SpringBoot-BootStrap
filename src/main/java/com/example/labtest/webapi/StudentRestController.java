package com.example.labtest.webapi;

import com.example.labtest.core.PageUtils;
import com.example.labtest.dao.StudentScoreView;
import com.example.labtest.domain.*;
import com.example.labtest.helper.R;
import com.example.labtest.helper.RUtil;
import com.example.labtest.service.*;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/webapi/student")

public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentScoreViewService studentScoreViewService;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ProcService procService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/getdowntabledata")
    public List<Proc> findAll(){
        List<Proc> procs=procService.findAll();
        System.out.println(procs);
        return procs;
    }

    @GetMapping("/list")
    public List<Student> getAll(){
        List<Student> students=studentService.findAll();
        return students;
    }

    @GetMapping("/loginInfo")
    public String loginInfo(HttpServletRequest request){
        HttpSession session=request.getSession();
        String stuno= (String) session.getAttribute("stuno");
        return stuno;
    }

    @GetMapping("/admingetno")
    public String admingetno(String no){
        Student student=studentService.findByNo(no);
        return student.getNo();
    }

    /**
     * 读取学生信息
     */
    @GetMapping("/getno")
    public Student getno(HttpServletRequest request){
        HttpSession session=request.getSession();
        String stuno= (String) session.getAttribute("stuno");
        Student student=studentService.findByNo(stuno);
        return  student;
    }

    /**
     * 修改密码方法
     */
    @GetMapping("/changepassword")
    public int changepassword(String old_password,String new_password,String no){
        Student student=studentService.findByNo(no);
        if(student!=null){
            if(Objects.equals(student.getPassword(), old_password)){
                student.setPassword(new_password);
                studentService.update(student);
                return 1;
            }
            else {
                return -1;
            }
        }else{
            return -1;
        }

    }

    /**
     * 新增学生成绩的方法
     * @param
     * @return
     */
    @PostMapping("/insertscore")
    public Score insert(Score score){
        Score score1=scoreService.insert(score);
        return score1;
    }

    @PostMapping("/insertcourse")
    public int insert(Course course){
        System.out.println(course);
        Course course1=courseService.findbycoursename(course.getCoursename());
        Course course2=courseService.findByCourseno(course.getCourseno());
        if(course1==null&&course2==null){
            courseService.insert(course);
            return 1;
        }else {
            return -1;
        }
    }

    /**
     * 修改学生成绩信息
     */
    @PutMapping("/updatescore")
    public Score update(Score score){
        System.out.println(score);
        score=scoreService.update(score);
        return score;
    }

    /**
     * 获取学生成绩信息
     * @param
     * @return
     */
    @GetMapping("/geteditscore")
    public StudentScore geteditscore(String stuno,String coursename){
        System.out.println(stuno);
        System.out.println(coursename);
        StudentScore studentScore=studentScoreViewService.findByNoAndCoursename(stuno,coursename);
        return  studentScore;
    }
    /**
     * 删除学生成绩信息
     */
    @DeleteMapping("/deletescore")
    public void deletescore(String stuno,String coursename){
        Course course=courseService.findbycoursename(coursename);
        String courseno=course.getCourseno();
        Score score=scoreService.findByCoursenoAndStuno(courseno,stuno);
        System.out.println(score.getCourseno());
        scoreService.delete(score);
    }

    /**
     * 新增学生的方法
      * @param student
     * @return
     */
    @PostMapping("/insert")
    public Student insert(Student student){

        Student student1=studentService.insert(student);
        return student1;

    }

    @PostMapping("/insertproc")
    public int insertproc(Proc proc){
        Proc proc1=procService.findByProcno(proc.getProcno());
        Proc proc2=procService.findByProcname(proc.getProcname());
        System.out.println(proc);
        System.out.println(proc1);
        System.out.println(proc2);
        if (proc1==null && proc2==null){
            procService.insert(proc);
            return 1;
        }
        else {
            return -1;
        }
    }

    /**
     * 修改学生信息
     */
    @PutMapping("/update")
    public Student update(Student student){
        Student oldstudent=studentService.getById(student.getId());
        if (StringUtils.isEmpty(student.getPassword())){
            student.setPassword(oldstudent.getPassword());
        }
        student=studentService.update(student);
        return  student;
    }

    /**
     * 删除学生信息
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @DeleteMapping("/pi_delete/{ids}")
    public void pi_delete(@PathVariable String ids[]){
        for (int i = 0; i < ids.length; i++) {
            Long new_id=Long.parseLong(ids[i]);
            studentService.delete(new_id);
        }

    }
    /**
     * 读取学生信息
     */
    @GetMapping("/getdowntablecoursedata")
    public List<Course> getdowntablecoursedata(String stuno){
        System.out.println("shit");
        System.out.println(stuno);
        Student student=studentService.findByNo(stuno);
        Proc proc=procService.findByProcname(student.getProcname());
        System.out.println(proc);
        List<Course> courses=courseService.findByProcno(proc.getProcno());
        System.out.println(courses);
        return  courses;
    }

    /**
     * 读取学生信息
     */
    @GetMapping("/get/{id}")
    public Student get(@PathVariable Long id){
        System.out.println(id);
        Student student=studentService.getById(id);
        student.setPassword("");
        return  student;
    }
    /**
     * 查找学生
     */
    @GetMapping("/search/{name}")
    public List<Student> search(@PathVariable String name){
        List<Student> students=studentService.findByName(name);
        System.out.println(name);
        return students;
    }

    /**
     * 分页读取全部内容
     * @return
     */
    @GetMapping("/getbypage")
    public R getByPage(@RequestParam(value = "page",defaultValue = "0") Integer page,
                       @RequestParam(value = "size",defaultValue = "10") Integer size,
                       @RequestParam(value = "name",defaultValue = "")String name,
                       @RequestParam(value = "no",defaultValue = "")String no,
                       @RequestParam(value = "sort",defaultValue = "id")String sortname,
                       @RequestParam(value = "sortOrder",defaultValue = "desc") String sortOrder){
        Sort sort=Sort.by(Sort.Direction.fromString(sortOrder),sortname);
        Page<Student> studentPage;
        if(StringUtils.isEmpty(name)&&StringUtils.isEmpty(no)){
            Pageable pageable=PageRequest.of(page,size,sort);
            studentPage =studentService.findAll(pageable);
        }else if(!StringUtils.isEmpty(name) && StringUtils.isEmpty(no)){
            Student student=new Student();
            student.setName(name);
            Pageable pageable =PageRequest.of(page,size,sort);

            ExampleMatcher matcher=ExampleMatcher.matching()
                    .withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Student> example =Example.of(student,matcher);

            studentPage=studentService.findAll(example,pageable);
        }else if(StringUtils.isEmpty(name) && !StringUtils.isEmpty(no)){
            Student student=new Student();
            student.setNo(no);
            Pageable pageable =PageRequest.of(page,size,sort);

            ExampleMatcher matcher=ExampleMatcher.matching()
                    .withMatcher("no",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Student> example =Example.of(student,matcher);

            studentPage=studentService.findAll(example,pageable);
        }else{
            Pageable pageable=PageRequest.of(page,size,sort);
            studentPage =studentService.findAll(pageable);
        }
        return RUtil.success(studentPage);
    }

    @GetMapping("/getstudentscore")
    public List<StudentScore> getstudentscore(HttpServletRequest request){
        HttpSession session=request.getSession();
        String stuno= (String) session.getAttribute("stuno");
        List<StudentScore> studentScores=studentScoreViewService.findByno(stuno);
        return  studentScores;
    }

    @GetMapping("/admingetstudentscore")
    public List<StudentScore> getstudentscore(@RequestParam(value = "stuno",defaultValue = "")String stuno){
        List<StudentScore> studentScores=studentScoreViewService.findByno(stuno);
        return  studentScores;
    }
    @GetMapping("/admingetcourse")
    public List<Course> getcourse(@RequestParam(value = "procno",defaultValue = "")String prono){
        List<Course> courses=courseService.findByProcno(prono);
        return courses;
    }
//    @GetMapping("/admingetproc")
//    public List<Proc> getproc(){
//        List<Proc> procs=procService.findAll();
//        return  procs;
//    }
    @GetMapping("/admingetproc")
    public R admingetproc(@RequestParam(value = "page",defaultValue = "0") Integer page,
                       @RequestParam(value = "size",defaultValue = "10") Integer size,
                       @RequestParam(value = "procname",defaultValue = "")String procname,
                       @RequestParam(value = "procno",defaultValue = "")String procno,
                       @RequestParam(value = "sort",defaultValue = "id")String sortname,
                       @RequestParam(value = "sortOrder",defaultValue = "desc") String sortOrder){
        Sort sort=Sort.by(Sort.Direction.fromString(sortOrder),sortname);
        Page<Proc> ProcPage;
        System.out.println(procname);
        System.out.println(procno);
        if(StringUtils.isEmpty(procname)&&StringUtils.isEmpty(procno)){
            Pageable pageable=PageRequest.of(page,size,sort);
            ProcPage =procService.findAll(pageable);
        }else if(!StringUtils.isEmpty(procname) && StringUtils.isEmpty(procno)){
            Proc proc=new Proc();
            proc.setProcname(procname);
            Pageable pageable =PageRequest.of(page,size,sort);

            ExampleMatcher matcher=ExampleMatcher.matching()
                    .withMatcher("procname",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Proc> example =Example.of(proc,matcher);

            ProcPage=procService.findAll(example,pageable);
        }else if(StringUtils.isEmpty(procname) && !StringUtils.isEmpty(procno)){
            Proc proc=new Proc();
            proc.setProcno(procno);
            Pageable pageable =PageRequest.of(page,size,sort);

            ExampleMatcher matcher=ExampleMatcher.matching()
                    .withMatcher("procno",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Proc> example =Example.of(proc,matcher);

            ProcPage=procService.findAll(example,pageable);
        }else{
            Pageable pageable=PageRequest.of(page,size,sort);
            ProcPage =procService.findAll(pageable);
        }
        return RUtil.success(ProcPage);
    }
    @GetMapping("/getcultivateplanname")
    public Student getcultivateplanname(HttpServletRequest request){
        HttpSession session=request.getSession();
        String stuno= (String) session.getAttribute("stuno");
        System.out.println(stuno);
        Student student=studentService.findByNo(stuno);
        System.out.println(student);
        return student;
    }

}
//
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \|     |// '.
//                 / \|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \  -  /// |     |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//
//          本模块已经经过开光处理，绝无可能再产生bug
//