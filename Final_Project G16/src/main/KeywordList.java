package main;
import SortWebScore.*;
import java.util.*;
public class KeywordList {
	List<Keyword>keywordList = new ArrayList<Keyword> ();
	Keyword keyword = new Keyword("臺灣",5);
	Keyword keyword1 = new Keyword("台灣",5);
	Keyword keyword2 = new Keyword("住宿",5);
	Keyword keyword3 = new Keyword("國內",5);
	Keyword keyword4 = new Keyword("景點",5);
	Keyword keyword5 = new Keyword("放假",4);
	Keyword keyword6 = new Keyword("飯店",4);
	Keyword keyword7 = new Keyword("美食",4);
	Keyword keyword8 = new Keyword("玩",4);
	
	Keyword keyword9 = new Keyword("酒店",4);
	Keyword keyword10 = new Keyword("民宿",4);
	Keyword keyword11 = new Keyword("自由行",3);
	Keyword keyword12 = new Keyword("airbnb",3);
	
	Keyword keyword13 = new Keyword("過夜",3);
	Keyword keyword14 = new Keyword("找飯店",3);
	Keyword keyword15 = new Keyword("熱門",2);
	Keyword keyword16 = new Keyword("兩日遊",2);
	Keyword keyword17 = new Keyword("旅遊",2);
	Keyword keyword18 = new Keyword("優惠",1);
	Keyword keyword19 = new Keyword("補助",1);
	Keyword keyword20 = new Keyword("高鐵",1);
	public KeywordList() {
		keywordList.add(keyword);
		keywordList.add(keyword1);
		keywordList.add(keyword2);
		keywordList.add(keyword3);
		keywordList.add(keyword4);
		keywordList.add(keyword5);
		keywordList.add(keyword6);
		keywordList.add(keyword7);
		keywordList.add(keyword8);
		keywordList.add(keyword9);
		keywordList.add(keyword10);
		keywordList.add(keyword11);
		keywordList.add(keyword12);
		keywordList.add(keyword13);
		keywordList.add(keyword14);
		keywordList.add(keyword15);
		keywordList.add(keyword16);
		keywordList.add(keyword17);
		keywordList.add(keyword18);
		keywordList.add(keyword19);
		keywordList.add(keyword20);
	}
	
}