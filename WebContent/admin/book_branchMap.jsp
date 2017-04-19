<%@page import="com.lms.model.BookMstBO"%>
<%@page import="com.lms.model.BranchBO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	}, 5000); // <-- time in milliseconds
});

</script>
</head>
<body>
<div class="main">
<!-- header start -->
<%@ include file="/commonjsps/adminafterloginheader.jsp" %>
  <!--   header ends -->
  <div class="content">
    <div class="content_resize">
    
    <div class="sidebar">
        <div class="gadget">
<!--           <h2 class="star"><span>Sidebar</span> Menu</h2> -->
          <div class="clr"></div>
          <%@include file="/admin/adminleftmenu.jsp" %>
        </div>
        
      </div>
      
      <div class="mainbar">
        <div class="article">
        <h2 align="center">Book - Branch Map</h2>
<form method="post" action="<%=request.getContextPath() %>/AddBranchbook">
<table align="center">
<tr>
	<td style="font-weight: bold;">Select Branch: </td>
		<td><select name="branch" id="branch" style="width: 172px;height:27px;">
		<option value="select">--Select--</option>
		<% if(null != request.getAttribute("list")){
			List<BranchBO> list = (List<BranchBO>) request.getAttribute("list");
			for(BranchBO b : list){
			%>
			<option value="<%= b.getBranch_id()%>"><%= b.getBranch_name()%></option>
		<%}} %>
		</select>
	</td>
</tr>
<tr><td style="padding-top: 5px;"></td></tr>
<tr>
	<td style="font-weight: bold;"> Select Book : </td>
	<td> <select  name="books" id="books" style="width: 172px;height:27px;">
	<option value="select">--Select--</option>
		<% if(null != request.getAttribute("list1")) {
			List<BookMstBO> list1 = (List<BookMstBO>) request.getAttribute("list1");
			for(BookMstBO b : list1){
		%>
		<option value="<%= b.getBook_id()%>"> <%= b.getBook_title() %> (<%=b.getPublication_date() %>) </option>
		<%}
		} %>
		</select>
	</td>
</tr>
<tr><td style="padding-top: 5px;"></td></tr>
<tr>
	<td style="font-weight: bold;"> Enter Number Of Copies : </td>
	<td> <input type="text" name="copies" id="copies" required/></td>
</tr>

<!-- <tr>
	<td> Available Copies : </td>
	<td> <input type="text" name="avcopies" id="avcopies"/></td>
</tr> -->

<tr align="center">
	<td colspan="2" style="padding-top: 20px;"> <input class="button button-3d button-primary button-rounded" type="submit" value="Add" /></td>
</tr>
</table>
</form>

<%if(null != request.getAttribute("msg")){ %>
<div align="center" id="msg" style="font-weight: bold;font-size: 17px;"><%= request.getAttribute("msg") %></div>
<%} %>

         
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
 
</div>
</body>
</html>



