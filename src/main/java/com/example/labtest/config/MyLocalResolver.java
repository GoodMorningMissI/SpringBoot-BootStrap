package com.example.labtest.config;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;



public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Locale locale=Locale.getDefault();
        return locale;
    }

    @Override    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
