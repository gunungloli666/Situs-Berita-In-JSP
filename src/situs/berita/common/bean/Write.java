package situs.berita.common.bean;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import situs.berita.common.util.CommonName;

public class Write {
	
	public boolean  writeArticle( String id, String content) throws Exception{
		boolean success = false; 
		
		URL url = new  URL(CommonName.URL); 
		URLConnection ucon = url.openConnection(); 
		Properties prop = new Properties(); 
		prop.load(ucon.getInputStream()); 
		
		String articlepath = prop.getProperty(CommonName.ARTICLE_PATH); 
		
		DocumentBuilderFactory dbfactori = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder builder = dbfactori.newDocumentBuilder(); 
		
		Document document = builder.parse(new FileInputStream(articlepath));
		
		Element el = document.getDocumentElement(); 
		
		Element artikel_baru = document.createElement("article") ; 
		
		artikel_baru.setAttribute("articleid", id); 
		
		Element detail = document.createElement("detail"); 
		detail.setAttribute("text", content); 
		
		artikel_baru.appendChild(detail); 
		el.appendChild(artikel_baru);  
		
		TransformerFactory tfactory = TransformerFactory.newInstance(); 
		Transformer transformer = tfactory.newTransformer(); 
		transformer.setOutputProperty(OutputKeys.INDENT , "yes"); 
		
		DOMSource source = new DOMSource(document); 
		StreamResult result = new StreamResult( new PrintStream
				(new FileOutputStream(articlepath))); 
		
		transformer.transform(source, result); 
		success = true; 
		return success; 

	}

}
