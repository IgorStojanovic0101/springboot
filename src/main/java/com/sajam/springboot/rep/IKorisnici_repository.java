package com.sajam.springboot.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sajam.springboot.entiteti.Korisnici;


public interface IKorisnici_repository extends JpaRepository<Korisnici, Integer> {
	


}