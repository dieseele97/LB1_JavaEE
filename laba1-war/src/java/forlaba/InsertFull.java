    package forlaba;
import ejbpackage.HttpSessionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 

@WebServlet(name = "InsertFull", urlPatterns = {"/InsertFull"})
public class InsertFull extends HttpServlet {
Connection conn = null; 
Statement stmt = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        HttpSession session = request.getSession();
        session.setAttribute("url", "google.com");
        session.removeAttribute("url");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        Class.forName("java.sql.Driver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/distlearn","root","123");  
        stmt = conn.createStatement();
        String SQL="SELECT * FROM LECTURERS";    
        ResultSet rs = stmt.executeQuery(SQL);
        int arrid[]=new int[100];        
        String[] namearray=new String[100];
        String[] surnamearray=new String[100];       
        int count=0;
        while(rs.next()){ 
         int lectid=rs.getInt("lectid");
         String name  = rs.getString("name");       
         String surname = rs.getString("surname"); 
         arrid[count]=lectid;
         namearray[count]=name;
         surnamearray[count]=surname;     
         count++;
         } 
        rs.close();             
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");                
            out.println("</head>");           
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Закріплення викладача за дисципліною</h1>");
            out.println("<h2>Оберіть викладача:</h2>");
            out.println("<form action=Add method=post>"); 
        for(int i=0;i<count;i++){           
          out.println("<p><input type=radio value="+arrid[i]+" name=data1>"+namearray[i]+" "+surnamearray[i]+"</p>");             
                }
        int arrid2[]=new int[100];
        String[] disciplinearray=new String[100];
        String SQL1="SELECT * FROM DISCIPLINES";
        ResultSet rs2 = stmt.executeQuery(SQL1); 
        int count2=0;      
        while(rs2.next()){ 
        int disid=rs2.getInt("disid");
        String discipline  = rs2.getString("discipline");   
        disciplinearray[count2]=discipline;
        arrid2[count2]=disid;
        count2++;
        } 
       request.getSession().setAttribute("count2", count2);
      
        rs2.close();           
            out.println("<h2>Оберіть дисципліну:</h2>");
          
        for(int i=0;i<count2;i++){      
          out.println("<p><input type=checkbox value="+arrid2[i]+" name=data2>"+disciplinearray[i]+"</p>");  
             }
        out.println("<input type=submit name=send value=Закріпити>");
        out.println("<p>"+HttpSessionManager.getActiveSessionsCount() + " користувачів присутні на сайті.");
        out.println("<p><a href=index.html> Повернутися на головну</a></p>");
        out.println("</form></center></body></html>");
        }        
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(InsertFull.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(InsertFull.class.getName()).log(Level.SEVERE, null, ex);
    }
    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(InsertFull.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(InsertFull.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
