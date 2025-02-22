package com.example.finalproject6.config;

import com.example.finalproject6.DesignPattern.DecoratorPattern.LoggingAdminServiceDecorator;
import com.example.finalproject6.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Autowired
//    private LoginInterceptor loginInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //登录接口和注册接口不拦截
//        registry.addInterceptor(loginInterceptor).
//                excludePathPatterns(
//                        "/",
//                        "/tologin",
//                        "/toregister",
//                        "/user/index",
//                        "/user/register",
//                        "/user/login",
//                        "/admin/add",
//                        "/admin/list",
//                        "/admin/home",
//                        "/admin/addaction",
//                        "/admin/logout"
//
//                );
//    }

    @Bean
    public AdminServiceImpl adminService(AdminServiceImpl adminServiceImpl) {
        return new LoggingAdminServiceDecorator(adminServiceImpl);
    }


    @Value("${spring.servlet.multipart.location}")
    String path;

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:" + path);
    }
}
