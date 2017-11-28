package com.navnbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navnbp.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
