package com.sajam.springboot.rep;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sajam.springboot.entiteti.Auto;
import com.sajam.springboot.entiteti.Sajam_automobila;
@Component
public interface getAutomobili {

	
	public List<Sajam_automobila> getTransactionInfo();

	public List<Auto> getAutomobili();
}
