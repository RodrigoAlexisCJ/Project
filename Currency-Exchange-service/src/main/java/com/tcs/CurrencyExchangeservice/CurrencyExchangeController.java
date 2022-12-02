package com.tcs.CurrencyExchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repository;
	@GetMapping(value="/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrency(@PathVariable String from,
			@PathVariable String to) {
		CurrencyExchange currency = repository.findByFromAndTo(from, to);
		if(currency == null) {
			throw new RuntimeException("Unable to find from "+from+ " to "+to);
		}
		String port = environment.getProperty("local.server.port");
		currency.setEnvironment(port);
		return currency;
	}
	
	
}
