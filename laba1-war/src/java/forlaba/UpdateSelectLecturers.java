package forlaba;
import datapackage.Lecturers;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "UpdateSelectLecturerst", urlPatterns = {"/UpdateSelectLecturers"})
public class UpdateSelectLecturers extends HttpServlet {
Connection conn = null; 
Lecturers lecturers = null; 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");      
    }   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    try {     
        int lectid = Integer.parseInt(request.getParameter("lectid"));
        Class.forName("java.sql.Driver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/distlearn","root","123");   
        String SQL="SELECT * FROM LECTURERS WHERE LECTID=?";
        PreparedStatement ps = conn.prepareStatement(SQL);        
        ps.setInt(1, lectid);
        ResultSet rs = ps.executeQuery(); 
        if(rs.next()){
        int prodId = rs.getInt(1);
        String name = rs.getString(2);
        String surname = rs.getString(3);
        lecturers = new Lecturers(prodId, name, surname);
        }
        request.setAttribute("lecturers", lecturers);
        getServletContext().getRequestDispatcher("/updatelecturers.jsp").forward(request, response);         
        
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(UpdateSelectLecturers.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(UpdateSelectLecturers.class.getName()).log(Level.SEVERE, null, ex);
    }    
                  }     
           @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
