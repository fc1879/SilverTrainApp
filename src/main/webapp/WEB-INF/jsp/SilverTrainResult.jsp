<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.SilverTrainBeans" %>
<%
//リクエストスコープに保存されたBeansのインスタンスを取得
/* SilverTrainBeans stBeans = (SilverTrainBeans) request.getAttribute("stBeans"); */
SilverTrainBeans stBeans = (SilverTrainBeans) session.getAttribute("stBeans");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果を表示</title>
<link rel="stylesheet" href="css/SilverTrainJSP.css">
<link rel="stylesheet" href="css/min.css">
</head>
<body>
	<h1>Java Silver SE11 トレーニングアプリ</h1>
		<section class ="fadeIn">
			<% switch(stBeans.getChoice()) { 
			    case "3": %>
			    	<h2>現在の結果</h2>
			        <% break;
			    case "4": %>
			    	<h2>最終結果</h2>
			        <% break;
			    default: %>
			        <h2>不正な操作が行われました。</h2>
			        <% break;
			} %>
			正答率：<%= stBeans.getRate() %>％<br>
			<br>
			正解数：<%= stBeans.getCorrect() %><br>
			<br>
			正解した問題<br>
				<% if (stBeans.getCorrectListAsString() != "該当する問題はありませんでした") { %>
					<div class="result-box">
						<%= stBeans.getCorrectListAsString() %>
					</div>
				<% } else {%>
						<%= stBeans.getCorrectListAsString() %>
				<% } %>
			<br>
			
			不正解数：<%= stBeans.getIncorrect() %><br>
			<br>
			
			不正解だった問題<br>
				<% if (stBeans.getIncorrectListAsString() != "該当する問題はありませんでした") { %>
				<div class="result-box">
					<%= stBeans.getIncorrectListAsString() %><br>
				</div>
				<% } else {%>
					<%= stBeans.getIncorrectListAsString() %><br>
				<% } %>
			<br>
			<% switch(stBeans.getChoice()) { 
			    case "3": %>
			        <button class="back-btn" onclick="location.href='/JavaSilverApp/silverTrainServlet'">戻る</button>
			        <% break;
			    case "4": %>
			        <button onclick="closeWindow()">終了する</button>
			        <% break;
			    default: %>
			        <p>不正な操作が行われました。</p>
			        <% break;
			} %>
		</section>
		<img src="images/booksResult.svg" alt="booksResult">
</body>
</html>