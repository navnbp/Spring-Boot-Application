package com.navnbp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navnbp.entity.DebitMemo;

@Service
public interface DebitMemoService {

	DebitMemo[] getAllDebitMemo();

	DebitMemo addDebitMemo(DebitMemo debitMemo);
}
