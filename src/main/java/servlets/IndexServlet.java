package servlets;

import models.Courses;
import models.Group;
import models.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.GroupService;
import services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class IndexServlet extends HttpServlet {
    public static ApplicationContext applicationContext;

    @Override
    public void init() throws ServletException {
        super.init();
        applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        initData();
    }

    private void initData() {
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        GroupService groupService = (GroupService) applicationContext.getBean("groupService");
        studentService.createStudent("Кристофер", "Нолан");
        studentService.createStudent("Лав", "Диас");
        studentService.createStudent("Джеймс", "Кэмерон");
        studentService.createStudent("Гаспар", "Ноэ");
        studentService.createStudent("Уэс", "Андерсон");
        studentService.createStudent("Йоргос", "Лантимос");
        studentService.createStudent("Клинт", "Иствуд");
        studentService.createStudent("Стивен", "Содерберг");
        studentService.createStudent("Алехандро", "Гонсалес Иньярриту");
        studentService.createStudent("Илья", "Хржановский");
        groupService.createGroup("Группа 1", Courses.JAVA);
        groupService.createGroup("Группа 2", Courses.PYTHON);
        groupService.createGroup("Группа 3", Courses.JS);
        groupService.createGroup("Группа 4", Courses.CuttingAndSewing);
        List<Student> allStudents = studentService.findAll();
        List<Group> allGroups = groupService.findAll();
        allGroups.get(0).addStudent(allStudents.get(0));
        allGroups.get(0).addStudent(allStudents.get(1));
        allGroups.get(0).addStudent(allStudents.get(2));
        allGroups.get(1).addStudent(allStudents.get(3));
        allGroups.get(1).addStudent(allStudents.get(4));
        allGroups.get(1).addStudent(allStudents.get(5));
        allGroups.get(2).addStudent(allStudents.get(6));
        allGroups.get(2).addStudent(allStudents.get(7));
        allGroups.get(2).addStudent(allStudents.get(8));
        allGroups.get(3).addStudent(allStudents.get(9));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");
        resp.sendRedirect(req.getContextPath() + "/indexPage.jsp");
    }
}
