package com.tanklab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/")
public class WebPageController {

//    //获取路径下的所有JSP文件并正常返回
//    @RequestMapping(value = "/{jspPages}", method = GET)
//    public String getJspPages(@PathVariable(value = "jspPages") String jspPages) {
//        System.out.println(jspPages);
//        return jspPages;
//    }


}
