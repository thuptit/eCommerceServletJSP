<%-- 
    Document   : dashboard
    Created on : Dec 19, 2021, 8:04:23 AM
    Author     : thunv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/head.jsp" %> 
<div class="row m-5">
  <div class="col-md-12">
    <div class="row">
      <div class="col-md-2" style="display: flex; justify-content: center; align-items: center; font-weight: bold;">
        <label for="">Thống kê đơn hàng</label>
      </div>
      <div class="col-md-2">
        <select name="" id="slMonth" class="form-control" onchange="statisticChart()"></select>
      </div>
      <div class="col-md-2">
        <select name="" id="slYear" class="form-control" onchange="statisticChart()"></select>
      </div>
    </div>
  </div>
</div>
<div class="row m-5 d-flex align-items-center">
  <div class="col-md-6">
    <canvas id="myChart1" style="width:100%;max-width:600px"></canvas>
  </div>
</div>
<%@ include file="components/foot.jsp" %> 