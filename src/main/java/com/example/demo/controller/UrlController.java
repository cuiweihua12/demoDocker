package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author cwh
 * @date 2020/12/11 15:48
 */
@RestController
@RequestMapping("/url")
public class UrlController {

    public void connection() throws IOException {
        URL url = new URL("http://www.baidu.com");
        Object content = url.getContent();
        System.out.println(content);
    }

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");
        URLConnection connection = url.openConnection();
        connection.connect();
        OutputStream stream = connection.getOutputStream();
        System.out.println(stream.toString());
    }
}
