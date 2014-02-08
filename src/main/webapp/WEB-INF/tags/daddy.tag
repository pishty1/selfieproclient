<%@tag description="daddy tag" pageEncoding="UTF-8"%>
<%@attribute name="pageNumber" required="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css" />
<link rel="stylesheet/less" type="text/css" href="resources/css/template.less" />
<title>Let the bidding begin ...</title>
</head>
<body>

	<div class="container">
		<div class="navbar navbar-default">
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  <a class="navbar-brand" href="bidwithcoins">home</a>
                </div>
                <div class="navbar-collapse collapse navbar-responsive-collapse">
                  <ul class="nav navbar-nav">
                    <li class="${pageNumber == 1 ? 'active' : ''}"><a href="pen" >pen</a></li>
                    <li class="${pageNumber == 2 ? 'active' : ''}"><a href="brush" >brush</a></li>
                  </ul>
                  <ul class="nav navbar-nav navbar-right">
                  	<li class="${pageNumber == 3 ? 'active' : ''}"><a href="account" >account</a></li>
                    <li class="${pageNumber == 4 ? 'active' : ''}"><a href="sign" >signin</a></li>
                    <li class="${pageNumber == 5 ? 'active' : ''}"><a href="signup" >signup</a></li>
                  </ul>
                </div><!-- /.nav-collapse -->
              </div>
	<jsp:doBody/>
	</div>
	<script src="resources/js/less.js" type="text/javascript"></script>
</body>
</html>