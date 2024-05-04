package com.driver.repository;

import com.driver.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Integer> {

    @Query(value = "select * from service_provider where admin_id=:adminId",nativeQuery = true)
    List<ServiceProvider> findByAdmin(int adminId);
}
