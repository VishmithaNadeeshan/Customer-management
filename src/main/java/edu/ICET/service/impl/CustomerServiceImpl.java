package edu.ICET.service.impl;

import edu.ICET.dto.Customer;
import edu.ICET.entity.CustomerEntity;
import edu.ICET.repository.CustomerRepository;
import edu.ICET.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    final ModelMapper mapper;
    final CustomerRepository repository;
    @Override
    public void addCustomer(Customer customer) {

        repository.save(mapper.map(customer, CustomerEntity.class));

    }
}
