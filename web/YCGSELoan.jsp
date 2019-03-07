<%-- 
    Document   : YCGSELoan.jsp
    Created on : 2019. 3. 10, ?? 12:49:03
    Author     : Youngsun Chang
    Observer   : Gyeonglim Seo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/includes/YCGSBanner.jsp" />
<section>
    <table>
        <tr>
            <th>Code</th>
            <th>Description</th>
            <th>QOH</th> 
            <th>Action</th> 
        </tr>
        
            <c:forEach var="loanitem" items="${loanitem}">
                <tr>
                    <td><c:out value="${loanitem.code}" /></td>
                    <td><c:out value="${loanitem.description}" /></td>
                    <td><c:out value="${loanitem.quantity}" /></td>
                    <td><a href="<c:url value='/YCGSCart?action=reserve&code=${loanitem.code}'/>">Reserve</a></td>
                </tr>
            </c:forEach> 
    </table>
    
</section>
 <jsp:include page="/includes/YCGSFooter.jsp" />
