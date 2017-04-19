<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>BlueShuffle</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath() %>/datatable/jquery.dataTables.min.css" rel="stylesheet"  type="text/css" />
<link href="<%=request.getContextPath() %>/blue_shuffle_template_808/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/cufon-yui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/arial.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/blue_shuffle_template_808/js/cuf_run.js"></script>
<%-- <script src="<%=request.getContextPath() %>/scripts/jquery.min.js"></script> --%>


<script src="<%=request.getContextPath() %>/datatable/jquery-1.12.0.min.js"></script>
<script src="<%=request.getContextPath() %>/datatable/jquery.dataTables.min.js"></script>
<script>
function getbooks(a){
	if(a != "select"){
	$.ajax({
		url: "GetBooksByBranch?brid="+a, 
		success: function(result){
        	$("#books").html(result);
        	$("#booktable").DataTable();
    	}
	});
	}else{
		$("#books").html("");
	}
}

function checkout(id){
	alert(id);
	document.getElementById("hid").value = id;
	document.ck.action = "CheckoutDone";
	document.ck.submit();
}
$(document).ready(function(){
	$("#asd").DataTable();	
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
      <div class="mainbar" >
        <div class="article">
        <form name="ck" method="post">
        <input type="hidden" id="hid" name="hid"></input>
         
          <table >
          <tr>
          	<td>Select Branch : </td>
          	<td>
          		<select id="br" onchange="getbooks(this.value);">
          		<option value="select">--Select--</option>
          		<c:forEach items="${list }" var="branch">
          			<option value="${branch.branch_id }">${branch.branch_name }</option>
          		</c:forEach>
          		</select>
          	</td>
          </tr>
          </table>
          <br/>
          <br></br>
          <div id="books" align="center"></div>
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
