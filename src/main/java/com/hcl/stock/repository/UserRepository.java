package com.hcl.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.stock.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
