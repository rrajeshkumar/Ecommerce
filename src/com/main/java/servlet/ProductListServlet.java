package com.main.java.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.java.entity.Product;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 		  
		  Product mobile = new Product("1","mobile",10000);
		  Product laptop = new Product("2","laptop",20000);
		  
		  
		List<Product> list =  new ArrayList<>();
        try {
        	String fileName = "C:/Users/rraje/eclipse-workspace/Ecommerce/WebContent/WEB-INF/resources/products.txt";
        	
        	File file = new File(fileName);
        	FileReader fr = new FileReader(file);
        	BufferedReader br = new BufferedReader(fr);
        	String line;
        	while((line = br.readLine()) != null){
        	    //process the line
        	String str[] = line.split(" ");
        	Product product = new Product(str[0],str[1],Float.parseFloat(str[2]));
        	list.add(product);
        	}
             
	 } catch (Exception ex) {
         ex.printStackTrace();
       
     }
        
		  
//		  
//		  Product mobile = new Product("1","mobile",10000);
//		  Product laptop = new Product("2","laptop",20000);
//		  
//		  list.add(mobile);
//		  list.add(laptop);
//		  
		 request.setAttribute("productList", list);
         
	        // Forward to /WEB-INF/views/productListView.jsp
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/productListView.jsp");
	        dispatcher.forward(request, response);
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
