package servlets;

import models.Courses;
import services.GroupService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveGroup extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");
        req.setAttribute("coursesVars", Courses.values());
        req.getRequestDispatcher("/addGroup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");
        String nameParam = req.getParameter("name");
        Courses courseParam = Courses.valueOf(req.getParameter("course"));
        GroupService groupService = (GroupService) IndexServlet.applicationContext.getBean("groupService");
        boolean isSuccess = groupService.createGroup(nameParam, courseParam);
        if (isSuccess) {
            req.setAttribute("message", "ГРУППА СОХРАНЕНА");
        } else {
            req.setAttribute("message", "ОШИБКА СОХРАНЕНИЯ ГРУППЫ");
        }
        req.getRequestDispatcher("/message.jsp").forward(req, resp);
    }
}
