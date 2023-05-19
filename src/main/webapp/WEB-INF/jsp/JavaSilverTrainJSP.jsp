<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<%@ page import="model.SilverTrainBeans" %>
<%
//リクエストスコープに保存されたBeansのインスタンスを取得
SilverTrainBeans stBeans = (SilverTrainBeans) request.getAttribute("stBeans");
/* SilverTrainBeans stBeans = (SilverTrainBeans) session.getAttribute("stBeans"); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SilverTrainingApplication</title>

<!-- reset.css modern-css-reset -->
<!-- <link rel="stylesheet" href="css/reset.css"/> -->
<link rel="stylesheet" href="css/SilverTrainJSP.css">
<link rel="stylesheet" href="css/min.css">

<!-- モーダルウィンドウの表示に使うJavaScript -->
<script src="js/SilverTrainJSP.js"></script>
</head>

<body>
		<h1>Java Silver SE11 トレーニングアプリ</h1>
		<p class ="modalLink"><a href="#info" class="modal-open">もう一度説明を見る</a></p>
	<section>
		<section id="info">
			<h2>このアプリの説明</h2>
			<p class="word">
				こちらのアプリはJava Silver SE11の勉強アプリとなっております。<br>
				黒本をお持ちの方は是非活用してみてください<br>
				<br>
				ページを読み込むと問題がランダムに出題されます。<br>
				その問題が正解だった場合[正解]<br>
				不正解だった場合は[不正解]をこのアプリに申告してください<br>
				最終的な正答率とあなたの間違った問題をこのアプリが覚えておいてくれます。<br>
				<br>
				合格を目指して一緒に頑張りましょう！<br>
			</p>
		</section>
	<!-- </section>/area1 -->

<!-- <section> -->
	<h2>問題を出題します。</h2>
	<p class="word">現在<%= stBeans.getMarathon() %>問目</p>
	<h2><%= stBeans.getQuestion() %></h2>
	<form method="post" action="/JavaSilverApp/silverTrainServlet">
	  <button type="submit" name="choice" value="1">○正解</button>
	  <button type="submit" name="choice" value="2">×不正解</button><br>
	  <button type="submit" name="choice" value="3">結果を表示</button><br>
	  <button type="submit" name="choice" value="4" id="close-button">終了する</button>
	</form>
	<img src="images/JavaSilverAppMain.svg" alt="JavaSilverAppMain">
</section>

<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/js/modaal.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<script src="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/9-6-1/js/9-6-1.js"></script>
</body>
</html>
