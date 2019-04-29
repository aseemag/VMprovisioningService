package com.vmprovisioning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmprovisioning.models.VMProvisioning;

@Repository
public interface VMRepository extends JpaRepository<VMProvisioning, Long>{

	VMProvisioning getById(Long vmrequestId);

}
