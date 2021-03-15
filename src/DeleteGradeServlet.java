import com.javabean.GradeBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteGradeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid_cid = req.getParameter("grade");
        String str[] = sid_cid.split("_");
        String sid = str[0];
        String cid = str[1];
        PrintWriter out = resp.getWriter();

        GradeBean gradeBean = new GradeBean();
        try {
            boolean isSuccess = gradeBean.delete(Integer.valueOf(sid),Integer.valueOf(cid));
            if( isSuccess ) {
                out.print("<script>alert('Delete success!')</script>");
                resp.setHeader("refresh", "0;URL=/main");
            }
            else {
                out.print("<script>alert('Can not find this grade record!\nIt has been deleted before!')</script>");
                resp.setHeader("refresh", "0;URL=/main");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}