package Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;

import javax.print.attribute.standard.PrinterInfo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//���J�i�Ӫ�URL�̪����e��l�s������X��

public class HTML_Handler {
	
	HashMap<String, String> link = new HashMap<String, String>();
	Collection<String> mainURL;
	ArrayList<String> content = new ArrayList<String>();
	String searchKeyword;
//	Translate translate = new Translate();
	
	
	String rootLink  =  new String();
	
//	public HTML_Handler(String searchKeyword) throws IOException {
//		this.searchKeyword = searchKeyword;
//	}
	public HTML_Handler(String rootLink) throws IOException {
		  rootLink = rootLink;
	}
	
	public void trans() throws Exception {
//		System.out.println(searchKeyword);
//		searchKeyword = translate.translateText(searchKeyword, "auto", "zh_tw");
//		System.out.println(searchKeyword);
	}

	
	public void import_content() throws Exception {
		trans();
		try {
			link = new Google(searchKeyword).query();
		} 
		catch (IOException e) {
		}
		mainURL = link.values();
		
//		System.out.println("hi");
//		System.out.println(mainURL);
		
		for (String url : mainURL) {
//			System.out.println(fetchContent(url));
			content.add(fetchContent(url));
		}
	}
	
	private ArrayList<String> getContent() {
		return content;
	}
	
	public Collection<String> getURL() {
		return mainURL;
	}
	
	
	private String fetchContent(String link) throws IOException{
		URL url = new URL(link);
		URLConnection conn = url.openConnection();
		
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String retVal = "";
		String line = null;
		while ((line = br.readLine()) != null){
		    retVal = retVal + line + "\n";
		}
		
		return retVal;
    }
	//抓子網頁
	private ArrayList<String> fetchSublink(String link , String content) throws IOException{
		ArrayList<String> sub = new ArrayList<String>();
		
		int counter = 0;
		char slash;
		int where = 0;
		String concatlink = "1";
		
//		�P�_�����O���O�l����
		for (int i = 0; i < link.length(); i++) {
            slash = link.charAt(i);
            if (slash == '/')
                counter++;
            if (counter >= 3) {
            	where = i;
            	break;
            }
        }

//		���X�D���������}
        if (where != 0) {
        	concatlink = link.substring(0, where);
        }
        

		Document doc = Jsoup.parse(content);
		Elements aLinks = doc.select("a[href]");
		for(Element element:aLinks){
			String url =element.attr("href");
			
//			�D�X�}�Y���Ohttp��https���S�s�bhref���F��
			if(!url.contains("http://")&&!url.contains("https://")){ 
				if (concatlink != "1") {
					url = concatlink + url; 
				}
				else {
					url = link+url;
				}
			}
			sub.add(url);
		}
		
		return sub;
	}
	public ArrayList<String> fetchSublink(String link ) throws IOException{
		ArrayList<String> sub = new ArrayList<String>();
		
		int counter = 0;
		char slash;
		int where = 0;
		String concatlink = "1";
		String content = this.fetchContent(link);
		
//		�P�_�����O���O�l����
		for (int i = 0; i < link.length(); i++) {
            slash = link.charAt(i);
            if (slash == '/')
                counter++;
            if (counter >= 3) {
            	where = i;
            	break;
            }
        }

//		���X�D���������}
        if (where != 0) {
        	concatlink = link.substring(0, where);
        }
        

		Document doc = Jsoup.parse(content);
		Elements aLinks = doc.select("a[href]");
		for(Element element:aLinks){
			String url =element.attr("href");
			
//			�D�X�}�Y���Ohttp��https���S�s�bhref���F��
			if(!url.contains("http://")&&!url.contains("https://")){ 
				if (concatlink != "1") {
					url = concatlink + url; 
				}
				else {
					url = link+url;
				}
			}
			if (sub.size()<=2) {
				sub.add(url);
			}else {
				break;
			}
			
		}
		System.out.println(sub);
		
		return sub;
	}
	public HashMap<String,String> getLink(){
		return link;
	}
		
	
}




