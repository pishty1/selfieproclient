<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:daddy pageNumber='1'>
	<div class="col-lg-12">
		<div class="page-header">
			<h1 id="navbar">this is your pen</h1>
		</div>
		<div class="row">
			<div class="col-lg-12">
            <div class="well">
              <form class="bs-example form-horizontal">
                <fieldset>
                  <div class="form-group">
                    <label for="textArea" class="col-lg-1 control-label">write</label>
                    <div class="col-lg-11">
                      <textarea class="form-control" rows="20" id="textArea"></textarea>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="price" class="col-lg-2 control-label">the reward</label>
                    <div class="col-lg-2">
                      <input type="text" class="form-control" id="price" placeholder="price">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="select" class="col-lg-2 control-label">Selects</label>
                    <div class="col-lg-10">
                      <select class="form-control" id="select">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                      </select>
                      <br>
                      <select multiple="" class="form-control">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                      </select>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                      <button class="btn btn-default">Cancel</button> 
                      <button type="submit" class="btn btn-primary">Submit</button> 
                    </div>
                  </div>
                </fieldset>
              </form>
            </div>
          </div>
		</div>
	</div>
</t:daddy>