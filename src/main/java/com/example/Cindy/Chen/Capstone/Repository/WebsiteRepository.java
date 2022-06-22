package com.example.Cindy.Chen.Capstone.Repository;
//This is an interface for the WebsiteRepository, extends the pre-made CrudRepository

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Cindy.Chen.Capstone.Entity.Website;



public interface WebsiteRepository extends JpaRepository<Website, Integer>{

}
