package com.shop.miniShoppingMall.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheck implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 로그인 여부 확인
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("login");
        if(userid==null) {
            response.sendRedirect("/shop/loginUI");
            return false; // Controller 요청 안됨
        }
        return true; // Controller 요청 됨
    }
}
