import com.javabean.StudentBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("student");
        PrintWriter out = resp.getWriter();

        StudentBean studentBean = new StudentBean();
        try {
            boolean isSuccess = studentBean.delete(Integer.valueOf(sid));
            if( isSuccess ) {
                out.print("<script>alert('Delete success!')</script>");
                resp.setHeader("refresh", "0;URL=/main");
            }
            else {
                out.print("<script>alert('Can not find this student record!\nIt has been deleted before!')</script>");
                resp.setHeader("refresh", "0;URL=/main");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}