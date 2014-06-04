<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:daddy pageNumber='1'>
	<div class="col-lg-12">
		<div class="page-header">
			<h1 id="navbar">Create a contest for a product</h1>
		</div>
	</div>
	<div class="bs-example">
		<div class="bs-docs-section">
	        <div class="row">
		        <div class="col-lg-6">
		        	<form:form action="/admin/contests/add" commandName="contest" method="post" class="form-horizontal">
		        		<fieldset>
	<%-- 						<c:if test='${errorMes eq "exists"}'> --%>
	<!-- 							<div class="form-group"> -->
	<!-- 								<div class="col-lg-11 col-lg-offset-1"> -->
	<!-- 									<h2><span class="label label-warning">client name already exists</span></h2> -->
	<!-- 								</div> -->
	<!-- 							</div> -->
	<%-- 						</c:if> --%>
							<div class="form-group">
								<form:label path="productId" for="productId" class="col-lg-3 control-label">Choose product</form:label>
								<div class="col-lg-9">
									<form:select class="form-control" path="productId" id="productId">
										<form:options items="${sfProducts}" itemValue="sfId" itemLabel="name"/>		
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<form:label path="fbPageName" for="fbPageName" class="col-lg-3 control-label">page name</form:label>
								<div class="col-lg-9">
									<form:select class="form-control" path="fbPageName" id="fbPageName">
										<form:options items="${accounts}" itemValue="id" itemLabel="name"/>		
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<form:label path="name" for="name" class="col-lg-3 control-label">name</form:label>
								<div class="col-lg-9">
									<form:input path="name" id="name" class="form-control" data-validation="required"  />
								</div>
							</div>
							<div class="form-group">
								<form:label path="maxParticipants" for="maxParticipants" class="col-lg-3 control-label">max # participants</form:label>
								<div class="col-lg-9">
									<form:input path="maxParticipants" id="maxParticipants" class="form-control" data-validation="required"  />
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-9 col-lg-offset-3">
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>
							</div>
						</fieldset>
		        	</form:form>
		        </div>
	        </div>
		</div>
	</div>
</t:daddy>