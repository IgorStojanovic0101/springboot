package com.sajam.springboot.Contlotor;
import java.util.List;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sajam.springboot.DAO.KorisniciDAO;
import com.sajam.springboot.entiteti.Auto;
import com.sajam.springboot.entiteti.Korisnici;
import com.sajam.springboot.entiteti.Sajam_automobila;

@RestController
@RequestMapping("/sajam")
public class Korisnici_controlor {
	@Autowired
	KorisniciDAO korisniciDAO;

	/*to save an employee*/
	@PostMapping("/sajam")
	public Sajam_automobila save(Sajam_automobila emp) {
		
		return korisniciDAO.save(emp);
	}
	
	

	/* to save an employee*/
	@RequestMapping(
			value="/korisnici",
			
			method = RequestMethod.POST)
	public ResponseEntity<JSONObject> createKorisnik(Korisnici kor) {
		
		JSONObject nadjen=korisniciDAO.findUserAndPass(kor.getUsername(), kor.getPassword());
		 
		
		if(nadjen==null) {
			return ResponseEntity.notFound().build();
		}
		if(nadjen.containsValue("succes"))
		{
			korisniciDAO.dodaj(kor);
			return ResponseEntity.ok().body(nadjen);
		}
		else
		{
		return ResponseEntity.ok().body(nadjen);
		}
	}
		
	
	
	
	
	@GetMapping("/korisnici")
	public List<Korisnici> getAllEmployees(){
		return korisniciDAO.findAll();
	}
	

	
	@RequestMapping(value = "/korisnici/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Korisnici> getEmployeeById(@PathVariable Integer id) {
		Korisnici emp=korisniciDAO.findOne(id);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	
	@RequestMapping(
			value="/korisnici",
			params = { "username", "password" },
			method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getKorisnikByUsernameAndPass(@RequestParam("username") String username,@RequestParam("password") String password){
		
		JSONObject emp=korisniciDAO.findUP(username,password);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	
	
	/*update an employee by empid*/
	@PutMapping("/korisnici/{id}")
	public ResponseEntity<Korisnici> updateEmployee(@PathVariable(value="id") Integer empid,@Valid @RequestBody Korisnici empDetails){
		
		Korisnici emp=korisniciDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setIme(empDetails.getIme());
		emp.setPrezime(empDetails.getPrezime());
		emp.setUsername(empDetails.getUsername());
		emp.setPassword(empDetails.getPassword());
		
		Korisnici updateEmployee=korisniciDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
		
		
		
	}
	
	/*Delete an employee*/
	@DeleteMapping("/korisnici/{id}")
	public ResponseEntity<Korisnici> deleteEmployee(@PathVariable(value="id") Integer empid){
		
		Korisnici emp=korisniciDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		korisniciDAO.delete(emp);
		
		return ResponseEntity.ok().build();
		
		
	}
}
