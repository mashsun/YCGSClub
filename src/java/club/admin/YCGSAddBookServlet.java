/** 
    Document   : YCGSAddBookServlet.java
    Created on : 2019. 2.16
    Author     : Gyeonglim Seo 
    Observer   : Youngsun Chang
*/
package club.admin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class YCGSAddBookServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
            String url="/YCGSdisplayBooks";
            String message="";
            int quantity=0;
            
            //get parameters from the request
            String code=request.getParameter("code");
            String description=request.getParameter("description");
            
            //If the quantity is blank, default it to 0
            if(request.getParameter("quantity").trim()==null){
               quantity=0;
            }else{
               quantity=Integer.parseInt(  request.getParameter("quantity"));
            }
            
            if(code==null || code==""){
                message="Book code is required. \n ";
            }
            if(description.length()<3){
                 message=message+"Description must have at least 3 characters.\n";
            }
            if(quantity<0){
                 message=message+"Quantity must be a positive number. \n";
            }
            
            if(message!=null){
                    url="/YCGSAddBook.jsp";
            }
            request.setAttribute("message", message);
            
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
}
