<%-- 
    Document   : author
    Created on : Dec 24, 2021, 11:34:00 AM
    Author     : thunv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/head.jsp" %> 
<main>
    <div class="container-fluid mt-5">
        <div class="row">
            <div class="col-md-12">
                <h3>Quản lý tác giả</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <input id="searchName" type="text" class="form-control" placeholder="Nhập họ tên tác giả..." name="searchName">
            </div>
            <div class="col-md-3">
                <button class="btn btn-primary" type="button" onclick="getListAuthor()"><i class="fa fa-search"></i> Tìm kiếm</button>
                <button class="btn btn-success" onclick="showModalCreate()"><i class="fa fa-plus"></i> Thêm mới</button>
            </div>
        </div>
        <div class="row mt-5">
            <div class="col-md-12">
                <table class="table table-success table-striped table-hover table-bordered" id="tblExportUser">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Họ và tên</th>
                            <th>Tiểu sử</th>
                            <th>Chức năng</th>
                        </tr>
                    </thead>
                    <tbody id="tblAuthor">
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
<!-- Modal -->
<div class="modal fade" id="modalAuthor" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel"></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="" id="formAuthor">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-4">
                            <label for="">Họ và tên</label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" name="name" class="form-control" id="nameAuthor">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-4">
                            <label for="">Tiểu sử</label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" name="biography" class="form-control" id="biographyAuthor">
                        </div>
                    </div>
                </div>
                <input id="authorId" type="text" style="display: none" name="id" value="0"/>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                    <button type="button" onclick="saveAuthor()" class="btn btn-primary">Lưu</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="components/foot.jsp" %>
<script type="text/javascript">
    $(document).ready(() => {
        getListAuthor();
    })

    const getListAuthor = () => {
        $("#tblAuthor").children().remove();
        $.ajax({
            url: '/eCommerce/admin/getListAuthor',
            data: {name: $('#searchName').val()},
            type: 'GET',
            success: (res) => {
                if (res.success) {
                    let count = 0;
                    res.data.forEach((element) => {
                        count++;
                        let raw = "<tr><td>" + count + "</td><td>" + element.name + "</td><td>" + element.biography + "</td><td> <i class='fa fa-edit cursor-pointer' onclick='showModalEdit(" + element.id + ")'></i> <i class='fa fa-trash text-danger ms-3 cursor-pointer' onclick='deleteAuthor(" + element.id + ")'></i> </td></tr>";
                        $('#tblAuthor').append(raw)
                    })
                }
            }
        })
    }
    const showModalEdit = async (id) => {
        const item = await getByIdAuthor(id)
        console.log(item)
        $('#nameAuthor').val(item.name)
        $('#biographyAuthor').val(item.biography)
        $('#authorId').val(item.id)
        $('#exampleModalLabel').html('Chỉnh sửa tác giả')
        $('#modalAuthor').modal('show')
    }
    const showModalCreate = () => {
        $('#exampleModalLabel').html('Thêm mới tác giả')
        $('#modalAuthor').modal('show')
    }
    const saveAuthor = () => {
        $.ajax({
            url: '/eCommerce/admin/saveAuthor',
            data: $('#formAuthor').serialize(),
            type: 'POST',
            success: (res) => {
                if (res.success) {
                    toastr.success("Lưu thành công");
                    $('#authorId').val(0)
                    getListAuthor();
                    $('#modalAuthor').modal('hide')
                } else {
                    toastr.error(res.message);
                }
            }
        });
    }
    const getByIdAuthor = async (id) => {
        let item;
        await $.ajax({
            url: '/eCommerce/admin/getByIdAuthor',
            data: {id: id},
            type: 'GET',
            success: (res) => {
                if (res.success) {
                    item = res.data[0];
                }
            }
        })
        return item
    }
    const deleteAuthor = (id) => {
        Swal.fire({
            title: "Bạn có chắc chắn muốn xóa đơn hàng?",
            text: "Bạn sẽ không thể lấy lại được dữ liệu này!",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Đồng ý!",
            cancelButtonText: "Hủy",
        }).then(async (result) => {
            if (result.isConfirmed) {
                const author = await getByIdAuthor(id)
                $.ajax({
                    url: "/eCommerce/admin/deleteAuthor",
                    data: author,
                    type: "POST",
                    success: (res) => {
                        getListAuthor();
                    },
                });
            }
        });
    }
</script>

