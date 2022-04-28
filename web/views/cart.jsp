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
    <!--    <div class="row">
            <div class="col-md-6">
                <button class="btn btn-primary" onclick="order()">Đặt hàng</button>
                <button class="btn-danger">Hủy</button>
            </div>
        </div>-->
    <div class="row" style="font-size: 1.5rem">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-6">
                    <label>Hình thức thanh toán:</label>
                    <select id="payment" onchange="changeTypePayment(this.value)">
                        <option selected disabled value="">--Chọn hình thức--</option>
                        <option value="1">Cashs</option>
                        <option value="2">Checks</option>
                        <option value="3">Credit</option>
                    </select>
                </div>
                <div class="col-md-4" id="typePayment">

                </div>
            </div>
            <div class="row mt-2">
                <div class="col-md-6">
                    <label>Hình thức giao hàng:</label>
                    <select id="shipment" onchange="changeTypeShipment(this.value)">
                        <option selected disabled value="">--Chọn hình thức--</option>
                        <option value="1">Giao hàng nhanh</option>
                        <option value="2">Giao hàng tiết kiệm</option>
                        <option value="3">Gửi qua đường bưu điện</option>
                    </select>
                </div>
                <div class="col-md-4" id="typeShipment"></div>
            </div>
            <div class="row mt-2">
                <div class="col-md-4 d-flex">
                    <label style="flex: none">Địa chỉ nhận hàng:</label>
                    <input type="text" class="form-control ms-2" id="address"/>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-md-6">
                    <label>Tổng số tiền thanh toán: <span id="totalPayment" style="font-size: 1.8rem "></span></label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-md-2">
                    <button class="btn btn-primary" onclick="order()">Đặt hàng</button>
                    <button class="btn btn-danger" onclick="window.location = '/eCommerce/'">Hủy</button>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="components/footer.jsp" %>
<script type="text/javascript">
    let payment = 0
    let typeShip = 0
    $(document).ready(() => {
        let userId = sessionStorage.getItem("id");
        countItem();
        getCart();
    })
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
                    let raw = "<tr class='text-white' id='" + element.id + "'><td>" + count + "</td><td><img width='100' height='100' src='" + element.path + "' /></td><td>" + element.title + "</td><td>" + convertMoney(element.price) + "</td><td><i class='fa fa-trash text-danger' onclick='removeItem(" + element.id + ")'></i></td></tr>";
                    $('#tblCart').append(raw);
                })
                let raw = "<tr class='text-white'><td colspan='3'>Tổng tiền:</td><td colspan='2'>" + convertMoney(totalMoney) + "</td></tr>";
                $('#tblCart').append(raw);
                payment += totalMoney
            }
        }
    }
    const removeItem = (id) => {
        let items = JSON.parse(Cookies.get('items'));
        let index = items.data.findIndex(x => x.id == id);
        payment -= items.data[index].price
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
    const changeTypePayment = (data) => {
        $('#typePayment').children().remove();
        switch (data) {
            case '1':
                $('#typePayment').append('<span>Thanh toán bằng tiền mặt khi nhận hàng</span>')
                break;
            case '2':
                $('#typePayment').append("<label>Định danh tài khoản ngân hàng</label><input type='text' class='form-control' id='bankid' /> <lable>Tên chủ thẻ</label> <input type='text' id='bankname' class='form-control'/>")
                break;
            case '3':
                $('#typePayment').append("<label>Số tài khoản</label><input type='text' class='form-control' id='number' /> <lable>Hạn thẻ</label> <input type='date' id='expdate' class='form-control'/><label>Loại thẻ</label><select class='form-control' id='typeCredit'><option selected value='1'>Master Card</option><option value='2'>Visa</option>")
                break;
        }
    }
    const changeTypeShipment = (data) => {
        $('#typeShipment').children().remove()
        let str = '<label>Phí vận chuyển: ';
        let type;
        switch (data) {
            case '1':
                str += '30.000 VND</label>'
                type = 1;
                break;
            case '2':
                str += '15.000 VND</label>'
                type = 2;
                break;
            case '3':
                str += '50.000 VND</label>'
                type = 3
                break;
        }
        changeShip(type)
        $('#typeShipment').append(str)
    }
    const convertMoney = (money) => {
        let rs = money.toLocaleString('it-IT', {style: 'currency', currency: 'VND'});
        return rs;
    }
    const changeShip = (type) => {
        console.log("Loại ship: ", type)
        console.log("old val:", typeShip);
        let arr = [0, 30000, 15000, 50000];
        payment = payment - arr[typeShip] + arr[type]
        typeShip = type;
        $('#totalPayment').html(convertMoney(payment))
    }
    const order = () => {
        let cookie = Cookies.get('items');
        let items = JSON.parse(Cookies.get('items'))
        let userId = sessionStorage.getItem("id");
        let ids = '';
        items.data.forEach((element) => {
            ids += element.id + ',';
        })
        let data = {
            ids: ids,
            amount: items.data.length,
            status: 0,
            totalPrice: payment,
            address: $('#address').val(),
            typeShip: $('#shipment').val(),
            typePayment: $('#payment').val(),
            customerId: userId,
            bankid: '',
            bankName: '',
            expDate: '',
            typeCard: '',
            numberAccount: ''
        };
        if (data.typePayment == '2') {
            data.bankid = $('#bankid').val();
            data.bankName = $('bankname').val();
        } else if (data.typePayment == '3') {
            data.expDate = $('#expdate').val();
            data.numberAccount = $('#number').val();
            data.typeCard = $('#typeCredit').val();
        }
        $.ajax({
            url: '/eCommerce/order',
            data,
            type: 'POST',
            success: (res) => {
                let items = {
                    userId: userId,
                    data: []
                }
                Cookies.set('items', items)
                window.location = "/eCommerce/history-order";
            }
        })
    }
</script>
