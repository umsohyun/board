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
	  
	  $('#boardCreate').click(function(){
// 		  var value = $(this).val();
		  if(<%=request.getParameter("input")%> == null){
			 document.location = "${pageContext.request.contextPath }/CRUD/boardInsert.jsp?input="+<%=request.getAttribute("mainboardnoString")%>;
		  }else{
		 	 document.location = "${pageContext.request.contextPath }/CRUD/boardInsert.jsp?input="+<%=request.getParameter("input")%>;
		  }
	  })
	  
	  $('#MainBoardManagement').click(function(){
		  document.location = "${pageContext.request.contextPath }/CRUD/mainboardManagement.jsp";
	  })
	  
	  $('#noticeList tr').click(function(){
		//this -> tr태그
			var inputTitle = $(this).find("td:eq(0)").text();
			var inputContent = $(this).find("td:eq(1)").text();
			var inputReg_id = $(this).find("td:eq(2)").text();
			var inputSeqNo = $(this).find('#boardSeqNo').val();
			//input태그에 값을 저장
			$("#inputSeqNo").val(inputSeqNo);
			$("#inputTitle").val(inputTitle);
			$("#inputContent").val(inputContent);
			$("#inputReg_id").val(inputReg_id);
			//form 전송
			$("#frm2").submit();
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
		
		<form id="frm2" method="post" action="${pageContext.request.contextPath }/BoardFormServlet">
			<input type="hidden" id="inputSeqNo" name="inputSeqNo">
			<input type="hidden" id="inputTitle" name="inputTitle">
			<input type="hidden" id="inputContent" name="inputContent"> 
			<input type="hidden" id="inputReg_id" name="inputReg_id"> 
		</form>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
			<!-- 게시판 List 출력 -->
			<c:forEach items="${list }" var="mainBoard">
            	<li><button class="mainBoardBtn" name="mainBoardNo2" value="${mainBoard.main_board_no}" >${mainBoard.main_board_name}</button></li>
          	</c:forEach>
          		<button id="MainBoardManagement" type="button">게시판 관리</button>
          </ul>
        </div>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
         		 <h2 id="h2" class="sub-header"><%=session.getAttribute("boardName") %></h2>
          
          <div class="table-responsive">
            <table id="noticeList" class="table table-striped table-hover">
              <thead>
                <tr>
                  <th style="text-align:center">제목</th>
                  <th style="text-align:center">작성자</th>
                  <th style="text-align:center">날짜</th>
                </tr>
              </thead>
              <tbody>
              <!-- 게시물List 출력 -->
              	<c:forEach items="${boardList}" var="board">
	                <tr>
	                  <td>${board.title}</td>
	                  <td style="text-align:center">${board.reg_id}</td>
	                  <td style="text-align:center"><fmt:formatDate value="${board.reg_dt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					  <input type="hidden" id="boardSeqNo" name="boardSeqNo" value="${board.board_seq }">
	                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
          	<button id="boardCreate" type="button" class="btn btn-default">게시물 등록</button>
          	${pageNav}
        </div>
      </div>
    </div>

     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
