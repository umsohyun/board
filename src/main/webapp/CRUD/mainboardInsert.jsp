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
	  
	  $('#mainBoardInsertCom').click(function(){
		  $('#frm2').submit();
		  alert("게시판등록이 완료되었습니다.");
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

<!-- ------------------------------------------------------------------------------------------------------------------------------- -->
  
		<form id="frm" method="get" action="${pageContext.request.contextPath }/MainBoardServlet">
			<input type="hidden" id="input" name="input"> 
		</form>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
			<!-- 게시판 List 출력 -->
			<c:forEach items="${list }" var="mainBoard">
            	<li><button class="mainBoardBtn" name="mainBoardNo2" value="${mainBoard.main_board_no}" >${mainBoard.main_board_name}</button></li>
          	</c:forEach>
          		<button id="MainBoardInsert" type="button">게시판 생성</button>
          </ul>
        </div>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <form id="frm2" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/MainBoardIManagementServlet" method="post">

					<div class="form-group">
						<label for="mainBoardName" class="col-sm-2 control-label">게시판 이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mainBoardName" name="mainBoardName" placeholder="게시판 이름을 입력해주세요">
						</div>
					</div>

					<div class="form-group">
						<label for="mainBoardReg" class="col-sm-2 control-label">게시판 사용유무</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mainBoardReg" name="mainBoardReg" placeholder="N 또는 Y를 입력해주세요">
						</div>
					</div>

					<div class="form-group">
						<label for="mainBoardCreator" class="col-sm-2 control-label">게시판 등록자</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mainBoardCreator" name="mainBoardCreator" placeholder="게시판 등록자" value="${userId }">
						</div>
					</div>
				</form>
				<button id="mainBoardInsertCom" type="button" class="btn btn-default" style="float:right">게시판 등록하기</button>
        </div>
      </div>
    </div>

     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
