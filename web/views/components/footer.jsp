<%-- 
    Document   : footer
    Created on : Dec 18, 2021, 4:48:16 PM
    Author     : thunv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="footer">

    <div class="share">
        <a href="#" class="fab fa-facebook-f"></a>
        <a href="#" class="fab fa-twitter"></a>
        <a href="#" class="fab fa-instagram"></a>
        <a href="#" class="fab fa-linkedin"></a>
        <a href="#" class="fab fa-pinterest"></a>
    </div>

    <div class="links">
        <a href="#">home</a>
        <a href="#">about</a>
        <a href="#">menu</a>
        <a href="#">products</a>
        <a href="#">review</a>
        <a href="#">contact</a>
        <a href="#">blogs</a>
    </div>

    <div class="credit">created by <span>mr. web designer</span> | all rights reserved</div>

</section>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.1.10/sweetalert2.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/toastr.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>
</html>
<script type="text/javascript">
    $(document).ready( () => {
        let username = sessionStorage.getItem("username");
        if (username) {
            $('#btnRegister').hide();
            $('#btnLogin').hide();
            $('#character').hide();
            let rawAccount = `<i class='fa fa-user ms-2'></i>` + username;
            $('#usernameText').html(rawAccount);
        }
    })
</script>