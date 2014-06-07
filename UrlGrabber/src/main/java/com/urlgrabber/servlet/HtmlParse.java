/**
 * 
 */
package com.urlgrabber.servlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author madhava
 *
 */
public class HtmlParse {
	
	public static Map<String, Object> getDatafromUrl(String url){
		Document doc;
		Map<String, Object> data = new HashMap<String, Object>();
		try {
	 
			doc = Jsoup.connect(url).get();
			
			String description = null;
			if(doc.select("meta[name=description]").get(0) != null)
				description = doc.select("meta[name=description]").get(0).attr("content");
			String pageUrl = null;
			if(doc.select("meta[property=og:url]").first() != null){
				pageUrl = doc.select("meta[property=og:url]").first().attr("content");
			}
			if(pageUrl == null){
			Elements urls = doc.select("link[rel=canonical]");
			if(urls.first() != null)
				pageUrl = urls.attr("href");
			}
			//System.out.println("Meta description : " + description);
			
			String keywords = doc.select("meta[name=keywords]").first().attr("content");
			//System.out.println("Meta keyword : " + keywords);
			
			Elements titles = doc.select("meta[property=og:title]");
			String title = null;
			
			if(titles.first() != null)
			  title = doc.select("meta[property=og:title]").first().attr("content");
			else if(doc.select("meta[property=og:site_name]").first() != null){
				title = doc.select("meta[property=og:site_name]").first().attr("content");
			}
			String image = null;
			if(doc.select("meta[property=og:image]").first() != null){
				image = doc.select("meta[property=og:image]").first().attr("content");
			}
			if(image == null){
				Elements icon = doc.select("link[rel=shortcut icon]");
				if(icon.first() != null)
					image = icon.attr("href");
			}
			//System.out.println("Meta image : " + image);
			
			data.put("description", description);
			data.put("title", title);
			data.put("image", image);
			data.put("pageUrl", pageUrl);
			data.put("keywords", keywords);
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static void main(String[] args) {
		getDatafromUrl(null);
		
	}

}
