package com.tcs.CurrencyExchangeservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CurrencyExchangeRepository extends CrudRepository<CurrencyExchange, Integer> {

	public CurrencyExchange findByFromAndTo(String from,String to);
}
