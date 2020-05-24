package forlaba;
import datapackage.Disciplines;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateDisciplines", urlPatterns = {"/UpdateDisciplines"})
public class UpdateDisciplines extends HttpServlet {
Connection conn = null; 
Statement stmt = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");  
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         try {
        int disid = Integer.parseInt(request.getParameter("disid"));
        String discipline = request.getParameter("discipline");
        Disciplines disciplines = new  Disciplines(disid, discipline);
        Class.forName("java.sql.Driver");   
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/distlearn","root","123");
        String SQL="UPDATE DISCIPLINES SET DISCIPLINE=? WHERE DISID=?";
        PreparedStatement ps = conn.prepareStatement(SQL); 
        ps.setString(1, disciplines.getDiscipline());       
        ps.setInt(2, disciplines.getDisid());
        ps.executeUpdate();
        response.sendRedirect(request.getContextPath() + "/ShowDisciplines");
        
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(UpdateLecturers.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(UpdateLecturers.class.getName()).log(Level.SEVERE, null, ex);
    }        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
