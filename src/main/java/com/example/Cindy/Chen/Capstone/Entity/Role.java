package com.example.Cindy.Chen.Capstone.Entity;
//This class creates a table in SQL named "Role", it has two columns, one for user ID,
// and one for User name. Line 20-35 are getters and setters.

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String name;

   public Role() {
   }

   public Role(String name) {
       this.name = name;
   }
   public Long getId() {
       return id;
   }
   public void setId(Long id) {
       this.id = id;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   @Override
   public String toString() {
       return "Role{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
   }
}

