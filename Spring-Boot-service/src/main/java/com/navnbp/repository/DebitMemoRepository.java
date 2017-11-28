package com.navnbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navnbp.entity.DebitMemo;

public interface DebitMemoRepository extends JpaRepository<DebitMemo, Long> {

}
