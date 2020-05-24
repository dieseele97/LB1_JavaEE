package forlaba;
import datapackage.Lecturers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShowLecturers", urlPatterns = {"/ShowLecturers"})
public class ShowLecturers extends HttpServlet {
Connection conn = null; 
Statement stmt = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");         
        try (PrintWriter out = response.getWriter()) {
        Class.forName("java.sql.Driver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/distlearn","root","123");  
        stmt = conn.createStatement();
        String SQL="SELECT * FROM LECTURERS";   
        ResultSet rs = stmt.executeQuery(SQL);     
        ArrayList<Lecturers> lecturers = new ArrayList<Lecturers>();
         while(rs.next()){ 
         int lectid = rs.getInt("lectid");
         String name  = rs.getString("name");       
         String surname = rs.getString("surname");     
         Lecturers lecture =new Lecturers();
         lecture.setLectid(lectid);
         lecture.setName(name);
         lecture.setSurname(surname);
         lecturers.add(lecture);          
         } 
        rs.close();     
        request.setAttribute("lecturers", lecturers);   
               
        getServletContext().getRequestDispatcher("/showlecturers.jsp").forward(request, response);           
    } 
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    try {
        processRequest(request, response);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(ShowLecturers.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(ShowLecturers.class.getName()).log(Level.SEVERE, null, ex);
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
