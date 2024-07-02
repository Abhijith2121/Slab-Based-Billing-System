package com.electricity.bill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electricity.bill.entity.Bill;

public interface BillRepository extends JpaRepository<Bill,Long> {

}
