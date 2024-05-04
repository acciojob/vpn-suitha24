package com.driver.services.impl;

import com.driver.model.CountryName;
import com.driver.model.ServiceProvider;
import com.driver.model.User;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.repository.UserRepository;
import com.driver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository3;
    @Autowired
    ServiceProviderRepository serviceProviderRepository3;
    @Autowired
    CountryRepository countryRepository3;

    @Override
    public User register(String username, String password, String countryName) throws Exception{

        countryName=countryName.toUpperCase();
        try{
            CountryName.valueOf(countryName);
        }
        catch (Exception e){
            throw new Exception("Country not Found");
        }

        User user=new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setConnected(false);
        String countryCode= CountryName.valueOf(countryName).toCode();
        userRepository3.save(user);
        return user;
    }

    @Override
    public User subscribe(Integer userId, Integer serviceProviderId) {
        //ServiceProvider serviceProvider=serviceProviderRepository3.findById(serviceProviderId).get();
//        List<User> users=serviceProvider.getUsers();
//        User user=userRepository3.findById(userId).get();
//        users.add(user);
//        serviceProvider.setUsers(users);
//        serviceProviderRepository3.save(serviceProvider);
//        List<ServiceProvider> serviceProviderList=userRepository3.findServiceProv(userId);
//        serviceProviderList.add(serviceProvider);
        return null;
    }
}
