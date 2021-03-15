import com.javabean.CourseBean;
import com.javabean.StudentBean;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        PrintWriter out = resp.getWriter();

        StudentBean studentBean = new StudentBean();
        try {
            String info = studentBean.insert(Integer.valueOf(sid), name, sex);
            out.print("<script>alert('"+info+"')</script>");
            resp.setHeader("refresh", "0;URL=/addStudent");
        } catch (SQLException ex) {
                ex.printStackTrace();
                out.print("<script>alert('sid already exist, please change one!')</script>");
                resp.setHeader("refresh", "0;URL=/addStudent");
        }

    }
}