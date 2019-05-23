package com.sajam.springboot.entiteti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name = "sajam_automobila")
@EntityListeners(AuditingEntityListener.class)
public class Sajam_automobila implements Serializable {
		
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = -5556087172905296826L;
		/**
	 * 
	 */
	
		private int sajam_id;
	    private String naziv;
	    private String mesto;
	    
	 
	 
	    
	 
	    public Sajam_automobila() {
	    }
	    public Sajam_automobila(int id,String naziv,String mesto)
	    {
	    	super();
	    	this.sajam_id=id;
	    	this.naziv=naziv;
	    	this.mesto=mesto;
	    }
	    @Id
	    @Column(name = "sajam_id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    public int getId() {
	        return sajam_id;
	    }
	 
	    public void setId(int id) {
	        this.sajam_id = id;
	    }
	 
	    public String getNaziv() {
	        return naziv;
	    }
	 
	    public void setNaziv(String title) {
	        this.naziv = title;
	    }
	    public String getMesto() {
	        return mesto;
	    }
	 
	    public void setMesto(String mesto) {
	        this.mesto = mesto;
	    }
	 
	 
	  
	
}
