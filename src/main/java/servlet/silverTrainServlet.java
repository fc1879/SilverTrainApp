package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.SilverTrainBeans;
import model.SilverTrainLogic;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/silverTrainServlet")
public class silverTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-------------------START OF SilverTrainServlet[doGet]-------------------");
		HttpSession session = request.getSession();
		SilverTrainBeans stBeans = (SilverTrainBeans) session.getAttribute("stBeans");
			if (stBeans == null) {
			    stBeans = new SilverTrainBeans();
			    session.setAttribute("stBeans", stBeans);
			}
		SilverTrainLogic stLogic = new SilverTrainLogic();
		//問題を生成してBeansに格納し、その問題をJSPへ送る
	    String question = stLogic.generateRandomQuestion(stBeans);
	    stBeans.setQuestion(question);
	    request.setAttribute("stBeans", stBeans);
	    //JSPを表示
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/JavaSilverTrainJSP.jsp");
	    dispatcher.forward(request, response);
	    System.out.println("-------------------END OF SilverTrainServlet[doGet]-------------------");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-------------------START OF SilverTrainServlet[doPost]-------------------");
		
		HttpSession session = request.getSession();
		SilverTrainBeans stBeans = (SilverTrainBeans) session.getAttribute("stBeans");
		//JavaServletTrainJSPからユーザーの入力情報を取得
		
		String choice = request.getParameter("choice");
		//上で得たユーザーが押したボタンのデータをBeansに格納
		stBeans.setChoice(choice);
		
		SilverTrainLogic stLogic = new SilverTrainLogic();
		stLogic.userChoice(stBeans);
		
		switch (stBeans.getChoice()) {
		case "1":
		case "2":
			System.out.println("マラソンカウント前 : Marathon = " + stBeans.getMarathon());
			//問題数カウンタを起動
			stBeans.countMarathon();
			System.out.println("マラソンカウント後 : Marathon = " + stBeans.getMarathon());
			System.out.println("CASE 1&2 : Correct = " + stBeans.getCorrect());
			//ページをリダイレクトし再度doGetからやり直す
			response.sendRedirect(request.getRequestURI());
			break;
			
		case "3":
		case "4":
			stLogic.roundedRate(stBeans);
			System.out.println("CASE 3&4 : Marathon = " + stBeans.getMarathon());
			System.out.println("CASE 3&4 : Correct = " + stBeans.getCorrect());
			//結果を表示するJSPに遷移
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/SilverTrainResult.jsp");
			dispatcher.forward(request, response);
		}
		System.out.println("-------------------END OF SilverTrainServlet[doPost]-------------------");
	}
}
	
	
