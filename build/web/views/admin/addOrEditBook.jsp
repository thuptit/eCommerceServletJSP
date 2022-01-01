<%-- 
    Document   : addOrEditBook
    Created on : Jan 1, 2022, 8:03:23 AM
    Author     : thunv
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/head.jsp" %> 
<main>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6">
                <h3 id="titlePage"></h3>
            </div>
            <div class="col-md-6 d-flex justify-content-end">
                <button class="btn btn-success" onclick="saveBook()">Lưu</button>
                <button class="btn btn-danger ms-2">Hủy</button>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-md-4">
                <div class="file-upload">
                    <div class="image-upload-wrap">
                        <input class="file-upload-input" type='file' onchange="readURL(this);" accept="image/*" id="imgBook"/>
                        <div class="drag-text">
                            <h3>Drag and drop a file or select add Image</h3>
                        </div>
                    </div>
                    <div class="file-upload-content">
                        <img class="file-upload-image" src="#" alt="your image" />
                        <div class="image-title-wrap">
                            <button type="button" onclick="removeUpload()" class="btn btn-danger">Remove <span class="image-title">Uploaded Image</span></button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="row">
                    <div class="col-md-6">
                        <label class="title-page-create">Barcode <span class="text-danger">*</span> </label>
                        <input type="text" class="form-control" id="barcode" name="barcode" />
                    </div>
                    <div class="col-md-6">
                        <label class="title-page-create">Tên sách<span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="name" name="name" />
                    </div>
                    <div class="col-md-6">
                        <label class="title-page-create">Giá<span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="price" name="price" />
                    </div>
                    <div class="col-md-6">
                        <label class="title-page-create">Giảm giá<span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="discount" name="discount" />
                    </div>
                    <div class="col-md-6">
                        <label class="title-page-create">Số trang<span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="numberOfPage" name="numberOfPage" />
                    </div>
                    <div class="col-md-6">
                        <label class="title-page-create">Mã số sách<span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="isbn" name="isbn" />
                    </div>
                    <div class="col-md-6">
                        <label class="title-page-create">Ngôn ngữ<span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="language" name="language" />
                    </div>
                    <div class="col-md-6">
                        <label class="title-page-create">Tác giả<span class="text-danger">*</span></label>
                        <select id="author" name="author" class="form-control">
                            <option selected value="" disabled="">--Chọn tác giả--</option>
                        </select>
                    </div>
                    <div class="col-md-6">
                        <label class="title-page-create">Nhà xuất bản<span class="text-danger">*</span></label>
                        <select id="publisher" name="publisher" class="form-control">
                            <option selected value="" disabled="">--Chọn nhà xuất bản--</option>
                        </select>
                    </div>
                    <div class="col-md-12">
                        <label class="title-page-create">Mô tả<span class="text-danger">*</span></label>
                        <textarea name="summary" id="summary"></textarea>
                        <script>
                            CKEDITOR.replace( 'summary' );
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<%@ include file="components/foot.jsp" %>
<script type="text/javascript">
    $(document).ready(async  () => {
        let qs = location.search.split('id=')[1];
        if (qs > 0) {
            $('#titlePage').html("Sách > <span class='text-secondary'> Chỉnh sửa sách <span>");
        }
        else{
            $('#titlePage').html("Sách > <span class='text-secondary'> Thêm mới sách <span>");
        }
        let authors = await getDropdownAuthor();
        let publishers = await getDropdownPublisher();
        addAuthorToView(authors);
        addPublisherToView(publishers);
    })
    function readURL(input) {
        if (input.files && input.files[0]) {

            var reader = new FileReader();

            reader.onload = function (e) {
                $('.image-upload-wrap').hide();

                $('.file-upload-image').attr('src', e.target.result);
                $('.file-upload-content').show();

                $('.image-title').html(input.files[0].name);
            };

            reader.readAsDataURL(input.files[0]);

        } else {
            removeUpload();
        }
    }
    function removeUpload() {
        $('.file-upload-input').replaceWith($('.file-upload-input').clone());
        $('.file-upload-content').hide();
        $('.image-upload-wrap').show();
    }
    $('.image-upload-wrap').bind('dragover', function () {
        $('.image-upload-wrap').addClass('image-dropping');
    });
    $('.image-upload-wrap').bind('dragleave', function () {
        $('.image-upload-wrap').removeClass('image-dropping');
    });
    async  function getDropdownAuthor(){
        let data = [];
        await $.ajax({
            url: '/eCommerce/admin/getDropdownAuthor',
            type: 'GET',
            success: (response) => {
                data = response.data;
            }
        })
        return data;
    }
    async  function getDropdownPublisher(){
        let data = [];
        await $.ajax({
            url: '/eCommerce/admin/getDropdownPublisher', 
            type: 'GET',
            success: (response) => {
                //console.log(response)
                data = response.data;
            }
        })
        return data;
    }
    function addAuthorToView(data){
        if(data.length > 0){
            data.forEach((element) => {
                let rawHtml = "<option value='"+element.id+"'>"+element.name+"</option>";
                $('#author').append(rawHtml);
            })
        }
    }
    function addPublisherToView(data){
        if(data.length > 0){
            data.forEach((element) => {
                let rawHtml = "<option value='"+element.id+"'>"+element.name+"</option>";
                $('#publisher').append(rawHtml);
            })
        }
    }
    async function saveBook(){
        let id = location.search.split('id=')[1];
        let urlImage = await uploadImage();
        let data = {
            id: id,
            barcode: $('#barcode').val(),
            name: $('#name').val(),
            price: $('#price').val(),
            discount: $('#discount').val(),
            numberOfPage: $('#numberOfPage').val(),
            isbn: $('#isbn').val(),
            language: $('#language').val(),
            author: $('#author').val(),
            publisher: $('#publisher').val(),
            summary: CKEDITOR.instances.summary.getData(),
            url: urlImage
        }
        $.ajax({
            url: '/eCommerce/admin/saveBook',
            data,
            type: 'POST',
            success: (res) => {
                console.log(res);
            }
        })
    }
    async function uploadImage(){
        if(!$('input[type=file]')[0].files[0]) return;
        let url;
        let formData = new FormData();
        formData.append("file", $('input[type=file]')[0].files[0]);
        formData.append("upload_preset", "vzlfb48g");
        await axios.post("https://api.cloudinary.com/v1_1/doa9q57nv/image/upload", formData).then((res)=>{
            url = res.data.url;
        });
        return url;
    }
</script>