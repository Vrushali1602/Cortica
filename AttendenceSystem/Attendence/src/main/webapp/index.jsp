<%@ page import="java.util.List, com.model.Student" %>
<%@ page language="java" %>
<html>
<head>
    <title>Student Attendance</title>
</head>
<body>
    <h1>Student Attendance</h1>
    <a href="addStudent.jsp">Add New Student</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Date</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Student> students = (List<Student>) request.getAttribute("students");
                if (students != null) {
                    for (Student student : students) {
            %>
                <tr>
                    <td><%= student.getId() %></td>
                    <td><%= student.getName() %></td>
                    <td><%= student.getAttendanceDate() %></td>
                    <td><%= student.getStatus() %></td>
                </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
</body>
</html>
