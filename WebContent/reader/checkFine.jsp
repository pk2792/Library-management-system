<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.lms.model.FineBO"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>LMS</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath() %>/blue_shuffle_template_808/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/cufon-yui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/arial.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/cuf_run.js"></script>
<link href="<%=request.getContextPath() %>/datatable/jquery.dataTables.min.css" rel="stylesheet"  type="text/css" />
<script src="<%=request.getContextPath() %>/datatable/jquery-1.12.0.min.js"></script>
<script src="<%=request.getContextPath() %>/datatable/jquery.dataTables.min.js"></script>
<script>
$(document).ready(function(){
	$("#books").DataTable();
});
</script>

</head>
<body>
<div class="main">
<!-- header start -->
<%@ include file="/commonjsps/readerheader.jsp" %>
  <!--   header ends -->
  <div class="content">
    <div class="content_resize">
    
    <div class="sidebar">
        <div class="gadget">
<!--           <h2 class="star"><span>Admin</span> Functionalities</h2> -->
          <div class="clr"></div>
          <%@include file="/reader/readerleftmenu.jsp" %>
        </div>
        
      </div>
      
      <div class="mainbar">
        <div class="article">
          <h2 align="center">Books Borrowed and Corresponding Fine</h2>
          <br/><br/>
          <%if(null != request.getAttribute("books")){
        	  List<FineBO> list = (List<FineBO>) request.getAttribute("books");%>
          <table align="center" class="display" id="books">
          	<thead>
          		<tr>
          			<th>Sr No.</th>
          			<th>Book Title (Publisher)</th>
          			<th>Author</th>
          			<th>Branch Name</th>
          			<th>Borrow Date</th>
          			<th>Fine</th>
          		</tr>
          	</thead>
          	<tbody>
          	<%int i=1;for(FineBO f : list){ 
          	float fine = (float) f.getFine();%>
          	<tr>
          		<td><%=i++ %></td>
          		<td><%=f.getBook_title() %> (<%=f.getPubname() %>)</td>
          		<td><%=f.getAuthorfname() %>&nbsp;<%=f.getAuthorlname() %></td>
          		<td><%=f.getBranch_name() %></td>
          		<td><%=f.getBorrowdate() %></td>
          		<td><%=fine %> $</td>
          	</tr>
          	<%} %>
          	</tbody>
          </table>
          <%} %>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
 
  <div class="footer">
    <div class="footer_resize">
      <p class="lf">&copy; Copyright <a href="#">MyWebSite</a>.</p>
      <div class="clr"></div>
    </div>
  </div>
</div>
</body>
</html>
