package com.example.finalproject6.interceptors;

import com.example.finalproject6.pojo.UserVo;
import com.example.finalproject6.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {

            UserVo cuser = (UserVo) request.getSession().getAttribute("cu");
            if (cuser == null) {
                request.setAttribute("errmsg","未登录...");

                request.getRequestDispatcher(request.getContextPath() + "/tologin").forward(request, response);
                return false;
            }
            ThreadLocalUtil.set(cuser);
        }
        return true;

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空ThreadLocal中的数据
        ThreadLocalUtil.remove();
    }
}
