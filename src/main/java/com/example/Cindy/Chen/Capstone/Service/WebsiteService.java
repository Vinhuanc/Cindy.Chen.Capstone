package com.example.Cindy.Chen.Capstone.Service;
//This class is created as a Service class for the WebsiteService, it holds a method to list
//all the websites found within the WebsiteRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Cindy.Chen.Capstone.Entity.Website;
import com.example.Cindy.Chen.Capstone.Repository.WebsiteRepository;


@Service
@Transactional
public class WebsiteService {
	@Autowired
	private WebsiteRepository websiteRepository;
	
	public Iterable<Website> listAll(){
		return websiteRepository.findAll();
	}
}


