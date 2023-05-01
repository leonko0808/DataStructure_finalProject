package Google;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Google {
	
	public String searchKeyword;
	public String url;
	public String content;
	//Translate translate = new Translate();
	
	public Google(String searchKeyword) throws Exception {
		Translate translate = new Translate();
		this.searchKeyword = translate.translateText(searchKeyword, "auto", "zh_tw");
		//this.searchKeyword = searchKeyword;
		System.out.println(this.searchKeyword);
		
		this.url = "http://www.google.com/search?q="+this.searchKeyword+"&oe=utf8&num=10";
		System.out.println("Search url: "+url);
	}
	
	private String fetchContent() throws Exception{
		String aString = "";
		try {
			String retVal = "";
			URL u = new URL(url);
			SslUtils.ignoreSsl();
			URLConnection conn = u.openConnection();
			conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");
			InputStream in = conn.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in,"utf-8");
			BufferedReader bufReader = new BufferedReader(inReader);
			String line = null;
			while((line=bufReader.readLine())!=null)
			{
				retVal += line;
			}
			return retVal;
		}
		catch(FileNotFoundException e) {
			
		}
		return aString;
	}
	
	public HashMap<String, String> query() throws Exception{
		if(content==null)
		{
			content= fetchContent();
		}
		HashMap<String, String> retVal = new HashMap<String, String>();
		Document doc = Jsoup.parse(content);
		Elements lis = doc.select("div");
		lis = lis.select(".kCrYT");
		for(Element li : lis)
		{
			try 
			{
				String citeUrl = li.select("a").get(0).attr("href");
				citeUrl = java.net.URLDecoder.decode(citeUrl, "UTF-8");
				String[] clean = citeUrl.split("&sa");
				citeUrl = clean[0];
				String title = li.select("a").get(0).select(".vvjwJb").text();
				if(title.equals("")) {
					continue;
				}
				
				citeUrl = citeUrl.substring(7);
				retVal.put(title, citeUrl);

			} catch (IndexOutOfBoundsException e) {
			}
		}
		return retVal;
	}

}
