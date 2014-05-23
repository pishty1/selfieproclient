<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:daddy pageNumber='1'>
	<div class="col-lg-12">
		<div class="page-header">
			<h1 id="navbar">Promoted Products pulled from Selfiepro server</h1>
		</div>
	</div>
	<div class="bs-example">
		<div class="bs-docs-section">
			<div class="row">
				<c:forEach var="product1" items="${sfProducts}" varStatus="counter">
		          <div class="col-lg-12">
		            <div class="well">
		            	<div class="row">
			            	<div class="col-lg-4">
				            	<img alt="" src="${product1.imageUrl}">
			            	</div>
			            	<div class="col-lg-8">
			            		<div class="row">
			            			<h3>${product1.name}</h3>
			            			<h4>${product1.price}</h4>
			            		</div>
			            	</div>
		            	</div>
		            </div>
		          </div>
				</c:forEach>
	        </div>
		</div>
	</div>
</t:daddy>