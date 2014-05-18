<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:daddy pageNumber='1'>
	<div class="col-lg-12">
		<div class="page-header">
			<h1 id="navbar">submit your work</h1>
			<div class="row">
				<div class="col-lg-2">
					<form class="bs-example form-horizontal" action="submitBrush" method="POST" enctype="multipart/form-data">
    					<input type="file" name="file">
    					<input type="text" hidden="true" name="penId" value="${Pen.id}">
						<button type="submit" class="btn btn-primary">upload</button>
					</form>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
            <div class="well">
              <form:form class="bs-example form-horizontal" modelAttribute="Pen" action="submitPen" method="GET">
                <fieldset>
                  <div class="form-group">
                    <form:label for="user" class="col-lg-1 control-label" path="user">user</form:label>
                    <div class="col-lg-2">
                      <form:input type="text" class="form-control" id="minentries" placeholder="user"  path="user.id" readonly="true"/>
                    </div>
                    <form:label for="minentries" class="col-lg-2 control-label" path="minEntries">min entries</form:label>
                    <div class="col-lg-2">
                      <form:input type="text" class="form-control" id="minentries" placeholder="min entries"  path="minEntries" readonly="true"/>
                    </div>
                    <form:label for="price" class="col-lg-2 control-label" path="reward">the reward</form:label>
                    <div class="col-lg-2">
                      <form:input type="text" class="form-control" id="price" placeholder="in bitcoins" path="reward"  readonly="true"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <form:label for="textArea" class="col-lg-1 control-label" path="write">description</form:label>
                    <div class="col-lg-11">
                      <form:textarea class="form-control" rows="20" id="textArea" path="write" readonly="true"></form:textarea>
                    </div>
                  </div>
                  <div class="form-group">
                    <form:label for="price" class="col-lg-2 control-label" path="reward">the reward</form:label>
                    <div class="col-lg-2">
                      <form:input type="text" class="form-control" id="price" placeholder="in bitcoins" path="reward"  readonly="true"/>
                    </div>
                  </div>
                </fieldset>
              </form:form>
            </div>
          </div>
		</div>
	</div>
</t:daddy>