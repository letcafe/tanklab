package com.tanklab.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;


public class AppInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return  null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected void customizeRegistration(Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement(
                        "E:\\\\tmp",
                        100 * 1024 * 1024,//文件最大容量
                        200 * 1024 * 1024,//请求最大容量
                        0)
        );
    }
}
