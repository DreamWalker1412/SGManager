import com.javabean.CourseBean;
import com.javabean.GradeBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class ModifyGradeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        String cid = req.getParameter("cid");
        String grade = req.getParameter("grade");
        PrintWriter out = resp.getWriter();

        GradeBean gradeBean = new GradeBean();
        try {
            String info = gradeBean.update(Integer.parseInt(sid),Integer.parseInt(cid), Double.parseDouble(grade));
            out.print("<script>alert('"+info+"')</script>");
            resp.setHeader("refresh", "0;URL=/main");
        } catch (Exception ex) {
            out.print("<script>alert('sorry, something wrong!\nMaybe wrong input OR database error.')</script>");
            resp.setHeader("refresh", "0;URL=/main");
            ex.printStackTrace();
        }
    }
}