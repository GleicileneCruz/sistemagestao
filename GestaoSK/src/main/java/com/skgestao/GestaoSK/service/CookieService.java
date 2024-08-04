package com.skgestao.GestaoSK.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieService {

    public static void setCookie(HttpServletResponse response, String key, String valor, int segundos) throws IOException {
        Cookie cookie = new Cookie(key, URLEncoder.encode(valor, "UTF-8"));
        cookie.setMaxAge(segundos);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static String getCookie(HttpServletRequest request, String key) {
        String valor = Optional.ofNullable(request.getCookies())
                .flatMap(cookies -> Arrays.stream(cookies)
                        .filter(cookie -> key.equals(cookie.getName()))
                        .findAny())
                .map(Cookie::getValue)
                .orElse(null);

        if (valor != null) {
            try {
                valor = URLDecoder.decode(valor, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return valor;
    }
}
