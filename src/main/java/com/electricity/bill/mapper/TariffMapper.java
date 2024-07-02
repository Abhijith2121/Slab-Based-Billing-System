package com.electricity.bill.mapper;

import com.electricity.bill.dto.TariffDto;
import com.electricity.bill.entity.Tariff;

public class TariffMapper {
	public static TariffDto mapToTariffDto(Tariff tariff) {
		
        TariffDto tariffDto = new TariffDto();
        
        tariffDto.setId(tariff.getId());
        tariffDto.setStartDate(tariff.getStartDate());
        tariffDto.setEndDate(tariff.getEndDate());
        tariffDto.setRatePerUnit(tariff.getRatePerUnit());
        tariffDto.setMinUnits(tariff.getMinUnits());
        tariffDto.setMaxUnits(tariff.getMaxUnits());
        tariffDto.setNumberOfDays(tariff.getNumberOfDays());
        tariffDto.setCustomerId(tariff.getCustomer().getId());
       
        
        
        
        return tariffDto;
        
    }

    public static Tariff mapToTariff(TariffDto tariffDto) {
    	
        Tariff tariff = new Tariff();
        
        tariff.setId(tariffDto.getId());
        tariff.setStartDate(tariffDto.getStartDate());
        tariff.setEndDate(tariffDto.getEndDate());
        tariff.setRatePerUnit(tariffDto.getRatePerUnit());
        tariff.setMinUnits(tariffDto.getMinUnits());
        tariff.setMaxUnits(tariffDto.getMaxUnits());
        tariff.setNumberOfDays(tariffDto.getNumberOfDays());       
        return tariff;
    }
}
