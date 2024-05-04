package com.driver.repository;
import com.driver.model.ServiceProvider;
import com.driver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

//    @Query(value = "select service_provider_list_id from user_service_provider_list where users_id=:userId")
//    List<ServiceProvider> findServiceProv(Integer userId);
}
