//this class is like a DbContext from C# 
//JPARepository = DBContext
//this is our ORM 
package com.LateNightIce.repositories;

import java.util.List;
//JpaRepository provides some JPA-related methods such as flushing the persistence context and deleting records in a batch
//import org.springframework.data.jpa.repository.JpaRepository;

//CrudRepository mainly provides CRUD functions
import org.springframework.data.repository.CrudRepository;

import com.LateNightIce.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
    
}
