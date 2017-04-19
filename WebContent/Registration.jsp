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
<script>
$(document).ready(function(){
	setTimeout(function() {
	    $('#msg').fadeOut('fast');
	}, 10000); // <-- time in milliseconds
});

</script>
<style>
input {
  display: block;
  margin: auto auto;
  width: 100%;
  margin-bottom: 2em;
  padding: .5em 0;
  border: none;
  border-bottom: 1px solid rgba(34, 34, 34, 0.47);
  padding-bottom: 1.25em;
  color: #757575;
}
input:focus {
  outline: none;
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
            <li style="border-bottom :1px solid gray;background: rgba(128, 128, 128, 0.51);"><a href="<%=request.getContextPath() %>/Registration.jsp">Register</a></li>
            <li style="border-bottom :1px solid gray;"><a href="<%=request.getContextPath() %>/login.jsp">Login</a></li>
          </ul>
        </div>
        
      </div>
      
      <div class="mainbar">
          <h2 align="center">Registration</h2>
          <%if(null != request.getAttribute("msg")){ %>
<div id="msg" style="font-size: 17px;font-weight: bold;color: green;" align="center"><%= request.getAttribute("msg") %></div>
<%} %>
          <div align="center" style="color: red;font-size: 12px;font-weight: bold;">Note : Enter your correct email id as you will receive important notifications via mail.</div>
        <div class="article" align="center">
        <div align="center" style="width: 50%;">
      <form action="Register" method="post">
<input name="fname" type="text" id="fname" placeholder="FIRST NAME" required/>
<input name="lname" type="text" id="lname" placeholder="LAST NAME" required/>
                <input name="add" type="text" placeholder="ADDRESS" id="add" required/>
              <input name="contact" type="number"  placeholder="ENTER CONTACT NUMBER" id="contact" required/>
                <input name="email" type="text" placeholder="ENTER EMAIL-ID" id="email" required/>
               <input type="password" name="pass" placeholder="ENTER PASSWORD" value="" required/>
          	<input class="button button-3d button-primary button-rounded" type="submit" value="Register"/></td>
</form>
</div>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
</div>
</body>
</html>
