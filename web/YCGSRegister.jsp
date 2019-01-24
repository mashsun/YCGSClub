<%-- 
    Document   : YCGSRegister
    Created on : 2019. 1. 20
    Author     : Youngsun Chang
    Observer   : Gyeonglim Seo
--%>

<jsp:include page="/YCGSBanner.jsp" />

<!-- start the middle column -->

<section>
 <form action="YCGSDisplayMember.jsp" method="post">
     <h1>New Member Registration Form</h1>
            
            <label class="pad_top">Full Name</label>
            <input type="text" name="fullName" required><br>
            <label class="pad_top">Email</label>
            <input type="email" name="email" required><br>
            <label class="pad_top">Phone</label>
            <input type="text" name="phone"><br>

            <label class="pad_top">IT Program</label>
            <select name="program">
                <option value="saab">CAS</option>
                <option value="fiat">SQATE</option>
                <option value="audi">CPA</option>
                <option value="audi">CP</option>
                <option value="audi">ITID</option>
                <option value="audi">CAD</option>
                <option value="audi">ITSS</option>
              </select><br>
            
           <label class="pad_top">Year Level</label>
            <select name="level">
                <option value="saab">1</option>
                <option value="fiat">2</option>
                <option value="audi">3</option>
                <option value="audi">4</option>
              </select><br>
           
            <input type="submit" value="Register Now!">
            <input type="reset" value="Reset">
        </form>
</section>

<!-- end the middle column -->

<jsp:include page="/YCGSFooter.jsp" />
