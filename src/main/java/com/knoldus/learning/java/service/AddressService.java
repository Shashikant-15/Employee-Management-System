package com.knoldus.learning.java.service;

import com.knoldus.learning.java.entity.Address;
import com.knoldus.learning.java.entity.Employee;
import com.knoldus.learning.java.repository.AddressRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressService {
        @Autowired
        private AddressRepository addressRepository;

        List<Address> addressList = new ArrayList<>();

//        public Address Save(Address address) {
//            Employee employee = new addressRepository.save("id");
//        }
//
//        public List<Address> showAddress() {
//            addressList = (List<Address>) addressRepository.findAll();
//            return addressList;
//        }
//
//        public Optional<Address> getAddressById(int id) {
//            return addressRepository.findById(id);
//        }

        public void delete(int id) {
            addressRepository.deleteById(id);
        }
}
