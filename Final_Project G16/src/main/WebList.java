package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Google.Google;
import Google.GoogleQuery;
import Google.HTML_Handler;
import SortWebScore.*;

public class WebList {
	Map<String, String> webMap = new HashMap<String, String>();
	Map<String, Double> scoreList = new HashMap<String, Double>();

	// 預設關鍵字旅遊

	public WebList(String keyword) throws Exception {
		Google google = new Google(keyword);
		try {
			webMap = google.query();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 算某個網要的分數
	public double countWebKeyword(Keyword keyword, String url) throws IOException {
		WordCounter counter = new WordCounter(url);
		int count = counter.countKeyword(keyword.name);
		return count * keyword.weight;
	}

	// 算所有網頁的分數並儲存到list裏
	public void countAllWebKeyword(KeywordList keywords) throws IOException, IllegalArgumentException {
		for (Map.Entry<String, String> webMapEntry : webMap.entrySet()) {
			try {
				System.out.println("Start countWebScore " + webMapEntry.getValue());
				double score = this.countWebScore(keywords, webMapEntry.getKey(), webMapEntry.getValue());
				scoreList.put(webMapEntry.getKey(), score);
			} catch (IOException e) {
				System.out.println("fail URL: " + webMapEntry.getValue());

			}
		}

	}
	

	// inculde 子網頁
	public double countWebScore(KeywordList keywordList, String title, String url) throws IOException {

		WebPage rootPage = new WebPage(url, title);
		WebTree tree = new WebTree(rootPage);
		HTML_Handler htmlHandler = new HTML_Handler(url);
		List<String> subLinks = htmlHandler.fetchSublink(url);
		// build childnode
		for (String subLink : subLinks) {
			tree.root.addChild(new WebNode(new WebPage(subLink, title)));
		
		}
		
		
//		
//		
//		System.out.println("Please input (1)num of keywords (2)name and weight:");
//		Scanner scanner = new Scanner(System.in);

//		while(scanner.hasNextLine()){
//			int numOfKeywords = scanner.nextInt();
		// ArrayList<Keyword> keywords = new ArrayList<Keyword>();
//			
//			for(int i = 0; i < numOfKeywords; i++)
//			{
//				String name = scanner.next();
//				double weight = scanner.nextDouble();
//				Keyword k = new Keyword(name, weight);
//				keywords.add(k);
//			}
	//	System.out.print(tree.root.nodeScore);
		System.out.println("Start Set PostorderScore");
		tree.setPostOrderScore(keywordList.keywordList);
		System.out.println(tree.root.nodeScore);
	    return tree.root.nodeScore;
		
		//tree.eularPrintTree();
	}
	 
	// scanner.close();
	public void sortWebScore() {
		scoreList = MapUtil.sortByValue(scoreList);
	}

	public HashMap<String, String> gettWebList() {
		sortWebScore();
		  HashMap<String ,String> returnHashMap = new HashMap<String,String>();
		  for (Map.Entry<String, Double> scoreEntry : scoreList.entrySet()) {
		   //System.out.println("count: " + scoreEntry.getValue() + ", title: " + scoreEntry.getKey());
		   returnHashMap.put(scoreEntry.getKey(), webMap.get(scoreEntry.getKey()));
		   System.out.println("我有在跑");
		   
		  }
		 // System.out.println(returnHashMap);
		  return returnHashMap;

	}
}
