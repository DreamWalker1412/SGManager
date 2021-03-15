import com.javabean.StudentBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class ModifyStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldSid = req.getParameter("oldSid");
        String newSid = req.getParameter("newSid");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        PrintWriter out = resp.getWriter();

        StudentBean studentBean = new StudentBean();
        try {
            String info = studentBean.update(Integer.valueOf(oldSid),Integer.valueOf(newSid), name, sex);
            out.print("<script>alert('"+info+"')</script>");
            resp.setHeader("refresh", "0;URL=/main");
        } catch (SQLException ex) {
            ex.printStackTrace();
            out.print("<script>alert('sid already exist, please change a new one!')</script>");
        }
    }
}