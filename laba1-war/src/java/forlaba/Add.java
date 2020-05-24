package forlaba;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Add", urlPatterns = {"/Add"})
public class Add extends HttpServlet {
Connection conn = null; 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<center><h1>Викладач успішно закріплений за дисципліною!</h1>");
        out.println("<p><a href=index.html> Повернутися на головну</a></p></center>");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String data1 = request.getParameter("data1");   
        String data2[] = request.getParameterValues("data2");  
         try {
        processRequest(request, response);
        Class.forName("java.sql.Driver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/distlearn","root","123");
        for(int i=0;i<data2.length;i++){
        PreparedStatement ps = conn.prepareStatement
                    ("UPDATE DISCIPLINES SET LECTID="+data1+" WHERE DISID="+data2[i]+"");     
       
        
        ps.executeUpdate();  }       
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
