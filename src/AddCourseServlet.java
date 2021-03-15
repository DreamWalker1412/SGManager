import com.javabean.CourseBean;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class AddCourseServlet extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String cid = req.getParameter("cid");
        String name = req.getParameter("name");
        PrintWriter out = resp.getWriter();

        CourseBean courseBean = new CourseBean();
        try {
            courseBean.insert(Integer.valueOf(cid), name);
            out.print("<script>alert('insert success!')</script>");
            resp.setHeader("refresh", "0;URL=/addCourse");
        } catch (SQLException ex) {
                ex.printStackTrace();
                out.print("<script>alert('cid already exist, please change one!')</script>");
                resp.setHeader("refresh", "0;URL=/addCourse");
        }
    }
}