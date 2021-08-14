package com.duttech.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.duttech.relationships.models.License;

public interface LicenseRepository extends CrudRepository<License, Long> {
	
	List<License> findAll();
}
