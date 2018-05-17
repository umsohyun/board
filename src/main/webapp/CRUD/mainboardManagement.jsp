<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>게시판</title>

    <link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath }/css/dashBoard.css" rel="stylesheet">
  <%@include file="/include/commonCss.jsp" %>
  <%@include file="/include/jquery.jsp" %>
  <script>
  $(function(){
	  $('.mainBoardBtn').click(function(){
		  var value = $(this).val();
		  $('#input').val(value);
		  $('#frm').submit();
	  })
	  
	  $('#MainBoardManagement').click(function(){
		  document.location = "${pageContext.request.contextPath }/CRUD/mainboardManagement.jsp";
	  })
	  
	  $('#MainBoardInsert').click(function(){
		  document.location = "${pageContext.request.contextPath }/CRUD/mainboardInsert.jsp";
	  })
	  
	  $('.MainBoardDelete').click(function(){
		  var value = $(this).val();
		  $('#input2').val(value);
		  $('#frmboard').submit();
	  })
	  
  })
  </script>
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

		<form id="frm" method="get" action="${pageContext.request.contextPath }/MainBoardServlet">
			<input type="hidden" id="input" name="input"> 
		</form>
		
		<form id="frmboard" method="get" action="${pageContext.request.contextPath }/MainBoardIManagementServlet">
			<input type="hidden" id="input2" name="input2"> 
		</form>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
			<!-- 사이드에 게시판 List 출력 -->
			<c:forEach items="${list }" var="mainBoard">
            	<li><button class="mainBoardBtn" name="mainBoardNo2" value="${mainBoard.main_board_no}" >${mainBoard.main_board_name}</button></li>
          	</c:forEach>
          		<button id="MainBoardManagement" type="button">게시판 관리</button>
          </ul>
        </div>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
         		 <h2 id="h2" class="sub-header">게시판 관리</h2>
          
          <div class="table-responsive">
            <table id="noticeList" class="table table-striped table-hover">
              <thead>
                <tr>
                  <th style="text-align:center">게시판 이름</th>
                  <th style="text-align:center">활성화(N)/비활성화(Y)</th>
                  <th style="text-align:center">게시판 등록자</th>
                  <th style="text-align:center">게시판 삭제</th>
                </tr>
              </thead>
              <tbody>
              <!-- 메인 보드에 게시판List 출력 -->
              	<c:forEach items="${list}" var="mainboard">
	                <tr>
	                  <td>${mainboard.main_board_name}</td>
	                  <td style="text-align:center">${mainboard.main_board_del}</td>
	                  <td style="text-align:center">${mainboard.main_board_mem_id}</td>
	                  <td style="text-align:center">
	                  	<button type="button" name="mainBoardNo3" value="${mainboard.main_board_no}" class="MainBoardDelete" style="text-align:center">삭제</button>
	                  </td>
	                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
          	<button id="MainBoardInsert" type="button" class="btn btn-default" style="float:right">게시판 등록</button>
        </div>
      </div>
    </div>

     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
