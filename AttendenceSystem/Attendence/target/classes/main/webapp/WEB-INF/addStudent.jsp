<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>Add Student</title>
</head>
<body>
    <h1>Add New Student</h1>
    <form action="students" method="post">
        Name: <input type="text" name="name"><br>
        Attendance Date: <input type="date" name="attendanceDate"><br>
        Status: <input type="text" name="status"><br>
        <button type="submit">Submit</button>
    </form>
    <a href="index.jsp">Back</a>
</body>
</html>
