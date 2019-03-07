/** 
    Document   : YCGSCartServlet.java
    Created on : 2019. 3.10
    Author     : Youngsun Chang
    Observer   : Gyeonglim Seo 
*/
package club.cart;


import club.business.*;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class YCGSCartServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        ECart cart;
        ServletContext sc = getServletContext();
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "cart";  // default action
        }

        // perform action and set URL to appropriate page
        String url = "/index.jsp";
        if (action.equals("shop")) {
            url = "/index.jsp";    // the "index" page
        } 
        else if (action.equals("cart")) {
            String code=request.getParameter("code");
            String quantityString = request.getParameter("quantity");

            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new ECart();
            }
            
            //if the user enters a negative or invalid quantity,
            //the quantity is automatically reset to 1.
            int quantity;
            try {
                quantity = Integer.parseInt(quantityString);
                if (quantity < 0) {
                    quantity = 1;
                }
            } catch (NumberFormatException nfe) {
                quantity = 1;
            }

            String path = sc.getRealPath("/WEB-INF/books.txt");
            //Make a new book instance
            Book book = new Book(code, description, quantity);

            ELoan lineItem = new ELoan();
            lineItem.setProduct(product);
            lineItem.setQuantity(quantity);
            
            if (quantity > 0) {
                cart.addItem(lineItem);
            } else if (quantity == 0) {
                cart.removeItem(lineItem);
            }
            session.setAttribute("cart", cart);
                url = "/cart.jsp";
            }
            else if (action.equals("checkout")) {
                url = "/checkout.jsp";
            }

            sc.getRequestDispatcher(url)
                    .forward(request, response);
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
