/** 
    Document   : YCGSLoanServlet.java
    Created on : 2019. 3.10
    Author     : Youngsun Chang
    Observer   : Gyeonglim Seo 
*/
package club.cart;
import club.business.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class YCGSLoanServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Forward url
        String url="/YCGSELoan.jsp";       
        
        //creating ServletContext object 
        ServletContext sc = this.getServletContext(); 
        
        //Getting the value of the initialization parameter and printing it  
        String path = sc.getInitParameter("booksFilePath");          
        //String path = sc.getRealPath ("/WEB-INF/books.txt");
      
        //Create ELoan instance 
        ELoan loanitem= new ELoan();
            
        //Put books data into ArrayList
        ArrayList<Book> loanitems = loanitem.loadItems(path);
        
        request.setAttribute("loanitem", loanitems);
            
        getServletContext().getRequestDispatcher(url).forward(request, response);                  
        
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
    }// </e         
}
