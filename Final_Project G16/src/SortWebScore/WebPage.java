package SortWebScore;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import WordCounter;

public class WebPage {
	public String url;
	public String name;
	public WordCounter counter;
	public double score;
	
	public WebPage(String url, String name){
		this.url = url;
		this.name = name;
		this.counter = new WordCounter(url);	
	}
	
	public void setScore(List<Keyword> keywords) throws IOException{
		score = 0;
//		1. calculate score
		for(Keyword k : keywords){		
			score += k.weight * counter.countKeyword(k.name);	
		}
	}	
}
