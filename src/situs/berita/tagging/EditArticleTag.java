package situs.berita.tagging;

import java.io.FileInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import javax.servlet.jsp.tagext.TagSupport;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import situs.berita.common.util.CommonURL;

public class EditArticleTag extends TagSupport{

	private String title; 
	private String content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	} 
	
	public int doStartTag(){
		try{
			URL url = new URL(CommonURL.URL);
			URLConnection ucon = url.openConnection(); 
			Properties prop = new Properties(); 
			prop.load(ucon.getInputStream()); 
			
			String articlepath = prop.getProperty("articlelistpath"); 
			
			DocumentBuilderFactory docb = DocumentBuilderFactory.newInstance(); 
			DocumentBuilder dbuilder = docb.newDocumentBuilder(); 
			
			Document doc = dbuilder.parse(new FileInputStream(articlepath)); 			
			NodeList articlelist = doc.getElementsByTagName("article");  

			for(int i = 0; i < articlelist.getLength(); i++){
				Node node = articlelist.item(i);
				NamedNodeMap nnm = node.getAttributes(); 
				String title = nnm.getNamedItem("title").getNodeValue(); 
				if(getTitle().equals(title)){
					NodeList nodelist1 = node.getChildNodes(); 
					Node node1 = nodelist1.item(1); 
					node.removeChild(node1); 
					
					//buat element baru
					Element element = doc.createElement("detail");  
					element.setAttribute("text",  getContent()); 
				}
			}
		}catch(Exception e){
		}
		return (SKIP_BODY); 
	}
	
	
	
	
}
