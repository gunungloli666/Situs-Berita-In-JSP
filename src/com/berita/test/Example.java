package com.berita.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Example extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("listMakanan", getExampleData()); 
		try{
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/Test.jsp"); 
			rd.forward(request , response) ; 
		}catch(Exception e){
			System.out.println( "eror with dispatching"); 
		}
	}
	
	public List<String> getExampleData(){
		List<String> m = new  ArrayList<>();
		m.add("makan"); 
		m.add("minum"); 
		m.add("tidur");
		
		return m; 
	}
}
