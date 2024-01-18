package com.developer.fullstackcrudoperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.developer.fullstackcrudoperations.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
