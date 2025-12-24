package com.foodnfun.backend.repository;
import com.foodnfun.backend.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
public interface MenuItemsRepository extends JpaRepository<MenuItem, Long> {

}
