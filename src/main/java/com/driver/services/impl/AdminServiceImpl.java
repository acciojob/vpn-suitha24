package com.driver.services.impl;

import com.driver.model.Admin;
import com.driver.model.Country;
import com.driver.model.CountryName;
import com.driver.model.ServiceProvider;
import com.driver.repository.AdminRepository;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository1;

    @Autowired
    ServiceProviderRepository serviceProviderRepository1;

    @Autowired
    CountryRepository countryRepository1;

    @Override
    public Admin register(String username, String password) {
        Admin admin=new Admin();
        admin.setPassword(password);
        admin.setUsername(username);
        adminRepository1.save(admin);
        return admin;
    }

    @Override
    public Admin addServiceProvider(int adminId, String providerName) {

        ServiceProvider newServiceProvider=new ServiceProvider();
        newServiceProvider.setAdmin(adminRepository1.findById(adminId).get());
        newServiceProvider.setName(providerName);
        serviceProviderRepository1.save(newServiceProvider);
        Admin admin=adminRepository1.findById(adminId).get();
        //get curr list & add in that
        List<ServiceProvider> serviceProviderList=serviceProviderRepository1.findByAdmin(adminId);
        serviceProviderList.add(newServiceProvider);
        admin.setServiceProviders(serviceProviderList);
        adminRepository1.save(admin);
        return admin;
    }

    @Override
    public ServiceProvider addCountry(int serviceProviderId, String countryName) throws Exception{
        //return null;
        countryName=countryName.toUpperCase();
        try{
            CountryName.valueOf(countryName);
        }
        catch (Exception e){
            throw new Exception("Country not found");
        }
        ServiceProvider serviceProvider=serviceProviderRepository1.findById(serviceProviderId).get();
        List<Country> countriesList=serviceProvider.getCountryList();
        Country name=new Country();
        name.setCountryName(CountryName.valueOf(countryName));
        name.setCode(CountryName.valueOf(countryName).toCode());
        name.setServiceProvider(serviceProviderRepository1.findById(serviceProviderId).get());
        countryRepository1.save(name);
        countriesList.add(name);
        serviceProvider.setCountryList(countriesList);
        serviceProviderRepository1.save(serviceProvider);
        return serviceProvider;
    }
}
