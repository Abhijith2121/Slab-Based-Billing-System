package com.electricity.bill.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tariffs")
public class Tariff {
	
	
	
	public Tariff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tariff(Long id, LocalDate startDate, LocalDate endDate, Double ratePerUnit, Integer maxUnits,
			Integer minUnits,Integer numberOfDays,Customer customer) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.ratePerUnit = ratePerUnit;
		this.maxUnits = maxUnits;
		this.minUnits = minUnits;
		this.numberOfDays=numberOfDays;
		this.customer=customer;
	}
   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="start_date",nullable=false)
	private LocalDate startDate;
	
	@Column(name="end_date",nullable=false)
	private LocalDate endDate;
	
	@Column(name="rate_per_unit",nullable=false)
	private Double ratePerUnit;
	
	@Column(name="max_units",nullable=false)
	private Integer maxUnits;
	
	

	@Column(name="min_units",nullable=false)
	private Integer minUnits;
	
	@Column(name = "number_of_days", nullable = false, columnDefinition = "integer default 0")
    private Integer numberOfDays;
	
	@ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;



	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Double getRatePerUnit() {
		return ratePerUnit;
	}

	public void setRatePerUnit(Double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}

	public Integer getMaxUnits() {
		return maxUnits;
	}

	public void setMaxUnits(Integer maxUnits) {
		this.maxUnits = maxUnits;
	}

	public Integer getMinUnits() {
		return minUnits;
	}

	public void setMinUnits(Integer minUnits) {
		this.minUnits = minUnits;
	}
	
	public Integer getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(Integer numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	
	
}


