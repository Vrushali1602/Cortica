package com.dao;
import com.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Attendence";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }

    public void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO students (name, attendance_date, status) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setDate(2, new java.sql.Date(student.getAttendanceDate().getTime()));
            stmt.setString(3, student.getStatus());
            stmt.executeUpdate();
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAttendanceDate(rs.getDate("attendance_date"));
                student.setStatus(rs.getString("status"));
                students.add(student);
            }
        }
        return students;
    }
}
