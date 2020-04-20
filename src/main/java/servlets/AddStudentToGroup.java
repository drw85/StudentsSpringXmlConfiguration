package servlets;

import models.Group;
import models.Student;
import services.GroupService;
import services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class AddStudentToGroup extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GroupService groupService = (GroupService) IndexServlet.applicationContext.getBean("groupService");
        StudentService studentService = (StudentService) IndexServlet.applicationContext.getBean("studentService");
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");
        req.setAttribute("groups", groupService.findAll());
        req.setAttribute("students", studentService.findAll());
        req.getRequestDispatcher("/addStudentToGroup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GroupService groupService = (GroupService) IndexServlet.applicationContext.getBean("groupService");
        StudentService studentService = (StudentService) IndexServlet.applicationContext.getBean("studentService");
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");
        try {
            int idGroup = Integer.parseInt(req.getParameter("idGroup"));
            int idStudent = Integer.parseInt(req.getParameter("idStudent"));

            Optional<Student> findedStudent = studentService.findById(idStudent);
            Optional<Group> findedGroup = groupService.findById(idGroup);
            if (findedStudent.isPresent() && findedGroup.isPresent()) {
                if (!findedGroup.get().getStudents().contains(findedStudent.get())) {
                    groupService.addStudentToGroup(findedStudent.get().getId(), findedGroup.get().getId());
                } else {
                    req.setAttribute("message", "ЭТОТ СТУДЕНТ УЖЕ В ЭТОЙ ГРУППЕ");
                    req.getRequestDispatcher("/message.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("message", "ОШИБКА ВНЕСЕНИЯ СТУДЕНТА В ГРУППУ");
                req.getRequestDispatcher("/message.jsp").forward(req, resp);
            }
            req.setAttribute("message", "СТУДЕНТ " + findedStudent.get().toString() +
                    " ДОБАВЛЕН В ГРУППУ " + findedGroup.get().getName());
            req.getRequestDispatcher("/message.jsp").forward(req, resp);
        } catch (Exception ex) {
            req.setAttribute("message", "ОШИБКА ВНЕСЕНИЯ СТУДЕНТА В ГРУППУ");
            req.getRequestDispatcher("/message.jsp").forward(req, resp);
        }
    }
}
