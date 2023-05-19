<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java SE11 Silver Training Application</title>

<!-- reset.css destyle -->
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/destyle.css@1.0.15/destyle.css"/> -->
<link rel="stylesheet" href="css/SilverTrainTop.css">
</head>

<body>
	<h1>Java Silver SE11 トレーニングアプリ</h1>
	<div id="wrapper">
		<a href="/JavaSilverApp/silverTrainServlet" class ="fadeIn sample-img">
			<img src="images/JavaSilverApp.svg" alt="JavaSilverApp" class="center" style="width: 200px; height: 200px;">
		</a>
	  <canvas id="waveCanvas"></canvas>
	</div><!--/wrapper-->
	
	<script src="js/SilverTrainTop.js"></script>
</body>
</html>
