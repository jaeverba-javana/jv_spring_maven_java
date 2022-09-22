package com.jaeverba.jv.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Idioma {
    public final String LANGUAGE_SPANISH = "es";
    public final String LANGUAGE_ENGLISH = "en";


    public static String getCookieLanguage (Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie_temporal: cookies) {
                if ("lang".equals(cookie_temporal.getName())) {
                    return cookie_temporal.getValue();
                }
            }
        }
        return null;
    }

    public static void setCookieLanguage (HttpServletResponse response, String Idioma) {
        Cookie cookie_idioma = new Cookie("lang", Idioma);
        cookie_idioma.setMaxAge(60*60*24);
        cookie_idioma.setPath("/");
        response.addCookie(cookie_idioma);
    }

    public static String getNavigatorLanguage (HttpServletRequest request) {
        Matcher matc = Pattern.compile("(^[a-z]{2})").matcher(request.getHeader("Accept-Language"));
        if (matc.find()) {
            return matc.group(1);
        } else return "es";
    }


    public static String getLang(HttpServletRequest request, HttpServletResponse response) {
        String language = getCookieLanguage(request.getCookies());

        if (language == null) {
            language = getNavigatorLanguage(request);
            setCookieLanguage(response, language);
        }

        return language;
    }
}
