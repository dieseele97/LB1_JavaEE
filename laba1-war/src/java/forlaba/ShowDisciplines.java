package forlaba;
import datapackage.Disciplines;
import java.io.IOException;
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

@WebServlet(name = "ShowDisciplines", urlPatterns = {"/ShowDisciplines"})
public class ShowDisciplines extends HttpServlet {
Connection conn = null; 
Statement stmt = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
         Class.forName("java.sql.Driver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/distlearn","root","123");  
        stmt = conn.createStatement();
        String SQL="SELECT * FROM DISCIPLINES";   
        ResultSet rs = stmt.executeQuery(SQL);     
        ArrayList<Disciplines> disciplines= new ArrayList<Disciplines>(); 
         while(rs.next()){ 
         int disid = rs.getInt("disid");
         String discipline= rs.getString("discipline");   
         Disciplines disciplined =new Disciplines();       
         disciplined.setDiscipline(discipline);
         disciplined.setDisid(disid); 
         disciplines.add(disciplined);              
         } 
        rs.close();     
        request.setAttribute("disciplines", disciplines);               
        getServletContext().getRequestDispatcher("/showdisciplines.jsp").forward(request, response); 
        
        } catch (ClassNotFoundException ex) {
        Logger.getLogger(ShowDisciplines.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(ShowDisciplines.class.getName()).log(Level.SEVERE, null, ex);
    }
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
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
