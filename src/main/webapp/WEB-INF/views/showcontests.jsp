<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:daddy pageNumber='2'>
	<div class="col-lg-12">
		<div class="page-header">
			<h1 id="navbar">Current Contests</h1>
		</div>
	</div>
	<div class="bs-example">
		<div class="bs-docs-section">
			<div class="row">
				<c:forEach var="contest" items="${contests}" varStatus="counter">
		          <div class="col-lg-12">
		            <div class="well">
		            	<div class="row">
			            	<div class="col-lg-4">
				            	<img alt="" src="${contest.product.imageUrl}">
			            	</div>
			            	<div class="col-lg-4">
			            		<div class="row">
			            			<h3>contest name: ${contest.name}</h3>
			            			<h4>product description:</h4>
			            		</div>
			            		<div class="row">
			            			<h3>${contest.currentParticipants}/${contest.maxParticipants}</h3>
			            			
			            		</div>
			            	</div>
			            	<div class="col-lg-4">
			            		<div class="row">
			            			<a href="/contests/${contest.id}" ><button type="button" class="btn btn-primary btn-lg">Buy and Enter contest</button></a>
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