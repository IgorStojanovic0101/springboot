package com.sajam.springboot.DAO;

import java.util.Base64;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sajam.springboot.entiteti.Auto;
import com.sajam.springboot.entiteti.Korisnici;
import com.sajam.springboot.entiteti.Sajam_automobila;
import com.sajam.springboot.rep.IKorisnici_findUserAndPass;
import com.sajam.springboot.rep.IKorisnici_repository;
import com.sajam.springboot.rep.Sajam_repository;
import com.sajam.springboot.rep.getAutomobili;




@Service
public class KorisniciDAO {
	
	@Autowired
	private IKorisnici_repository korisniciRepository;
	
	
	@Autowired
	private IKorisnici_findUserAndPass fup;
	
	
	@Autowired
	private Sajam_repository Repository;
	
	 
	@Autowired
	private getAutomobili ga;
	
	public List<Sajam_automobila> lista_sajmova()
	{
		return ga.getTransactionInfo();
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject findUP(String username,String password) {
		 Korisnici korisnik=fup.getTransactionInfo(username,password);
		 JSONObject nekiobjekat=new JSONObject();
		 nekiobjekat.put("korisnik",korisnik);
		 
		 return nekiobjekat;
	}
	@SuppressWarnings("unchecked")
	public JSONObject lista_automobila()
	{
		List<Auto> lista=ga.getAutomobili();
		JSONObject sampleObject = new JSONObject();
		JSONArray ar=new JSONArray();
		
		
	        for(int i=0;i<lista.size();i++)
	        {
	        	 Object o = (Object)lista.get(i);
	             Auto p = (Auto)o; 
	         	JSONObject object = new JSONObject();
	         	
	         	object.put("id",p.getId());
	         	object.put("naziv",p.getNaziv());
	         	object.put("marka",p.getMarka());
	         	object.put("boja",p.getBoja());
	         	object.put("poreklo",p.getPoreklo());
	         	object.put("ks",p.getKs());
	         	object.put("broj_sedista",p.getBroj_sedista());
	         	object.put("cena",p.getCena());
	         	
	         
	         	
	         	
	         	
	         	
	         		object.put("slika",p.getSlika());
	         	
	      
	             ar.add(object);
	        }
	        sampleObject.put("automobili",ar);
	        
		return sampleObject;
	}
		
	public void dodaj(Korisnici korisnik)
		{
			korisniciRepository.save(korisnik);
		}
	public Sajam_automobila save(Sajam_automobila emp) {
		
		return Repository.save(emp);
	}
	
	
	/* search all employees*/
	
	public List<Sajam_automobila> findAllSajams(){
		return Repository.findAll();
	}
	
	
	/*get an employee by id*/
	public Sajam_automobila findOneSajam(Integer korID) {
		int dd=Integer.parseInt(korID.toString());
		return Repository.findOne(korID);
	}
	
	
	

	
	/*delete an employee*/
	
	public void delete(Sajam_automobila emp) {
		Repository.delete(emp);
	}


	public Sajam_automobila Prosledi(Sajam_automobila k) {
		return Repository.save(k);
		
	}
	/*to save an employee*/
	
	public Korisnici save(Korisnici emp) {
		
		return korisniciRepository.save(emp);
	}
	
	
	/* search all employees*/
	
	public List<Korisnici> findAll(){
		return korisniciRepository.findAll();
	}
	
	
	/*get an employee by id*/
	public Korisnici findOne(Integer korID) {
		return korisniciRepository.findOne(korID);
	}
	@SuppressWarnings("unchecked")
	public JSONObject findUserAndPass(String  username,String pass) {
		
	Korisnici k=fup.getTransactionInfo(username, pass);
		 JSONObject nekiobjekat=new JSONObject();
		 if(k==null)
		 {
		 nekiobjekat.put("korisnik","succes");
		 return nekiobjekat;
		 }
		 else
		 {
			 nekiobjekat.put("korisnik","false");
			 return nekiobjekat;
		 }
		
	}
	
	
	
	
	
	
	
	/*delete an employee*/
	
	public void delete(Korisnici emp) {
		korisniciRepository.delete(emp);
	}


	public Korisnici Prosledi(Korisnici k) {
		return korisniciRepository.save(k);
		
	}


	

}
