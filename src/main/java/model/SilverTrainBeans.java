package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SilverTrainBeans implements Serializable {
	
	//問を制御
    private int toi = 0;
	    // toiのGetterとSetter
	    public int getToi() {return toi;}
	    public void setToi(int toi) {
	        this.toi = toi;
	    }
    //章を制御
    private int syou = 0;
	    // syouのGetterとSetter
	    public int getSyou() {return syou;}
	    public void setSyou(int syou) {
	        this.syou = syou;
	    }
    
    //現在の問題の回答数
    private int marathon = 1;
	    // marathonのGetterとカウントを制御するcountMarathon
	    public int getMarathon() {return marathon;}
//	    public void minusMarathon() {
//	    	this.marathon = -1;
//	    }
	    public void countMarathon() {
	        ++this.marathon;
	    }
    
    //正解だった数
    private int correct = 0;
	    // correctのGetterとSetter
	    public int getCorrect() {return correct;}
	    public void setCorrect(int correct) {
	        this.correct = correct;
	    }
	    
    //不正解だった数
    private int incorrect = 0;
	    // incorrectのGetterとSetter
	    public int getIncorrect() {return incorrect;}
	    public void setIncorrect(int incorrect) {
	        this.incorrect = incorrect;
	    }
    
    //ランダムに生成された問題を格納する
    private String question = "問題を出題します";
	    // questionのGetterとSetter
	    public String getQuestion() {return question;}
	    public void setQuestion(String question) {
	       this.question = question;
	    }
	    
    //ユーザーの入力を情報を格納する
    private String choice = "NULL";
	    // choiceのGetterとSetter
	    public String getChoice() {return choice;}
	    public void setChoice(String choice) {
	        this.choice = choice;
	    }
	    
    //URLを遷移させる
    private String url = "/WEB-INF/jsp/JavaSilverTrainJSP.jsp";
	    // urlのGetterとSetter
	    public String getURL() {return url;}
	    public void setURL(String url) {
	        this.url = url;
	    }
	    
    //正答率を扱う
    private double rate = 0;
    	//correctRateのGetterとSetter
	    public double getRate() {return rate;}
	    public void setRate(double rate) {
	        this.rate = rate;
	    }
	    
    //正解だった問題を格納するリスト
    private List<String> correctList = new ArrayList<>();
	    // correctListのGetterとaddメソット
//	    public List<String> getCorrectList() {return correctList;}
	    public void addCorrectList(String question) {
	        this.correctList.add(question);
	    }
	    public String getCorrectListAsString() {
	        return toString(correctList);
	    }
	    
	//正解だった問題を格納するリスト
    private List<String> incorrectList = new ArrayList<>();
	    // incorrectListのGetterとaddメソット
//	    public List<String> getIncorrectList() {return incorrectList;}
	    public void addIncorrectList(String question) {
	        this.incorrectList.add(question);
	    }
	    public String getIncorrectListAsString() {
	        return toString(incorrectList);
	    }
	    
    //付箋を貼った問題を格納するリスト
    private List<String> noteList = new ArrayList<>();
    	// NoteListのGetterとaddメソット
	    public List<String> getNoteList() {return incorrectList;}
	    public void addNoteList(String question) {
	        this.noteList.add(question);
	    }
	    
	  //呼び出されたリストの書式を決める
	    public String toString(List<String> list) {
	        if (list.isEmpty()) {
	            return "該当する問題はありませんでした。";
	        }
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < list.size(); i++) {
	            if (i != 0) { // 最初の問題以外には`,`を付け加える
	                sb.append(", ");
	            }
	            if (i % 4 == 0 && i != 0) { // 1行に4つの問題を表示する
	                sb.append("<br>");
	            }
	            sb.append(list.get(i));
	        }
	        return sb.toString();
	    }
}