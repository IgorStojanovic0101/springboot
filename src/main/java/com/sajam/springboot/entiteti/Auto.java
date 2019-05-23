package com.sajam.springboot.entiteti;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "auto")
@EntityListeners(AuditingEntityListener.class)
public class Auto implements Serializable{
	
	
	/**
	 * 
	 */

	private int id;
	private String naziv;
	private String marka;
	private String boja;
	private String poreklo;
	private int ks;
	private int broj_sedista;
	private int cena;
	private byte[] slika;

	
	
	
	
	
	public Auto() {
	}
	

	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getBoja() {
		return boja;
	}
	public void setBoja(String boja) {
		this.boja = boja;
	}
	public String getPoreklo() {
		return poreklo;
	}
	public void setPoreklo(String poreklo) {
		this.poreklo = poreklo;
	}
	public int getKs() {
		return ks;
	}
	public void setKs(int ks) {
		this.ks = ks;
	}
	public int getBroj_sedista() {
		return broj_sedista;
	}
	public void setBroj_sedista(int broj_sedista) {
		this.broj_sedista = broj_sedista;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public byte[] getSlika() {
		return this.slika;
	}

	public void setSlika(byte[] slika) {
		this.slika = slika;
	}

    @Override
    public String toString() {
        return "Auto{" +
                "id='" + id + '\'' +
                ", naziv=" + naziv +
                ", marka=" + marka +
                ", boja=" + boja +
                ", poreklo=" + poreklo +
                 ", ks=" + ks +
                  ", broj_sedista=" + broj_sedista +
                   ", cena=" + cena +
                     ", slika=" + slika +
                '}';
    }

	
	
}
