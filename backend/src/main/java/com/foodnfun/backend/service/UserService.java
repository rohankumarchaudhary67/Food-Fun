package com.foodnfun.backend.service;
import com.foodnfun.backend.dto.UserDTO;

//import com.foodnfun.backend.entity.User;
import java.util.List;

public interface UserService {

	UserDTO createUser(UserDTO userDTO);
	List<UserDTO> getAllUsers();
	UserDTO getUserById(Long id);
}
