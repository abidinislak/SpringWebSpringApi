package com.SpringRestApi.SpringRestApi.repository;

import com.SpringRestApi.SpringRestApi.entity.User_D;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface USerRepository extends JpaRepository<User_D,Integer> {
}
