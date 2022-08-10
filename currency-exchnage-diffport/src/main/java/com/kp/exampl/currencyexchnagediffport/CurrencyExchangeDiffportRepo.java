package com.kp.exampl.currencyexchnagediffport;

import org.springframework.data.jpa.repository.JpaRepository;

//this interface is able to talk to the database, we want to use this from CurrencyExchangeController.
//Creating CurrencyExchangeRepository interface class which extends JpaRepository to this I would need to pass in two
//things<1.which Entity to be managed and 2.what is the primary key>

public interface CurrencyExchangeDiffportRepo extends JpaRepository<CurrencyExchangeBean, Long>{
CurrencyExchangeBean findByFromAndTo(String from,String to);
}
