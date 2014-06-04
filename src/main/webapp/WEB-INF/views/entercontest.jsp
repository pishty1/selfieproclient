<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:daddy pageNumber='2'>
	<div class="col-lg-12">
		<div class="page-header">
			<h1 id="navbar">Purchase Product</h1>
		</div>
	</div>
	<div class="bs-example">
		<div class="bs-docs-section">
			<div class="row">
		          <div class="col-lg-12">
		            <div class="well">
		            	<div class="row">
			            	<div class="col-lg-4">
				            	<h1>purchase product and enter contest page</h1>
				            	<h2>payment details</h2>
			            	</div>
			            	
			            	<div class="col-lg-4">
			            		<div class="row">
			            			<a href="/contest/${contestId}/part/${fbUserId}" ><button type="button" class="btn btn-primary btn-lg">Buy and Enter contest</button></a>
			            		</div>
			            	</div>
		            	</div>
		            </div>
		          </div>
	        </div>
		</div>
	</div>
</t:daddy>