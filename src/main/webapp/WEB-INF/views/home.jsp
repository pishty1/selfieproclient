<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:daddy pageNumber='2'>
	<div class="col-lg-12">
		<div class="page-header">
			<h1 id="navbar">Welcome To Our Store</h1>
		</div>
	</div>
	<div class="bs-example">
		<div class="bs-docs-section">
			<div class="row">
				<c:forEach var="product1" items="${products}" varStatus="counter">
		          <div class="col-lg-4">
		            <div class="bs-component well">
		            	${product1.name}
		            	<img alt="" src="${product1.imageUrl}">
		            </div>
		          </div>
				</c:forEach>
	        </div>
		</div>
	</div>
</t:daddy>