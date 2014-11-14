package com.catalog.order.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.catalog.order.bean.Routers;

public interface RouterRepository extends MongoRepository<Routers, String>{
	public Routers findBy_id(String _id);
}
