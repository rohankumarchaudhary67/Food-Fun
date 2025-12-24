package com.foodnfun.backend.repository;

import com.foodnfun.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
	

}
