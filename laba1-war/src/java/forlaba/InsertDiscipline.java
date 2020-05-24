package forlaba;
import datapackage.Disciplines;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InsertDiscipline", urlPatterns = {"/InsertDiscipline"})
public class InsertDiscipline extends HttpServlet {
Connection conn = null; 
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
         String discipline = request.getParameter("discipline");        
                         
    try {
        processRequest(request, response);
        Class.forName("java.sql.Driver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/distlearn","root","123");   
        PreparedStatement ps = conn.prepareStatement
                    ("INSERT INTO DISCIPLINES (DISCIPLINE) VALUES (?)");
        ps.setString(1, discipline);  
        ps.executeUpdate();
        String path = "/index.html";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(InsertLecturers.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(InsertLecturers.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}