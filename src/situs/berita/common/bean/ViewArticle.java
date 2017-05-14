package situs.berita.common.bean;

import java.io.FileInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import situs.berita.common.util.CommonURL;

public class ViewArticle {
	
	public List<Article> getAllArticle() 
	throws Exception { 
		URL url = new URL(CommonURL.URL);  
		URLConnection ucon = url.openConnection(); 
		Properties prop = new Properties(); 
		
		prop.load(ucon.getInputStream()); 
		String articlepath = prop.getProperty( CommonURL.ARTICLE_PATH ) ;
		
		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder dbuild = dbfac.newDocumentBuilder(); 
		Document doc = dbuild.parse(new FileInputStream(articlepath)); 
		
		NodeList nodelist = doc.getElementsByTagName("article"); 
		List<Article> listArticle = new ArrayList<>();
	
		for(int i = 0; i < nodelist.getLength(); i++){
		
		     Node n = nodelist.item(i);  
		     NamedNodeMap  nnp = n.getAttributes(); 
		     String title = nnp.getNamedItem("articleid").getNodeValue(); 
		    
		     if(title != null && ! title.isEmpty()){
		       Article article = new Article(); 
		    		
		     	article.setTitile(title);  
		     	NodeList nl2 = n.getChildNodes(); 
		     	
		     	Node n2 = nl2.item(1); 
		     	NamedNodeMap nnp2 = n2.getAttributes(); 
		     	
		     	String content = nnp2.getNamedItem("text").getNodeValue(); 
		     	article.setContent(content); 
		     	
		     	listArticle.add(article);  
		     }
		     
		}
		return listArticle; 
	}

}
