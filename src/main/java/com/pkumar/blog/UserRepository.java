package com.pkumar.blog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pkumar.blog.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
