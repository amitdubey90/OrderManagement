package com.catalog.order.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.catalog.order.bean.Televisions;

public interface TelevisionRepository extends MongoRepository<Televisions, String> {
	public Televisions findBy_id(String _id);
}
