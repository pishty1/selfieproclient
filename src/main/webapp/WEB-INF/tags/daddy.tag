<%@tag description="daddy tag" pageEncoding="UTF-8"%>
<%@attribute name="pageNumber" required="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css" />
<link rel="stylesheet/less" type="text/css" href="/resources/css/template.less" />
<title>SelfiePro Client</title>
</head>
<body>

	<div class="container">
		<div class="navbar navbar-default">
                <div class="navbar-header" role="navigation">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  <a class="navbar-brand" href="/">home</a>
                </div>
                <div class="navbar-collapse collapse navbar-responsive-collapse">
                  <ul class="nav navbar-nav">
                    <li class="${pageNumber == 1 ? 'active' : ''}"><a href="/products" >products</a></li>
                    <li class="${pageNumber == 2 ? 'active' : ''}"><a href="/contests" >contests</a></li>
                  </ul>
                  <ul class="nav navbar-nav navbar-right">
                  	<li class="${pageNumber == 6 ? 'active' : ''}"><a href="/mycontests" >my contests</a></li>
                  	<li class="${pageNumber == 3 ? 'active' : ''} dropdown">
                  	<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="admin">admin <span class="caret"></span></a>
                  	<ul class="dropdown-menu" aria-labelledby="admin">
		                <li><a href="/default/">API details</a></li>
		                <li class="divider"></li>
		                <li><a href="/admin/promote">Promote products</a></li>
		                <li><a href="/admin/contests">Create contests</a></li>
		                <li><a href="/admin/contest/list">List Contests</a></li>
              		</ul>
                  	</li>
                    <li class="${pageNumber == 4 ? 'active' : ''}"><a href="/sign" >signin</a></li>
                    <li class="${pageNumber == 5 ? 'active' : ''}"><a href="/signup" >signup</a></li>
                  </ul>
                </div><!-- /.nav-collapse -->
              </div>
	<jsp:doBody/>
	</div>
	<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
	<script src="/resources/js/dropdown.js" type="text/javascript"></script>
	<script src="/resources/js/less.js" type="text/javascript"></script>
	<script src="/resources/js/offcanvas.js" type="text/javascript"></script>
	<script src="" type="text/javascript"></script>
	<script>
		$('.dropdown-toggle').dropdown();
	</script>
</body>
</html>
