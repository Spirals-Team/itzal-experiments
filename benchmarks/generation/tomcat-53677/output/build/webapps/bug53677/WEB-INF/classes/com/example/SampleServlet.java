package com.example;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleServlet extends HttpServlet {

    public SampleServlet() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        char[] bigBuffer = new char[1024 * 8];
        Arrays.fill(bigBuffer, 'a');
        response.setHeader("x-example", new String(bigBuffer));

        response.setContentType("text/plain");
        response.setCharacterEncoding("ISO-8859-1");

        Writer out = null;

        try{
            out = response.getWriter();
            out.write("Hello!");
        } finally {
            if(out != null) {
                out.close();
            }
        }
    }
}
