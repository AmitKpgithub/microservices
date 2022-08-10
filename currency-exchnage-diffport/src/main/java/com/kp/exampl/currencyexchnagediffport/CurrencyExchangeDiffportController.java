package com.kp.exampl.currencyexchnagediffport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeDiffportController {
	
	@Autowired
	private CurrencyExchangeDiffportRepo repository;
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchangeBean retrieveExchangeValue(@PathVariable String from,@PathVariable String to)
	{
		CurrencyExchangeBean currencyExchangeBean=repository.findByFromAndTo(from, to);
		if(currencyExchangeBean==null)
		{
			throw new RuntimeException("Unable to find data for" +from+"to"+to);
		}
		String port=environment.getProperty("local.server.port");
		currencyExchangeBean.setEnvironment(port);
			
		return currencyExchangeBean;
	}
}
