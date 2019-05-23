package com.sajam.springboot.Contlotor;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sajam.springboot.DAO.KorisniciDAO;

import com.sajam.springboot.entiteti.Auto;
import com.sajam.springboot.entiteti.Korisnici;
import com.sajam.springboot.entiteti.Sajam_automobila;





@RestController
@RequestMapping("/sajam")
public class Sajam_controler {
	
	@Autowired
	KorisniciDAO sajam_dao;
	
	@RequestMapping(value = "/sajmovi", method = RequestMethod.GET)
	public ResponseEntity<List<Sajam_automobila>> getListaSajmova() {
		
		List<Sajam_automobila> emp=sajam_dao.lista_sajmova();
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	@RequestMapping(value = "/automobili", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getListaAutomobila() {
		
		JSONObject emp=sajam_dao.lista_automobila();
	
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}

	
	

	
	@RequestMapping(value = "/sajmovi/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Sajam_automobila> getEyId(@PathVariable Integer id) {
		
		Sajam_automobila emp=sajam_dao.findOneSajam(id);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
/*	@RequestMapping(value = "/sajmovi/id/{id}/automobili", method = RequestMethod.GET)
	public ResponseEntity<List<Auto>> getAutomobiliById(@PathVariable Integer id) {
		
		Sajam_automobila emp=korisniciDAO.findOneSajam(id);
		List<Auto> automobili=emp.getAutomobili();
		
		if(automobili==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(automobili);
	}
	*/

	
	/*delete an employee*/
	
	/*Delete an employee*/
	@DeleteMapping("/sajmovi/{id}")
	public ResponseEntity<Sajam_automobila> delmployee(@PathVariable(value="id") Integer empid){
		
		Sajam_automobila emp=sajam_dao.findOneSajam(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		sajam_dao.delete(emp);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	
	

	
	
}
