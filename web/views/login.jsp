<%-- 
    Document   : login
    Created on : Dec 18, 2021, 11:11:28 PM
    Author     : thunv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Trang đăng nhập</title>
        <!-- Styles -->
        <script src="${pageContext.request.contextPath}/assets/js/jquery.3.4.1.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/all.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/toastr.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login_style.css">
    </head>

    <body>
        <section class="vh-100">
            <div class="container-fluid h-custom">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-md-9 col-lg-6 col-xl-5">
                        <h3 class="text-center">BookStore Online</h3>
                        <img src="https://images.unsplash.com/photo-1507842217343-583bb7270b66?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1590&q=80" class="img-fluid"
                             alt="Sample image">
                    </div>
                    <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                        <form>
                            <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                                <p class="lead fw-normal mb-0 me-3">Đăng nhập với</p>
                                <button type="button" class="btn btn-primary btn-floating mx-1">
                                    <i class="fab fa-facebook-f"></i>
                                </button>

                                <button type="button" class="btn btn-primary btn-floating mx-1">
                                    <i class="fab fa-twitter"></i>
                                </button>

                                <button type="button" class="btn btn-primary btn-floating mx-1">
                                    <i class="fab fa-linkedin-in"></i>
                                </button>
                            </div>

                            <div class="divider d-flex align-items-center my-4">
                                <p class="text-center fw-bold mx-3 mb-0">Hoặc</p>
                            </div>

                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <input type="email" id="username" class="form-control form-control-lg"
                                       placeholder="Nhập tên đăng nhập" />
                                <label class="form-label" for="form3Example3">Tên đăng nhập</label>
                            </div>

                            <!-- Password input -->
                            <div class="form-outline mb-3">
                                <input type="password" id="password" class="form-control form-control-lg"
                                       placeholder="Nhập mật khẩu" />
                                <label class="form-label" for="form3Example4">Mật khẩu</label>
                            </div>

                            <div class="d-flex justify-content-between align-items-center">
                                <!-- Checkbox -->
                                <div class="form-check mb-0">
                                    <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
                                    <label class="form-check-label" for="form2Example3">
                                        Ghi nhớ tôi
                                    </label>
                                </div>
                                <a href="#!" class="text-body">Quên tài khoản mật khẩu?</a>
                            </div>

                            <div class="text-center text-lg-start mt-4 pt-2">
                                <button type="button" class="btn btn-primary btn-lg"
                                        style="padding-left: 2.5rem; padding-right: 2.5rem;" onclick="login()">Đăng nhập</button>
                                <p class="small fw-bold mt-2 pt-1 mb-0">Bạn chưa có tài khoản? <a href="#!"
                                                                                                  class="link-danger">Đăng kí</a></p>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </section>
        <script src="${pageContext.request.contextPath}/assets/js/toastr.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>

</html>

<script type="text/javascript">
    const login = () => {
        let username = $('#username').val();
        let password = $('#password').val();
        $.ajax({
            url: "/eCommerce/checkLogin",
            data: {username: username, password: password},
            type: 'POST',
            success: (res) =>{
                if(res.success){
                    sessionStorage.setItem('username', res.data[0].username);
                    sessionStorage.setItem('id', res.data[0].id);
                    window.location = "http://localhost:8080/eCommerce/";
                }
                else{
                    toastr.error("Sai tài khoản mật khẩu");
                }
            }
        })
    }
</script>
