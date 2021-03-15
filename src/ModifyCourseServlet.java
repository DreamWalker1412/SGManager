import com.javabean.CourseBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class ModifyCourseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldCid = req.getParameter("oldCid");
        String newCid = req.getParameter("newCid");
        String name = req.getParameter("name");
        PrintWriter out = resp.getWriter();

        CourseBean courseBean = new CourseBean();
        try {
            courseBean.update(Integer.valueOf(oldCid),Integer.valueOf(newCid), name);
            out.print("<script>alert('Modify success!')</script>");
            resp.setHeader("refresh", "0;URL=/main");
        } catch (SQLException ex) {
            out.print("<script>alert('cid already exist, please change a new one!')</script>");
            resp.setHeader("refresh", "0;URL=/main");
            ex.printStackTrace();
        }
    }
}