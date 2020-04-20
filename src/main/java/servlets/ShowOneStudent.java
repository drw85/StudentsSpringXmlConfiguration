package servlets;

import models.Student;
import services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public class ShowOneStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");
        Map<String, String[]> parameterMap = req.getParameterMap();
        int idStudent = Integer.parseInt(parameterMap.get("id")[0]);
        StudentService studentService = (StudentService) IndexServlet.applicationContext.getBean("studentService");
        Optional<Student> findedStudent = studentService.findById(idStudent);
        if (findedStudent.isPresent()) {
            req.setAttribute("student", findedStudent.get());
            req.setAttribute("groups", studentService.getStudentGroups(findedStudent.get().getId()));
            req.getRequestDispatcher("/singleStudent.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "ТАКОЙ СТУДЕНТ НЕ НАЙДЕН");
            req.getRequestDispatcher("/message.jsp").forward(req, resp);
        }
    }
}
