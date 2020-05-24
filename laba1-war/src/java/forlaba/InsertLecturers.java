package forlaba;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "InsertLecturers", urlPatterns = {"/InsertLecturers"})
public class InsertLecturers extends HttpServlet {
Connection conn = null; 

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");      
        HttpSession session = request.getSession();
        session.setAttribute("url", "google.com");
        session.removeAttribute("url");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String name = request.getParameter("name");   
         String surname = request.getParameter("surname");               
    try {
        processRequest(request, response);
        Class.forName("java.sql.Driver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/distlearn","root","123");   
        PreparedStatement ps = conn.prepareStatement
                    ("INSERT INTO LECTURERS (NAME,SURNAME) VALUES (?,?)");
        ps.setString(1, name);
        ps.setString(2, surname);     
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