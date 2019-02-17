<%-- 
    Document   : YCGSAddBook.jsp
    Created on : 2019. 2.16
    Author     : Gyeonglim Seo 
    Observer   : Youngsun Chang
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/YCGSBanner.jsp" />
<section>
    <h1>Add a Book</h1>
    <form  action="YCGSAddBook" method="post">
        <label for="code" >Code: </label>
        <input type="text"  name="code" value="${book.code}" style="width: 100px"><br>
        <label for="description" >Description:  </label>
        <input type="text"  name="description" value="${book.description}" style="width: 200px"><br>
        <label for="quantity" >Quantity:  </label>
        <input type="text"  name="quantity" value="${book.quantity}" style="width: 60px"><br> 
        <input type="submit" value="Save" >
        <input type="submit" value="cancel" formaction="YCGSDisplayBooks" method="post">
    </form>
</section>
 <jsp:include page="/YCGSFooter.jsp" />