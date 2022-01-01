<%-- 
    Document   : book
    Created on : Dec 24, 2021, 11:33:33 AM
    Author     : thunv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/head.jsp" %>
<main>
    <div class="container-fluid mt-5">
        <div class="row">
            <div class="col-md-12">
                <h3>Quản lý sách</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <input id="searchName" type="text" class="form-control" placeholder="Nhập tên sách..." name="searchName">
            </div>
            <div class="col-md-3">
                <button class="btn btn-primary" type="button" onclick="getListBook()"><i class="fa fa-search"></i> Tìm kiếm</button>
                <button class="btn btn-success" onclick="addBook()"><i class="fa fa-plus"></i> Thêm mới</button>
            </div>
        </div>
        <div class="row mt-5">
            <div class="col-md-12">
                <table class="table table-success table-striped table-hover table-bordered" id="tbl">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Barcode</th>
                            <th>Tên</th>
                            <th>Giá</th>
                            <th>Hình ảnh</th>
                            <th>Mô tả</th>
                            <th>Tác giả</th>
                            <th>Nhà xuất bản</th>
                            <th>Chức năng</th>
                        </tr>
                    </thead>
                    <tbody id="tblBook">
                    </tbody>
                </table>

            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div id="totalRecords" style="float: left;"></div>
            </div>
            <div class="col-md-6">
                <div id="pagination_link" style="float: right;"></div>
            </div>
        </div>
    </div>
</main>

<%@ include file="components/foot.jsp" %> 
<script type="text/javascript">
    $(document).ready(() => {
        getListBook();
    });

    const getListBook = () => {
        $.ajax({
            url: '/eCommerce/admin/getListBook',
            type: 'GET',
            success: (res) => {
                if(res.data.length > 0){
                    let count = 0;
                    res.data.forEach((element) => {
                        count++;
                        let rawHtml = "<tr><td>"+count+"</td><td>"+element.bar_code+"</td><td>"+element.title+"</td><td>"+covertMoney(element.price)+"</td><td><img width='100' height='100' src='"+element.path+"'/></td><td>"+element.summary+"</td><td>"+element.author_name+"</td><td>"+element.publisher_name+"</td><td><i class='fa fa-trash text-danger'></i></td></tr>"
                        $('#tblBook').append(rawHtml)
                    })
                }
            }
        })
    }

    const addBook = () => {
        window.location = "/eCommerce/admin/add-or-edit-book?id=0";
    }

    const editBook = (id) => {
        window.location = "/eCommerce/admin/add-or-edit-book?id=" + id;
    }
    
    const covertMoney = (money) => {
        let rs = money.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
        return rs;
    }
</script>
