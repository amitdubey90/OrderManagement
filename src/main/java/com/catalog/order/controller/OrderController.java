package com.catalog.order.controller;

import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.catalog.order.bean.ProductInfo;
import com.catalog.order.bean.UserBean;
import com.catalog.order.service.ProductInfoService;

@Controller
public class OrderController {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	UserBean user;
	
	@Autowired
	ProductInfoService prodInfoService;
	
	@RequestMapping(value="/buildOrder", method = RequestMethod.GET)
	public String buildOrder(@RequestParam("productID") String productID, Model model){
		ProductInfo product = prodInfoService.getProductInfo(productID);
		model.addAttribute("productInfo", "Ghanta");
		//return product != null ? "buildOrder": "invalidProduct";
		return "buildOrder";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletResponse response){
		/*response.addHeader("Access-Control-Allow-Headers", "accept, content-type");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setStatus(403);*/
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public UserBean helloWorld(Model model, Principal principal){
		
		String sql = "SELECT STUD_NAME FROM student WHERE STUD_ID=1";
		Connection conn = null;
		String name = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				name = rs.getString(1);
			}
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		System.out.println("Name is "+principal.getName());
		model.addAttribute("name", name);
		user.setUsername(name);
		return user;
	}

}
