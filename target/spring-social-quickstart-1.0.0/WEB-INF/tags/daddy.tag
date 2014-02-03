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
		<div class="navbar-header">
			<a href="../" class="navbar-brand">Home</a>
			<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"> </span>
			</button>
		</div>

		<div class="navbar-collapse collapse" id="navbar-main">
			<ul class="nav navbar-nav">
				<li class="${pageNumber == 1 ? 'active' : ''}"><a href="pen">Pen</a></li>
				<li class="${pageNumber == 2 ? 'active' : ''}"><a href="brush">Brush</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="${pageNumber == 3 ? 'active' : ''}"><a href="account" >Account</a></li>
				<li class="${pageNumber == 4 ? 'active' : ''}"><a href="signin">SignIn</a></li>
				<li class="${pageNumber == 4 ? 'active' : ''}"><a href="signup">SignUp</a></li>
			</ul>
		</div>
	<jsp:doBody/>
	</div>
	<script src="resources/js/less.js" type="text/javascript"></script>
</body>
</html>
