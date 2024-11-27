package com.controller;



import com.dao.StudentDao;
import com.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String date = req.getParameter("attendanceDate");
            String status = req.getParameter("status");

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Student student = new Student();
            student.setName(name);
            student.setAttendanceDate(formatter.parse(date));
            student.setStatus(status);

            studentDAO.addStudent(student);
            resp.sendRedirect("index.jsp");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Student> students = studentDAO.getAllStudents();
            req.setAttribute("students", students);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
