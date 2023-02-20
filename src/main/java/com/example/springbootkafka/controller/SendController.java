package com.example.springbootkafka.controller;

import com.example.springbootkafka.producer.Sender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Slf4j
public class SendController {

    @Autowired
    Sender sender;

    @RequestMapping(value = "/sender", method = RequestMethod.POST)
    public void exec(HttpServletRequest request, HttpServletResponse response, String data) throws IOException{
        this.sender.send("testtopic",data);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json");
        response.getWriter().write("success");
        response.getWriter().flush();
        response.getWriter().close();
    }

}

