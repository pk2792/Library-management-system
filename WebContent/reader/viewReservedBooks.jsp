<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.lms.model.SearchBO"%>
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
<link href="<%=request.getContextPath() %>/buttons/buttons.css" rel="stylesheet"  type="text/css" />
<script>
$(document).ready(function(){
	$("#rb").DataTable();
});

function submitdata(){
	var a = $("#cks:checked").length;
	if(a > 0){
	if(confirm("Are you sure ?")){
		document.checkout.action = "<%=request.getContextPath()%>/CheckOutFromReserve";
		document.checkout.submit();
	}
	}else{
		alert("Please select atleast one Book !!!");
	}
}
</script>
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
          <h2 align="center">My Reserved Books</h2>
          <div align="center" style="color: red;font-weight: bold;">NOTE : You must checkout your reserved books before 18:00 otherwise your reservation will be cancelled.</div>
        <br/>
        <%if(null != request.getAttribute("msg")){ %>
        	<h3 id="msg" align="center" style="color: green;"><%=request.getAttribute("msg") %></h3>
        <%} %>
        <form name="checkout" method="post">
        <%if(null != request.getAttribute("list")){ 
        	List<SearchBO> list = (List<SearchBO>) request.getAttribute("list");
        %>
        <table class="display" width="100%" id="rb">
        <thead>
        	<tr>
        		<th>Book Id</th>
        		<th>Book Title</th>
        		<th>Branch Name</th>
        		<th>Status</th>
        		<th>Action</th>
        	</tr>
        </thead>
        <tbody>
        <%for(SearchBO s : list){ %>
        	<tr>
        		<td><%=s.getBook_id() %></td>
        		<td><%=s.getBook_title() %></td>
        		<td><%=s.getBranch_name() %> (<%=s.getBranch_location() %>)</td>
        		<td><%=s.getAuthorfname().toUpperCase() %></td>
        		<td>
        		<%if(s.getAuthorfname().equalsIgnoreCase("reserve")){ %>
        		<input type='checkbox' id='cks' value='<%=s.getBook_id()%>/<%=s.getBranch_id()%>/<%=s.getBorrow_id()%>' name='checkouts'/>
        		<%} %>
        		</td>
        	</tr>
        <%} %>
        </tbody>
        </table>
        <div align="center"><input class="button button-3d button-primary button-rounded" type='button' value='Checkout' onclick='submitdata();'/></div>
        <%}else{ %>
        <br/><br/>
        <div align="center" style="color: red;font-weight: bold;">You haven't reserved any books.</div>
        <%} %>
        <br/>
        </form>
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
