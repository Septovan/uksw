
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Septovan D. S. Saian
 */
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int angka1 = Integer.parseInt(req.getParameter("angka1"));
        int angka2 = Integer.parseInt(req.getParameter("angka2"));
        int jumlah = angka1 + angka2;
        
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
                out.println("<head>");
                    out.println("<title>Servlet hitungServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                    out.println("<h1>Angka 1: " + angka1 + " ditambah Angka 2: " + angka2 + "</h1>");
                    out.println("<h1>Hasil Penjumlahan " + jumlah + "</h1>");
                    out.println("<a href='calculator'>Hitung lagi</a>");
                out.println("</body>");
            out.println("</html>");
        }
    }
    
}
