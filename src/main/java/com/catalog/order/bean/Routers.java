package com.catalog.order.bean;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="routers")
public class Routers extends ProductInfo {

	@Override
	public String toString() {
		return "Routers [_id=" + _id + ", make=" + make + ", model=" + model
				+ ", imgUrl=" + imgUrl + ", shortDesc=" + shortDesc
				+ ", attributes=" + attributes + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

}
