package com.example.javaeedemo;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.example.javaeedemo.model.Physician;
import com.example.javaeedemo.service.UserService;
import com.example.javaeedemo.util.ConnectionManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private Connection con = null;
    private Statement stmt = null;

    private UserService userService;

    public void init() {
        con = ConnectionManager.getConnection();
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        userService = new UserService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            List<Physician> physicians = userService.getPhysicians(stmt);
            request.setAttribute("physicians", physicians);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String destination = "hello-servlet.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);

        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        request.setAttribute("name", name);
        request.setAttribute("phone", phone);

        String destination = "user-result.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);

        requestDispatcher.forward(request, response);
    }

    public void destroy() {
        try {
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}