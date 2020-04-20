package servlets;

import models.Student;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowAllStudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (IndexServlet.applicationContext==null){
            IndexServlet.applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        }
        StudentService studentService = (StudentService) IndexServlet.applicationContext.getBean("studentService");
        List<Student> students = studentService.findAll();
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");
        req.setAttribute("students", students);
        req.getRequestDispatcher("/allStudents.jsp").forward(req, resp);
    }
}
