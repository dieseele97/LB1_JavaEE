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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "SearchLecturers", urlPatterns = {"/SearchLecturers"})
public class SearchLecturers extends HttpServlet {
Connection conn = null; 
Statement stmt = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); 
        
    }   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    
                  }     
           @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        String field = request.getParameter("field");
        String sfield = request.getParameter("sfield"); 
    try {        
        
        Class.forName("java.sql.Driver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/distlearn","root","123");          
        stmt = conn.createStatement();
        String SQL="SELECT LECTURERS.LECTID,LECTURERS.NAME,LECTURERS.SURNAME,DISCIPLINES.DISCIPLINE,DISCIPLINES.LECTID "
                + "FROM LECTURERS,DISCIPLINES WHERE LECTURERS."+field+"='"+sfield+"' AND DISCIPLINES.LECTID=LECTURERS.LECTID ";
         ResultSet rs = stmt.executeQuery(SQL);     
        ArrayList<Lecturers> lecturers = new ArrayList<Lecturers>();
        String[] arrdis=new String[100];
        int count=0;
         while(rs.next()){ 
         int lectid = rs.getInt("lectid");
         String name  = rs.getString("name");       
         String surname = rs.getString("surname");
         String discipline=rs.getString("discipline");
         arrdis[count]=discipline;
         count++;
         
         Lecturers lecture =new Lecturers();
         lecture.setLectid(lectid);
         lecture.setName(name);
         lecture.setSurname(surname);     
         lecture.setDiscipline(discipline);  
         lecturers.add(lecture);   
         
         } 
        rs.close(); 
        request.setAttribute("count", count);
        request.setAttribute("lecturers", lecturers);   
        request.setAttribute("arrdis", arrdis);
         
        getServletContext().getRequestDispatcher("/showsearchl.jsp").forward(request, response);               
        
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(UpdateSelectLecturers.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(UpdateSelectLecturers.class.getName()).log(Level.SEVERE, null, ex);
    }    
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
