<%-- 
    Document   : orderDetail
    Created on : Jan 3, 2022, 1:38:18 PM
    Author     : thunv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp" %> 
<%@ include file="components/navbar.jsp" %>
<div class="container vh-100" style="margin-top: 16rem; color: #ffffff">                
    <div class="row">
        <div class="col-md-12">
            <h1>Lịch sử đặt hàng</h1>
        </div>
    </div>
    <div class="row" style="font-size: 1.5rem;">
        <div class="col-md-12">
            <table class="table table-responsive">
                <thead>
                    <tr class="text-white">
                        <th scope="col">#</th>
                        <th scope="col">Khách hàng</th>
                        <th scope="col">Số điện thoại</th>
                        <th scope="col">Địa chỉ nhận hàng</th>
                        <th scope="col">Tổng tiền</th>
                        <th scope="col">Ngày đặt hàng</th>
                        <th scope="col">Hình thức vận chuyển</th>
                        <th scope="col">Giá vận chuyển</th>
                        <th scope="col">Trạng thái</th>
                    </tr>
                </thead>
                <tbody id="tblOrder">

                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="components/footer.jsp" %>
<script type="text/javascript">
    $(document).ready(function () {
        countItem()
        getListOrder();
    })
    const getListOrder = () => {
        let userId = sessionStorage.getItem('id');
        let name = sessionStorage.getItem('id');
        $.ajax({
            url: '/eCommerce/getOrder',
            data: {id: userId},
            type: 'GET',
            success: (res) => {
                if (res.data.length > 0) {
                    let count = 0;
                    res.data.forEach((element) => {
                        count++;
                        let raw = "<tr class='text-white'><td>" + count + "</td><td>" + element.first_name + " " + element.middle_name + " " + element.last_name + "</td>\n\
                                    <td>" + element.phone + "</td>\n\
                                    <td>" + element.address + "</td>\n\
                                    <td>" + convertMoney(element.total_price) + "</td>\n\
                                    <td>" + new Date(element.created_date) + "</td>\n\
                                    <td>" + typeShipment(element.type) + "</td>\n\
                                    <td>" + moneyShip(element.type) + "</td>\n\
                                    <td>" + element.status + "</td></tr>"
                        $('#tblOrder').append(raw)
                    })
                }
            }
        })
    }
    const typeShipment = (type) => {
        let index = parseInt(type);
        let arr = ['','Giao hàng nhanh', 'Giao hàng tiết kiệm', 'Gửi qua đường bưu điện'];
        return arr[index];
    }
    const moneyShip = (type) => {
        let index = parseInt(type)
        let arr = ['','30.000 VND', '15.000 VND', '50.000 VND']
        return arr[index];
    }
    const convertMoney = (money) => {
        let rs = money.toLocaleString('it-IT', {style: 'currency', currency: 'VND'});
        return rs;
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
</script>