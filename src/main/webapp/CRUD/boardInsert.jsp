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
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
  <script src="${pageContext.request.contextPath }/SE2/js/HuskyEZCreator.js"></script>
  <script type="text/javascript">
  var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

  $(document).ready(function() {
  	// Editor Setting
  	nhn.husky.EZCreator.createInIFrame({
  		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
  		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
  		sSkinURI : "${pageContext.request.contextPath }/SE2/SmartEditor2Skin.html", // Editor HTML
  		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
  		htParams : {
  			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
  			bUseToolbar : true,
  			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
  			bUseVerticalResizer : true,
  			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
  			bUseModeChanger : true, 
  		}
  	});
  	
  	 $('.mainBoardBtn').click(function(){
		  var value = $(this).val();
		  $('#input').val(value);
		  $('#frm').submit();
	  })
	  
	  $('#MainBoardManagement').click(function(){
		  document.location = "${pageContext.request.contextPath }/CRUD/mainboardManagement.jsp";
	  })

  	// 전송버튼 클릭이벤트
  	$("#savebutton").click(function(){
  		if(confirm("저장하시겠습니까?")) {
  			// id가 smarteditor인 textarea에 에디터에서 대입
  			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

  			// 이부분에 에디터 validation 검증
  			if(validation()) {
  				$('#input3').val(<%=request.getParameter("input")%>);
  				$("#frm2").submit();
  			}
  		}
  	})
  });

  // 필수값 Check
  function validation(){
  	var contents = $.trim(oEditors[0].getContents());
  	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
  		alert("내용을 입력하세요.");
  		oEditors.getById['smarteditor'].exec('FOCUS');
  		return false;
  	}

  	return true;
  }
  
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
          		<button id="MainBoardManagement" type="button">게시판 관리</button>
          </ul>
        </div>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
         <h2 id="h2" class="sub-header"><%=session.getAttribute("boardName") %></h2>
          <form id="frm2" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/BoardManagementServlet" method="post" enctype="multipart/form-data">
					<input type="hidden" id="input3" name="input3" value="<%=request.getAttribute("mainboardnoString") %>">
					
					<div class="form-group">
						<label for="boardTitle" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-4" >
							<input type="text" class="form-control" id="boardTitle" name="boardTitle" placeholder="제목을 입력해주세요">
						</div>
					</div>
					
				<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;"></textarea> 
					<input type="file" class="fileInsert" name="uploadfile" value="첨부파일1" />
					<input type="file" class="fileInsert" name="uploadfile" value="첨부파일2" />
					<input type="file" class="fileInsert" name="uploadfile" value="첨부파일3" />
					<input type="file" class="fileInsert" name="uploadfile" value="첨부파일4" />
					<input type="file" class="fileInsert" name="uploadfile" value="첨부파일5" />
				</form>
				
				<div style="text-align:center;width:55%">
					<input type="button" id="savebutton" class="btn btn-default" value="게시물 등록하기" />
				</div>
        		
        </div>
      </div>
    </div>

     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
