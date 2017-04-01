package org.udea.proint1.ms.producto_backend.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import org.udea.proint1.ms.producto_backend.dto.Product;
import org.udea.proint1.ms.producto_backend.dao.ProductDAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



@Controller
public class ProductRestController {
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/find")
	@ResponseBody
	public Product getProduct( String code) {
		Product product = new Product();
		product = productDAO.findByCode(code);
		return product;
	
	}
	
	@RequestMapping (method = RequestMethod.POST, value ="/save")
	@ResponseBody
	public String setProduct( @RequestBody Product product) {
		productDAO.save(product);
		return "Done!";
	
	}
	
	@RequestMapping("/findBy")
	@ResponseBody
	public Product getProduct(Long id){
		Product product = new Product();
		product = productDAO.findById(id);
		return product;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Product> getProduct(){
		List<Product> productList = new ArrayList();
		productList = (List<Product>) productDAO.findAll();
		return productList;
	}
	
	@RequestMapping("/findName")
	@ResponseBody
	public String getName(long id){
		Product product = new Product();
		product = productDAO.findById(id);
		return product.getDescription();
	}
	
	
}
