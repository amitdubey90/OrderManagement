package com.catalog.order.bean;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="televisions")
public class Televisions extends ProductInfo {

	@Override
	public String toString() {
		return "Televisions [_id=" + _id + ", make=" + make + ", model="
				+ model + ", imgUrl=" + imgUrl + ", shortDesc=" + shortDesc
				+ ", attributes=" + attributes + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

}
