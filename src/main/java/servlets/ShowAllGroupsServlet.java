package servlets;

import models.Group;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.GroupService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowAllGroupsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (IndexServlet.applicationContext==null){
            IndexServlet.applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        }
        GroupService groupService = (GroupService) IndexServlet.applicationContext.getBean("groupService");
        List<Group> groups = groupService.findAll();
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");
        req.setAttribute("groups", groups);
        req.getRequestDispatcher("/allGroups.jsp").forward(req, resp);
    }
}
