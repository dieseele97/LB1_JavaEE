package forlaba;
import datapackage.Lecturers;
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

@WebServlet(name = "UpdateLecturers", urlPatterns = {"/UpdateLecturers"})
public class UpdateLecturers extends HttpServlet {
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
        int lectid = Integer.parseInt(request.getParameter("lectid"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Lecturers lecturers = new  Lecturers(lectid, name, surname);
        Class.forName("java.sql.Driver");   
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/distlearn","root","123");
        String SQL="UPDATE LECTURERS SET NAME=?, SURNAME=? WHERE LECTID=?";
        PreparedStatement ps = conn.prepareStatement(SQL); 
        ps.setString(1, lecturers.getName());
        ps.setString(2, lecturers.getSurname());
        ps.setInt(3, lecturers.getLectid());
        ps.executeUpdate();
        response.sendRedirect(request.getContextPath() + "/ShowLecturers");
        
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(UpdateLecturers.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(UpdateLecturers.class.getName()).log(Level.SEVERE, null, ex);
    }        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
