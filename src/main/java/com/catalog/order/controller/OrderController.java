package com.catalog.order.controller;

import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.catalog.order.bean.PaymentInfo;
import com.catalog.order.bean.ProductInfo;
import com.catalog.order.bean.ShippingInfo;
import com.catalog.order.bean.UserBean;
import com.catalog.order.dao.CarRepository;
import com.catalog.order.dao.RouterRepository;
import com.catalog.order.dao.TelevisionRepository;

@Controller
public class OrderController {

	@Autowired
	DataSource dataSource;
	@Autowired
	UserBean user;
	@Autowired
	CarRepository carRepo;
	@Autowired
	TelevisionRepository tvRepo;
	@Autowired
	RouterRepository routerRepo;

	@RequestMapping(value = "/buildOrder", method = RequestMethod.GET)
	public String buildOrder(@RequestParam("productID") String productID,
			@RequestParam("category") String category, Model model) {
		
		ProductInfo product = null;
		
		if (category.equals("cars")) {
			product = carRepo.findBy_id(productID);
		} else if (category.equals("televisions")) {
			product = tvRepo.findBy_id(productID);
		} else if (category.equals("routers")) {
			product = routerRepo.findBy_id(productID);
		}

		if (product != null) {
			if (product.getEndDate() != null && product.getStartDate() != null) {
				Date currentDate = new Date();
				if (!(currentDate.after(product.getStartDate()) && currentDate
						.before(product.getEndDate()))) {
					model.addAttribute("isProductUnavailable", true);
					// req.getSession().setAttribute("product", product);
				}
			}
			model.addAttribute("payment", new PaymentInfo());
			model.addAttribute("shipping", new ShippingInfo());
			model.addAttribute("product", product);
		}

		return "productInfo";
	}

	@RequestMapping(value = "/submitOrderInfo", method = RequestMethod.POST)
	public String submitOrderInfo(HttpServletRequest req, Model model,
			@ModelAttribute ShippingInfo shipping,
			@ModelAttribute PaymentInfo payment,
			@ModelAttribute ProductInfo pInfo) {

		model.addAttribute("payment", payment);
		model.addAttribute("shipping", shipping);
		model.addAttribute("product", pInfo);
		return "confirmOrder";
	}

	@RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(@ModelAttribute ShippingInfo shipping,
			@ModelAttribute PaymentInfo payment,
			@ModelAttribute ProductInfo pInfo) {
		System.out.println("Order confirmed");
		return "hello";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletResponse response) {
		/*
		 * response.addHeader("Access-Control-Allow-Headers",
		 * "accept, content-type");
		 * response.addHeader("Access-Control-Allow-Methods", "POST, GET");
		 * response.addHeader("Access-Control-Allow-Origin", "*");
		 * response.setStatus(403);
		 */
		return "login";
	}

	@ResponseBody
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public UserBean helloWorld(Model model, Principal principal) {

		String sql = "SELECT STUD_NAME FROM student WHERE STUD_ID=1";
		Connection conn = null;
		String name = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);
			}
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		System.out.println("Name is " + principal.getName());
		model.addAttribute("name", name);
		user.setUsername(name);
		return user;
	}

}
