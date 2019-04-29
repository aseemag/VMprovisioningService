package com.vmprovisioning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmprovisioning.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	public List<Users> findUsersByMobileNoOrEmail(Long mobileNo,String email);

	public Users findUserByUserId(Long userId);

	public Users findByName(String name);
}
