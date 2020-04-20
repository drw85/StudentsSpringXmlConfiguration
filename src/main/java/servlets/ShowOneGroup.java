package servlets;

import models.Group;
import services.GroupService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public class ShowOneGroup extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");
        Map<String, String[]> parameterMap = req.getParameterMap();
        int idGroup = Integer.parseInt(parameterMap.get("id")[0]);
        GroupService groupService = (GroupService) IndexServlet.applicationContext.getBean("groupService");
        Optional<Group> findedGroup = groupService.findById(idGroup);
        if (findedGroup.isPresent()) {
            req.setAttribute("group", findedGroup.get());
            req.setAttribute("students", findedGroup.get().getStudents());
            req.getRequestDispatcher("/singleGroup.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "ТАКАЯ ГРУППА НЕ НАЙДЕНА");
            req.getRequestDispatcher("/message.jsp").forward(req, resp);
        }
    }
}
