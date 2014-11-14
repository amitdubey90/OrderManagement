package com.catalog.order.bean;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cars")
public class Cars extends ProductInfo{

	@Override
	public String toString() {
		return "Cars [_id=" + _id + ", make=" + make + ", model=" + model
				+ ", imgUrl=" + imgUrl + ", shortDesc=" + shortDesc
				+ ", price=" + attributes.get("price") + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
}
