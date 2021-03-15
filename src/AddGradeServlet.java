import com.javabean.GradeBean;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class AddGradeServlet extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String sid = req.getParameter("sid");
        String cid = req.getParameter("cid");
        String grade = req.getParameter("grade");
        PrintWriter out = resp.getWriter();
        GradeBean gradeBean = new GradeBean();
        try {
            String info = gradeBean.insert(Integer.valueOf(sid), Integer.valueOf(cid), Double.valueOf(grade));
            out.print("<script>alert('"+info+"')</script>");
            resp.setHeader("refresh", "0;URL=/addGrade");
        } catch (SQLException ex) {
            try {
                ex.printStackTrace();
                gradeBean.update(Integer.valueOf(sid), Integer.valueOf(cid), Double.valueOf(grade));
                out.print("<script>alert('recode already exist, modify success!')</script>");
                resp.setHeader("refresh", "0;URL=/addGrade");
            } catch (Exception ex2) {
                out.print("<script>alert('Error, maybe wrong input!')</script>");
                resp.setHeader("refresh", "0;URL=/addGrade");
            }
        }
    }

}