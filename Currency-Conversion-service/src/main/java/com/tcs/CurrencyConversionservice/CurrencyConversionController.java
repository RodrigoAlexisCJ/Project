package com.tcs.CurrencyConversionservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculatedCurrencyConversion(@PathVariable String from,
			@PathVariable String to,@PathVariable BigDecimal quantity) {
		CurrencyConversion currency = proxy.getCurrency(from, to);
		currency.setQuantity(quantity);
		currency.setTotalCalculatedAmount(quantity.multiply(currency.getConversionMultiple()));
		return currency;
	}
}
