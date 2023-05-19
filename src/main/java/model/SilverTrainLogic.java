package model;

import java.util.ArrayList;
import java.util.List;

public class SilverTrainLogic {
	
	public double roundedRate(SilverTrainBeans stBeans) {
		System.out.println("----Start of roundedRate----");
		double marathon = stBeans.getMarathon() - 1;
		System.out.println(marathon);
		double correct = stBeans.getCorrect();
		double rate = correct / marathon;
		double roundedRate = (Math.round( rate *100.0)/100.0) * 100.0;
		stBeans.setRate(roundedRate);
		return roundedRate;
	}
	
	//ランダムに問題を生成するメソット
	public String generateRandomQuestion(SilverTrainBeans stBeans) {
		System.out.println("-------------------START OF SilverTrainLogic : generateRandomQuestion()-------------------");
	    int syou = (int) Math.ceil(Math.random() * 13);
	    int toi;
	    String question = null;
	    
	    switch (syou){
            case 1:
                toi = (int) Math.ceil(Math.random() * 8);
                question = syou + "章の" + toi + "問目";
                System.out.println("case [1]:" + question);
                stBeans.setQuestion(question);
                break;

            case 2:
                toi = (int) Math.ceil(Math.random() * 22);
                question = syou + "章の" + toi + "問目";
                System.out.println("case [2]:" + question);
                stBeans.setQuestion(question);
                break;

            case 3:
                toi = (int) Math.ceil(Math.random() * 21);
                question = syou + "章の" + toi + "問目";
                System.out.println("case [3]:" + question);
                stBeans.setQuestion(question);
                break;

            case 4:
                toi = (int) Math.ceil(Math.random() * 17);
                question = syou + "章の" + toi + "問目";
                System.out.println("case[4] :" + question);
                stBeans.setQuestion(question);
                break;

            case 5:
                toi = (int) Math.ceil(Math.random() * 10);
                question = syou + "章の" + toi + "問目";
                System.out.println("case [5]:" + question);
                stBeans.setQuestion(question);
                break;

            case 6:
                toi = (int) Math.ceil(Math.random() * 30);
                question = syou + "章の" + toi + "問目";
                System.out.println("case [6]:" + question);
                stBeans.setQuestion(question);
                break;

            case 7:
                toi = (int) Math.ceil(Math.random() * 21);
                question = syou + "章の" + toi + "問目";
                System.out.println("case [7]:" + question);
                stBeans.setQuestion(question);
                break;

            case 8:
                toi = (int) Math.ceil(Math.random() * 8);
                question = syou + "章の" + toi + "問目";
                System.out.println("case [8]:" + question);
                stBeans.setQuestion(question);
                break;

            case 9:
                toi = (int) Math.ceil(Math.random() * 19);
                question = syou + "章の" + toi + "問目";
                System.out.println("case [9]:" + question);
                stBeans.setQuestion(question);
                break;

            case 10:
                toi = (int) Math.ceil(Math.random() * 17);
                question = syou + "章の" + toi + "問目";
                System.out.println("case [10]:" + question);
                stBeans.setQuestion(question);
                break;

            case 11:
                toi = (int) Math.ceil(Math.random() * 7);
                question = syou + "章の" + toi + "問目";
                System.out.println("case [11]:" + question);
                stBeans.setQuestion(question);
                break;

            case 12:
                toi = (int) Math.ceil(Math.random() * 8);
                question = syou + "章の" + toi + "問目";
                System.out.println("case [12]:" + question);
                stBeans.setQuestion(question);
                break;

            case 13:
                toi = (int) Math.ceil(Math.random() * 8);
                question = syou + "章の" + toi + "問目";
                System.out.println("case [13]:" + question);
                stBeans.setQuestion(question);
                break;
        }
        System.out.println("-------------------END OF SilverTrainLogic : generateRandomQuestion()-------------------");
	    return question;
	}
	
	public void userChoice(SilverTrainBeans stBeans) {
		System.out.println("-------------------START OF SilverTrainLogic-------------------");
		
		//セッションスコープの中の値が使われる
		String choice = stBeans.getChoice();
		String question = stBeans.getQuestion();
		System.out.println("SilverTrainLogic : userChoice");
		System.out.println("userChoice[question] = " + question);
		
			switch(choice) {
				case "1":
					System.out.println("case 1");
					System.out.println();
					stBeans.setCorrect(stBeans.getCorrect() + 1);
					stBeans.addCorrectList(question);
					System.out.println(stBeans.getCorrectListAsString());
					break;
					
				case "2":
					System.out.println("case 2");
					System.out.println();
					System.out.println("前：incorrect = " + stBeans.getIncorrect());
					stBeans.setIncorrect(stBeans.getIncorrect() + 1);
					System.out.println("後：incorrect = " +stBeans.getIncorrect());
					stBeans.addIncorrectList(question);
					System.out.println(stBeans.getIncorrectListAsString());
					break;
					
				case "3":
					System.out.println("case 3");
					System.out.println("choice = " + choice);
					break;
					
				case "4":
					System.out.println("case 4");
					System.out.println("choice = " + choice);
					System.out.println(stBeans.getCorrectListAsString());
					System.out.println(stBeans.getIncorrectListAsString());
					break;
					
			}
        System.out.println("-------------------END OF SilverTrainLogic-------------------");
	}
	
}
