<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="header.jsp" /> 
<div class="row">
	<div class="GridCol1 col_xl grid clearfix d-flex justify-content-center" style="min-height: 400px; margin-top: -2px">
		<center>Welcome <b>${tenantDetails}</b> client in our Multi Tenant environment</center> 
	</div>
	<!-- End GridCol1 col_xl grid clearfix"> -->
</div>
<jsp:include page="footer.jsp" /> 