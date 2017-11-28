package com.navnbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navnbp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
