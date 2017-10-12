
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario_Extra
 */
@WebServlet(name = "Cositas", urlPatterns = {"/Cositas"})
public class Cositas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            float num1 = Float.parseFloat(request.getParameter("num1"));
            float num2 = Float.parseFloat(request.getParameter("num2"));
            float resultado;
            int elegido = 0;

            String nota;
            String sumita = request.getParameter("suma")==null?"":request.getParameter("suma");
            String restita = request.getParameter("resta")==null?"":request.getParameter("resta");
            String division = request.getParameter("divi")==null?"":request.getParameter("divi");
            String multiplo = request.getParameter("multi")==null?"":request.getParameter("multi");
            String [] todos = {sumita, restita, division, multiplo};

            for(int i = 0; i < todos.length; i++){
                if(!todos[i].equals("")){
                    elegido = i;
                }
            }
            switch(elegido){
                case 0:
                    resultado = num1 + num2;
                    out.println("<html>");
                    out.println("<head><title>Calculadora</title></head>");
                    out.println("<body>");
                    out.println("<h1><center>"+resultado+"</h1>");
                    out.println("</body></html>");
                    out.close();
                    break;
                case 1:
                    resultado = num1 - num2;
                    out.println("<html>");
                    out.println("<head><title>Calculadora</title></head>");
                    out.println("<body>");
                    out.println("<h1><center>"+resultado+"</h1>");
                    out.println("</body></html>");
                    out.close();
                    break;
                case 2:
                    if(num2 == 0){
                        nota = "No se puede dividir entre cero";
                        out.println("<html>");
                        out.println("<head><title>Calculadora</title></head>");
                        out.println("<body>");
                        out.println("<h1><center>"+nota+"</h1>");
                        out.println("</body></html>");
                        out.close();
                    }
                    else{
                        resultado = num1/num2;
                        out.println("<html>");
                        out.println("<head><title>Calculadora</title></head>");
                        out.println("<body>");
                        out.println("<h1><center>"+resultado+"</h1>");
                        out.println("</body></html>");
                        out.close();
                    }
                    break;
                case 3:
                    resultado = num1 * num2;
                    out.println("<html>");
                    out.println("<head><title>Calculadora</title></head>");
                    out.println("<body>");
                    out.println("<h1><center>"+resultado+"</h1>");
                    out.println("</body></html>");
                    out.close();
                default:
                    System.out.println("Error");
                    break;
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}