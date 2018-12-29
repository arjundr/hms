package com.example.hms;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hms.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> 
{


}
