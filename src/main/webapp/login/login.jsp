<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/login.css" rel="stylesheet">
  <%@include file="/include/jquery.jsp" %>
  <%@include file="/include/jscookie.jsp" %>
  <script>
	$(function(){
		$('#signinbtn').click(function(){
			$('#frm').submit();
		})
	})
  
  </script>
  </head>

  <body>

    <div class="container">
	
      <form id="frm" class="form-signin" action="<%=request.getContextPath()%>/Login" method=post>
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputId" class="sr-only">ID</label>
        <input type="text" id="inputId" name="userId" class="form-control" placeholder="아이디를 입력해주세요" required autofocus>
        
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="password" class="form-control" placeholder="비밀번호를 입력해주세요" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" id="remember" value="remember-me"> Remember me
          </label>
        </div>
        <button id="signinbtn" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
<!--         <input type="hidden" id="boardNo" name="mainBoardNo" value="1"> -->
      </form>

    </div>

    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
