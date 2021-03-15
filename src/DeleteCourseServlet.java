import com.javabean.CourseBean;
import com.javabean.StudentBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteCourseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("course");
        PrintWriter out = resp.getWriter();

        CourseBean courseBean = new CourseBean();
        try {
            boolean isSuccess = courseBean.delete(Integer.valueOf(cid));
            if( isSuccess ) {
                out.print("<script>alert('Delete success!')</script>");
                resp.setHeader("refresh", "0;URL=/main");
            }
            else {
                out.print("<script>alert('Can not find this course record!\nIt has been deleted before!')</script>");
                resp.setHeader("refresh", "0;URL=/main");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}