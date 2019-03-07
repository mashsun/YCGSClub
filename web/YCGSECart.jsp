<%-- 
    Document   : YCGSELoan.jsp
    Created on : 2019. 3. 10,  12:49:03
    Author     : Youngsun Chang
    Observer   : Gyeonglim Seo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/includes/YCGSBanner.jsp" />
<section>
    <h2>Your Loan Cart</h2>
    <table>
        <tr>
            <th>Code</th>
            <th>Description</th>
            <th>QOH</th> 
        </tr>
        
            <c:forEach var="loanitem" items="${loanitem}">
                <tr>
                    <td><c:out value="${loanitem.code}" /></td>
                    <td><c:out value="${loanitem.description}" /></td>
                    <td><c:out value="${loanitem.quantity}" /></td>
                </tr>
            </c:forEach> 
         
        <tr>
            <td></td>
            <td align="right">Total</td>
            <td></td> 
        </tr>       
        
    </table>
    
</section>
 <jsp:include page="/includes/YCGSFooter.jsp" />

