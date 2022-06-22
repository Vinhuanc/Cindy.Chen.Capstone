package com.example.Cindy.Chen.Capstone.Repository;
//This is an interface for the UserRepository, extends the pre-made CrudRepository

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Cindy.Chen.Capstone.Entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}

