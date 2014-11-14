package com.catalog.order.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.catalog.order.bean.Cars;


public interface CarRepository extends MongoRepository<Cars,String>{
	public Cars findBy_id(String _id);
	public Cars findByMake(String make);
}
