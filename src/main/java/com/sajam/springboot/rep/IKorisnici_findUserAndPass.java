package com.sajam.springboot.rep;

import org.springframework.stereotype.Component;

import com.sajam.springboot.entiteti.Korisnici;
@Component
public interface IKorisnici_findUserAndPass {
	
	public Korisnici getTransactionInfo(String username,String password);

}
