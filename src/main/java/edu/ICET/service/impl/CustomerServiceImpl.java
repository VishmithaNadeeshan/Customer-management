package edu.ICET.service.impl;

import edu.ICET.dto.Customer;
import edu.ICET.entity.CustomerEntity;
import edu.ICET.repository.CustomerRepository;
import edu.ICET.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    final ModelMapper mapper;
    final CustomerRepository repository;
    @Override
    public void addCustomer(Customer customer) {

        repository.save(mapper.map(customer, CustomerEntity.class));

    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customerArrayList = new ArrayList<>();
        List<CustomerEntity> all = repository.findAll();

        all.forEach(customerEntity -> {
            customerArrayList.add(mapper.map(customerEntity, Customer.class));
        });

        return customerArrayList;
    }

    @Override
    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public Customer searchById(Integer id) {
        return mapper.map(repository.findById(id), Customer.class);
    }

    @Override
    public List<Customer> searchbyName(String name) {
        List<CustomerEntity> byName = repository.findByName(name);
        List<Customer> customerList = new ArrayList<>();

        byName.forEach(customerEntity -> {
            customerList.add(mapper.map(customerEntity,Customer.class));
        });
        return customerList;
    }
}
