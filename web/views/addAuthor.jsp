<%-- 
    Document   : addAuthor
    Created on : Dec 18, 2021, 9:32:12 AM
    Author     : thunv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp" %> 
<%@ include file="components/navbar.jsp" %> 
        <!-- home section starts  -->

<section class="home" id="home">

    <div class="content">
        <h3>mỗi ngày một cuốn sách</h3>
        <p>Sách là người bạn trung thành và yên tĩnh nhất, chúng là những nhà cố vấn dễ tiếp cận và khôn ngoan nhất, và chúng còn là những giáo viên kiên nhẫn nhất</p>
        <a href="#" class="btn">mua ngay</a>
    </div>

</section>

<!-- home section ends -->

<!-- about section starts  -->

<section class="about" id="about">

    <h1 class="heading"> <span>về</span> chúng tôi </h1>

    <div class="row">

        <div class="image">
            <img src="${pageContext.request.contextPath}/assets/images/about-img.jpeg" alt="">
        </div>

        <div class="content">
            <h3>Điều gì khiến chúng tôi trở lên đặc biệt?</h3>
            <p>Bạn có thể tìm thấy điều kỳ diệu ở bất cứ đâu bạn nhìn. Hãy ngồi xuống và nghỉ ngơi, tất cả những gì bạn cần là một cuốn sách</p>
            <p>Chúng tôi luôn mang đến cho bạn những cuốn sách chất lượng nhất, mang đến với bạn những tri thức của nhân loại</p>
            <a href="#" class="btn">Xem thêm</a>
        </div>

    </div>

</section>

<!-- about section ends -->

<!-- menu section starts  -->

<section class="menu" id="menu">

    <h1 class="heading"> Sách <span>menu</span> </h1>

    <div class="box-container">

        <div class="box">
            <img src="${pageContext.request.contextPath}/assets/images/menu-1.png" alt="">
            <h3>tasty and healty</h3>
            <div class="price">200.000 VNĐ <span>230.000 VNĐ</span></div>
            <a href="#" class="btn">Thêm vào giỏ hàng</a>
        </div>

        <div class="box">
            <img src="${pageContext.request.contextPath}/assets/images/menu-2.png" alt="">
            <h3>tasty and healty</h3>
            <div class="price">200.000 VNĐ <span>230.000 VNĐ</span></div>
            <a href="#" class="btn">Thêm vào giỏ hàng</a>
        </div>

        <div class="box">
            <img src="${pageContext.request.contextPath}/assets/images/menu-3.png" alt="">
            <h3>tasty and healty</h3>
            <div class="price">200.000 VNĐ <span>230.000 VNĐ</span></div>
            <a href="#" class="btn">Thêm vào giỏ hàng</a>
        </div>

        <div class="box">
            <img src="${pageContext.request.contextPath}/assets/images/menu-4.png" alt="">
            <h3>tasty and healty</h3>
            <div class="price">200.000 VNĐ <span>230.000 VNĐ</span></div>
            <a href="#" class="btn">Thêm vào giỏ hàng</a>
        </div>

        <div class="box">
            <img src="${pageContext.request.contextPath}/assets/images/menu-5.png" alt="">
            <h3>tasty and healty</h3>
            <div class="price">200.000 VNĐ <span>230.000 VNĐ</span></div>
            <a href="#" class="btn">Thêm vào giỏ hàng</a>
        </div>

        <div class="box">
            <img src="${pageContext.request.contextPath}/assets/images/menu-6.png" alt="">
            <h3>tasty and healty</h3>
            <div class="price">200.000 VNĐ <span>230.000 VNĐ</span></div>
            <a href="#" class="btn">Thêm vào giỏ hàng</a>
        </div>

    </div>

</section>

<!-- menu section ends -->

<section class="products" id="products">

    <h1 class="heading"> Sách <span>yêu thích</span> </h1>

    <div class="box-container">

        <div class="box">
            <div class="icons">
                <a href="#" class="fas fa-shopping-cart"></a>
                <a href="#" class="fas fa-heart"></a>
                <a href="#" class="fas fa-eye"></a>
            </div>
            <div class="image">
                <img src="${pageContext.request.contextPath}/assets/images/product-1.png" alt="">
            </div>
            <div class="content">
                <h3>fresh coffee</h3>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star-half-alt"></i>
                </div>
                <div class="price">300.000 VNĐ <span>350.000 VNĐ</span></div>
            </div>
        </div>

        <div class="box">
            <div class="icons">
                <a href="#" class="fas fa-shopping-cart"></a>
                <a href="#" class="fas fa-heart"></a>
                <a href="#" class="fas fa-eye"></a>
            </div>
            <div class="image">
                <img src="${pageContext.request.contextPath}/assets/images/product-2.png" alt="">
            </div>
            <div class="content">
                <h3>fresh coffee</h3>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star-half-alt"></i>
                </div>
                <div class="price">300.000 VNĐ <span>350.000 VNĐ</span></div>
            </div>
        </div>

        <div class="box">
            <div class="icons">
                <a href="#" class="fas fa-shopping-cart"></a>
                <a href="#" class="fas fa-heart"></a>
                <a href="#" class="fas fa-eye"></a>
            </div>
            <div class="image">
                <img src="${pageContext.request.contextPath}/assets/images/product-3.png" alt="">
            </div>
            <div class="content">
                <h3>fresh coffee</h3>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star-half-alt"></i>
                </div>
                <div class="price">300.000 VNĐ <span>350.000 VNĐ</span></div>
            </div>
        </div>

    </div>

</section>

<!-- review section starts  -->

<section class="review" id="review">

    <h1 class="heading"> Khách hàng <span>đánh giá</span> </h1>

    <div class="box-container">

        <div class="box">
            <img src="${pageContext.request.contextPath}/assets/images/quote-img.png" alt="" class="quote">
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi nulla sit libero nemo fuga sequi nobis? Necessitatibus aut laborum, nisi quas eaque laudantium consequuntur iste ex aliquam minus vel? Nemo.</p>
            <img src="${pageContext.request.contextPath}/assets/images/pic-1.png" class="user" alt="">
            <h3>Nguyễn Đình Hiếu</h3>
            <div class="stars">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i>
            </div>
        </div>

        <div class="box">
            <img src="${pageContext.request.contextPath}/assets/images/quote-img.png" alt="" class="quote">
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi nulla sit libero nemo fuga sequi nobis? Necessitatibus aut laborum, nisi quas eaque laudantium consequuntur iste ex aliquam minus vel? Nemo.</p>
            <img src="${pageContext.request.contextPath}/assets/images/pic-2.png" class="user" alt="">
            <h3>Nguyễn Văn Thử</h3>
            <div class="stars">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i>
            </div>
        </div>
        
        <div class="box">
            <img src="${pageContext.request.contextPath}/assets/images/quote-img.png" alt="" class="quote">
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi nulla sit libero nemo fuga sequi nobis? Necessitatibus aut laborum, nisi quas eaque laudantium consequuntur iste ex aliquam minus vel? Nemo.</p>
            <img src="${pageContext.request.contextPath}/assets/images/pic-3.png" class="user" alt="">
            <h3>Nguyễn Quốc Luật</h3>
            <div class="stars">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i>
            </div>
        </div>

    </div>

</section>

<!-- review section ends -->

<!-- contact section starts  -->

<section class="contact" id="contact">

    <h1 class="heading"> <span>Liên hệ</span> chúng tôi </h1>

    <div class="row">

        <iframe class="map" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d30153.788252261566!2d72.82321484621745!3d19.141690214227783!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3be7b63aceef0c69%3A0x2aa80cf2287dfa3b!2sJogeshwari%20West%2C%20Mumbai%2C%20Maharashtra%20400047!5e0!3m2!1sen!2sin!4v1629452077891!5m2!1sen!2sin" allowfullscreen="" loading="lazy"></iframe>

        <form action="">
            <h3>get in touch</h3>
            <div class="inputBox">
                <span class="fas fa-user"></span>
                <input type="text" placeholder="name">
            </div>
            <div class="inputBox">
                <span class="fas fa-envelope"></span>
                <input type="email" placeholder="email">
            </div>
            <div class="inputBox">
                <span class="fas fa-phone"></span>
                <input type="number" placeholder="number">
            </div>
            <input type="submit" value="contact now" class="btn">
        </form>

    </div>

</section>

<!-- contact section ends -->

<!-- blogs section starts  -->

<section class="blogs" id="blogs">

    <h1 class="heading"> our <span>blogs</span> </h1>

    <div class="box-container">

        <div class="box">
            <div class="image">
                <img src="${pageContext.request.contextPath}/assets/images/blog-1.jpeg" alt="">
            </div>
            <div class="content">
                <a href="#" class="title">tasty and refreshing coffee</a>
                <span>by admin / 21st may, 2021</span>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Non, dicta.</p>
                <a href="#" class="btn">read more</a>
            </div>
        </div>

        <div class="box">
            <div class="image">
                <img src="${pageContext.request.contextPath}/assets/images/blog-2.jpeg" alt="">
            </div>
            <div class="content">
                <a href="#" class="title">tasty and refreshing coffee</a>
                <span>by admin / 21st may, 2021</span>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Non, dicta.</p>
                <a href="#" class="btn">read more</a>
            </div>
        </div>

        <div class="box">
            <div class="image">
                <img src="${pageContext.request.contextPath}/assets/images/blog-3.jpeg" alt="">
            </div>
            <div class="content">
                <a href="#" class="title">tasty and refreshing coffee</a>
                <span>by admin / 21st may, 2021</span>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Non, dicta.</p>
                <a href="#" class="btn">read more</a>
            </div>
        </div>

    </div>

</section>

<!-- blogs section ends -->

<!-- footer section starts  -->


<%@ include file="components/footer.jsp" %> 
