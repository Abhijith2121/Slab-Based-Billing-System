package com.electricity.bill.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electricity.bill.entity.Tariff;

public interface TariffRepository extends JpaRepository<Tariff,Long> {
	Tariff findByCustomerId(Long customerId);
}
