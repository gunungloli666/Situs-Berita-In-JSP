package situs.berita.common.bean;

import java.io.FileInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import situs.berita.common.util.CommonURL;

public class ModifyArticle {
	
	public String getArticleContent(String articleid) throws Exception{
		String result = ""; 
		URL url = new URL(CommonURL.URL); 
		URLConnection ucon = url.openConnection(); 
		Properties prop = new Properties(); 
		
		prop.load(ucon.getInputStream()); 
		String articlepath = prop.getProperty(CommonURL.ARTICLE_PATH ); 
		
		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder dbbuilder = dbfac.newDocumentBuilder();
		Document doc = dbbuilder.parse(new FileInputStream(articlepath)); 
		
		NodeList nodelist = doc.getElementsByTagName(CommonURL.ARTICLE_TAG_NAME) ; 
		
		for(int i = 0; i< nodelist.getLength(); i++ ){
			Node node = nodelist.item(i); 
			NamedNodeMap nnp = node.getAttributes(); 
			String title = nnp.getNamedItem("articleid" ).getNodeValue();
			
			if(title != null && articleid.equals(title)){
				NodeList nl2 = node.getChildNodes(); 
				Node n2 = nl2.item(1); 
				
				NamedNodeMap nnp2 = n2.getAttributes(); 
				String content = nnp2.getNamedItem("text").getNodeValue(); 
				if(content != null ){
					return content; 
				}	
			}
		}
		return result; 
	}

}
