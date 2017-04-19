<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>LMS</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath() %>/blue_shuffle_template_808/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/cufon-yui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/arial.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/cuf_run.js"></script>
<script src="<%=request.getContextPath() %>/datatable/jquery-1.12.0.min.js"></script>
<link href="<%=request.getContextPath() %>/buttons/buttons.css" rel="stylesheet"  type="text/css" />
<script>
$(document).ready(function(){
	setTimeout(function() {
	    $('#msg').fadeOut('fast');
	}, 3000); // <-- time in milliseconds
});

</script>
<style>
@import url(http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300,700|Open+Sans:400,300,600);
* {
  box-sizing: border-box;
}
body {
  font-family: 'open sans', helvetica, arial, sans;
  background: url(http://farm8.staticflickr.com/7064/6858179818_5d652f531c_h.jpg) no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
.log-form {
     width: 40%;
    min-width: 320px;
    max-width: 475px;
    background: #fff;
    position: absolute;
    top: 70%;
    left: 57%;
  -webkit-transform: translate(-50%, -50%);
  -moz-transform: translate(-50%, -50%);
  -o-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.7);
}
@media (max-width: 40em) {
  .log-form {
    width: 95%;
    position: relative;
    margin: 2.5% auto 0 auto;
    left: 0%;
    -webkit-transform: translate(0%, 0%);
    -moz-transform: translate(0%, 0%);
    -o-transform: translate(0%, 0%);
    -ms-transform: translate(0%, 0%);
    transform: translate(0%, 0%);
  }
}
.log-form form {
  display: block;
  width: 100%;
  padding: 2em;
}
.log-form h2 {
  color: #5d5d5d;
  font-family: 'open sans condensed';
  font-size: 1.35em;
  display: block;
  background: #2a2a2a;
  width: 100%;
  text-transform: uppercase;
  padding: .75em 1em .75em 1.5em;
  box-shadow: inset 0px 1px 1px rgba(255, 255, 255, 0.05);
  border: 1px solid #1d1d1d;
  margin: 0;
  font-weight: 200;
}
.log-form input {
  display: block;
  margin: auto auto;
  width: 100%;
  margin-bottom: 2em;
  padding: .5em 0;
  border: none;
  border-bottom: 1px solid #eaeaea;
  padding-bottom: 1.25em;
  color: #757575;
}
.log-form input:focus {
  outline: none;
}
.log-form .btn {
  display: inline-block;
  background: #1fb5bf;
  border: 1px solid #1ba0a9;
  padding: .5em 2em;
  color: white;
  margin-right: .5em;
  box-shadow: inset 0px 1px 0px rgba(255, 255, 255, 0.2);
}
.log-form .btn:hover {
  background: #23cad5;
}
.log-form .btn:active {
  background: #1fb5bf;
  box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.1);
}
.log-form .btn:focus {
  outline: none;
}
.log-form .forgot {
  color: #33d3de;
  line-height: .5em;
  position: relative;
  top: 2.5em;
  text-decoration: none;
  font-size: .75em;
  margin: 0;
  padding: 0;
  float: right;
}
.log-form .forgot:hover {
  color: #1ba0a9;
}

</style>

</head>
<body>
<div class="main">
<!-- header start -->
<%@ include file="/commonjsps/header.jsp" %>
  <!--   header ends -->
  <div class="content">
    <div class="content_resize">
    
     <div class="sidebar" style="font: normal 20px Arial, Helvetica, sans-serif; !important">
        <div class="gadget" style="margin: 35px;!important">
          <h2 class="star"><span>Library</span>Functions</h2>
          <div class="clr"></div>
          <ul class="sb_menu">
            <li style="border-bottom :1px solid gray;"><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
            <li style="border-bottom :1px solid gray;"><a href="<%=request.getContextPath()%>/homepage_Search.jsp">Search Book</a></li>
            <li style="border-bottom :1px solid gray;"><a href="<%=request.getContextPath() %>/Registration.jsp">Register</a></li>
            <li style="border-bottom: 1px solid gray;background: rgba(128, 128, 128, 0.51);"><a href="<%=request.getContextPath() %>/login.jsp">Login</a></li>
          </ul>
        </div>
        
      </div>
      
      <div class="mainbar">
        <div class="article" align="center">
       <%--  <form action="Login" method="post">
          <table>
          	<tr>
          		<td style="font-weight: bold;">Enter Card-Id :</td>
          		<td><input type="text" name="username" id="username" required/></td>
          	</tr>
          	<tr>
          		<td style="font-weight: bold;">Enter Password :</td>
          		<td><input type="password" name="pass" id="pass" required/></td>
          	</tr>
          	<tr align="center">
          		<td colspan="2"><input class="button button-3d button-primary button-rounded" type="submit" value="Login"/></td>
          	</tr>
          </table>
          <br/>
          <% if(null != request.getAttribute("msg")){ %>
          <div id="msg" align="center" style="color:red;font-size: 17px;font-weight: bold;"><%=request.getAttribute("msg") %></div>
          <%} %>
          </form> --%>
          <div class="log-form">
 			 <h2>Login to your account</h2>
  			<form action="Login" method="post">
    				<input type="text" name="username" title="Card Id" placeholder="ENTER CARD-ID" required />
    				<input type="password" name="pass" title="Password" placeholder="PASSWORD" required/>
   					 <button type="submit" class="btn">Login</button>
<!--     				<a class="forgot" href="#">Forgot Username?</a> -->
<% if(null != request.getAttribute("msg")){ %>
          <div id="msg" align="center" style="color:red;font-size: 17px;font-weight: bold;"><%=request.getAttribute("msg") %></div>
          <%} %>
 			 </form>
			</div><!--end log form -->
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
</div>
</body>
</html>
