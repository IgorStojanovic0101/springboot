package com.sajam.springboot.repositorys;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sajam.springboot.entiteti.*;
import com.sajam.springboot.rep.IKorisnici_findUserAndPass;
import com.sajam.springboot.rep.IKorisnici_repository;
import com.sajam.springboot.rep.getAutomobili;



@Repository
@Component
public class Korisnici_repository implements IKorisnici_findUserAndPass,getAutomobili{

	


	@Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }


	


	public Korisnici getTransactionInfo(String username,String password) {
		
	
			 Criteria criteria= getSession().createCriteria(Korisnici.class)
					.add(Restrictions.and(Restrictions.eq("username", username),Restrictions.eq("password",password)));

			 Korisnici kor=(Korisnici) criteria.uniqueResult();
			 return kor; 
	}





	public List<Sajam_automobila> getTransactionInfo() {
		List<Sajam_automobila> criteria= getSession().createCriteria(Sajam_automobila.class).list();
		return criteria;
	}





	public List<Auto> getAutomobili() {
		Criteria criteria= getSession().createCriteria(Auto.class);
		return criteria.list();
	}





	

}


