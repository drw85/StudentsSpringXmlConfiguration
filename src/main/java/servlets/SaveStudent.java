package servlets;

import services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");
        resp.sendRedirect(req.getContextPath() + "/addStudent.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");
        String firstnameParam = req.getParameter("firstname");
        String lastnameParam = req.getParameter("lastname");
        StudentService studentService = (StudentService) IndexServlet.applicationContext.getBean("studentService");
        boolean isSuccess = studentService.createStudent(firstnameParam, lastnameParam);
        if (isSuccess) {
            req.setAttribute("message", "СТУДЕНТ СОХРАНЕН");
        } else {
            req.setAttribute("message", "ОШИБКА СОХРАНЕНИЯ СТУДЕНТА");
        }
        req.getRequestDispatcher("/message.jsp").forward(req, resp);
    }
}
