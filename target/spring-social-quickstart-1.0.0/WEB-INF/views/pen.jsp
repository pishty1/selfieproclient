<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:daddy pageNumber='1'>
	<div class="col-lg-12">
		<div class="page-header">
			<h1 id="navbar">this is your pen</h1>
		</div>
		<div class="row">
			<div class="col-lg-12">
            <div class="well">
              <form:form class="bs-example form-horizontal" modelAttribute="Pen" action="submitw" method="GET">
                <fieldset>
                  <div class="form-group">
                    <form:label for="textArea" class="col-lg-1 control-label" path="write">write</form:label>
                    <div class="col-lg-11">
                      <form:textarea class="form-control" rows="20" id="textArea" path="write"></form:textarea>
                    </div>
                  </div>
                  <div class="form-group">
                    <form:label for="price" class="col-lg-2 control-label" path="reward">the reward</form:label>
                    <div class="col-lg-2">
                      <form:input type="text" class="form-control" id="price" placeholder="in bitcoins" path="reward" />
                    </div>
                  </div>
                  <div class="form-group">
                    <form:label for="minentries" class="col-lg-2 control-label" path="minEntries">min entries</form:label>
                    <div class="col-lg-2">
                      <form:input type="text" class="form-control" id="minentries" placeholder="min entries"  path="minEntries"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                      <button class="btn btn-default">Cancel</button> 
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