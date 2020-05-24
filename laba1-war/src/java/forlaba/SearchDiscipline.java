package forlaba;
import datapackage.Disciplines;
import datapackage.Lecturers;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "SearchDiscipline", urlPatterns = {"/SearchDiscipline"})
public class SearchDiscipline extends HttpServlet {
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
        String sfield = request.getParameter("sfield");
             
    try {        
        
        Class.forName("java.sql.Driver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/distlearn","root","123");          
        stmt = conn.createStatement();
         String SQL="SELECT * FROM LECTURERS";
         ResultSet rs = stmt.executeQuery(SQL);         
         ArrayList<Lecturers> lecturer = new ArrayList<Lecturers>();
         while(rs.next()){ 
         int lectid = rs.getInt("lectid");
         String name  = rs.getString("name");       
         String surname  = rs.getString("surname");    
         Lecturers lecturers =new Lecturers();
         lecturers.setLectid(lectid);
         lecturers.setName(name);
         lecturers.setSurname(surname);
         lecturer.add(lecturers);          
         } 
         rs.close();    
              
         String SQL1="SELECT * FROM DISCIPLINES WHERE DISCIPLINE='"+sfield+"'";
         ResultSet rs1 = stmt.executeQuery(SQL1);         
         ArrayList<Disciplines> disciplines = new ArrayList<Disciplines>();
         while(rs1.next()){ 
         int disid = rs1.getInt("disid");
         String discipline  = rs1.getString("discipline");       
         int lectid = rs1.getInt("lectid");
         
         Disciplines disciplined =new Disciplines();
         disciplined.setDisid(disid);
         disciplined.setDiscipline(discipline); 
         disciplined.setLectid(lectid);
         Lecturers name=null;
         Lecturers surname=null;
         for (Lecturers lect:lecturer) {
                if (lect.getLectid() == lectid) {
                    name = lect;                   
                } 
            }
         for (Lecturers lect2:lecturer) {
                if (lect2.getLectid() == lectid) {
                    surname = lect2;                   
                } 
            }   
         disciplined.setLecturers(name);  
         disciplined.setLecturerssn(surname);         
         disciplines.add(disciplined);           
         } 
        rs.close();     
        request.setAttribute("disciplines",disciplines);        
                
        getServletContext().getRequestDispatcher("/searchdiscipline.jsp").forward(request, response);               
        
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
