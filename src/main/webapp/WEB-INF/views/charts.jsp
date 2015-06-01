<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Poll Result</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" media="screen" />
<link href="<c:url value="/resources/css/cerulean.bootstrap.min.css" />"
	rel="stylesheet" media="screen" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.10.2.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/highcharts.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/exporting.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/custom-chart.js" />"></script>

<script type="text/javascript">
	var contextPath = '<c:out value="${pageContext.request.contextPath}"/>';
	$(document).ready(
			function() {
				getRemoteDataDrawChart(contextPath + 'chart',
						createNewChart('chart-container'));

			});
</script>
</head>
<body>
	<div id="wrap">
				<!-- CONTAINER -->
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-danger">
						<div class="panel-heading">
							<h3 class="panel-title">Highchart Chart</h3>
						</div>
						<div id="chart-container"
							style="min-width: 300px; max-width: 500px; height: 300px; margin: 0 auto"></div>
					</div>
				</div>
			</div>


		</div>
		<!--/CONTAINER -->
		<div id="push"></div>
	</div>
	<!--/WRAP -->



</body>
</html>
