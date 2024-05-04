package com.driver.repository;

import com.driver.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query(value = "select * from country where code=:countryCode and user_id=:userId",nativeQuery = true)
    Country findByCode(String countryCode,int userId);

//    @Query(value = "select * from country where code=:countryCode",nativeQuery = true)
//    Country findCountryByCode(String countryCode,se);
}
