<%-- 
    Document   : cart
    Created on : Dec 18, 2021, 11:01:29 PM
    Author     : thunv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp" %> 
<%@ include file="components/navbar.jsp" %> 
<div class="container vh-100" style="margin-top: 16rem; color: #ffffff">                
    <div class="row">
        <div class="col-md-12">
            <h1>Giỏ hàng</h1>
        </div>
    </div>
    <div class="row" style="font-size: 1.5rem;">
        <div class="col-md-12">
            <table class="table table-responsive">
                <thead>
                    <tr class="text-white">
                        <th scope="col">#</th>
                        <th scope="col">Hình ảnh</th>
                        <th scope="col">Tên sản phẩm</th>
                        <th scope="col">Giá</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody id="tblCart">

                </tbody>
            </table>
        </div>
    </div>
    <div class="row" style="float: right">
        <div class="col-md-3">
            <button class="btn btn-primary" onclick="order()">Đặt hàng</button>
            <button class="btn-danger">Hủy</button>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-12">
                    <label>Hình thức thanh toán:</label>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <label>Hình thức giao hàng:</label>
                </div>
                <div class="col-md-6">
                    <select id="shipment">
                        <option>Giao hàng nhanh</option>
                        <option>Giao hàng tiết kiệm</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col"></div>
            </div>
        </div>
    </div>
</div>

<%@ include file="components/footer.jsp" %>
<script type="text/javascript">
    $(document).ready(() => {
        countItem();
        getCart();
    })
    const order = () => {
        $('#')
    }
    const getCart = () => {
        $('#tblCart').children().remove()
        let cookie = Cookies.get('items');
        let userId = sessionStorage.getItem('id')
        if (cookie && userId) {
            let items = JSON.parse(Cookies.get('items'))
            let count = 0;
            let totalMoney = 0;
            if (items.data.length > 0) {
                items.data.forEach((element) => {
                    count++;
                    totalMoney += element.price;
                    let raw = "<tr class='text-white' id='" + element.id + "'><td>" + count + "</td><td><img width='100' height='100' src='" + element.path + "' /></td><td>" + element.title + "</td><td>" + convertMoney(element.price) + "</td><td><i class='fa fa-trash text-danger' onclick='removeItem(" + JSON.stringify(element) + ")'></i></td></tr>";
                    $('#tblCart').append(raw);
                })
                let raw = "<tr class='text-white'><td colspan='3'>Tổng tiền:</td><td colspan='2'>" + convertMoney(totalMoney) + "</td></tr>";
                $('#tblCart').append(raw);
            }
        }
    }
    const removeItem = (item) => {
        let items = JSON.parse(Cookies.get('items'));
        let index = items.data.findIndex(x => x.id == item.id);
        items.data.splice(index, 1);
        Cookies.set("items", items);
        getCart();
    }
    const countItem = () => {
        let cookie = Cookies.get('items');
        let userId = sessionStorage.getItem('id')
        if (cookie && userId) {
            let items = JSON.parse(Cookies.get('items'))
            if (items.userId == userId) {
                let total = items.data.length;
                console.log(total)
                $('#countItems').html(total)
            } else {
                $('#countItems').hide()
            }
        } else {
            $('#countItems').hide();
        }
    }
    const convertMoney = (money) => {
        let rs = money.toLocaleString('it-IT', {style: 'currency', currency: 'VND'});
        return rs;
    }
</script>
