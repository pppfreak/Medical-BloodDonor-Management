package com.medi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medi.entity.Donor;
import com.medi.entity.Medicine;

@Repository
public class DonorDAOImpl implements DonorDAO,MedicineDAO{

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	@Transactional
	public List<Donor> getDonors() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Donor> theQuery =
				currentSession.createQuery("from Donor order by bloodGroup",Donor.class);
		
		//execute query and get result list
		List<Donor> donors = theQuery.getResultList();
		
		//return the results		
		return donors;
	}
	

	
	@Override
	@Transactional
	public void saveDonor(Donor theDonor) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theDonor);
		
	}

	@Override
	@Transactional
	public Donor getDonor(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Donor theDonor = currentSession.get(Donor.class, theId);
		return theDonor;
	}

	@Override
	@Transactional
	public void deleteDonor(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Donor where id=:donorId");
		
		theQuery.setParameter("donorId", theId);
		
		theQuery.executeUpdate();
	}

	
	//-------------------------Medicine Processing Area--------------------------
	
	@Override
	@Transactional
	public List<Medicine> getMedicines() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Medicine> theQuery= currentSession.createQuery("from Medicine",Medicine.class);
		List<Medicine> medicines=theQuery.getResultList();
		return medicines;
	}
		
	@Override
	@Transactional
	public void saveMedicine(Medicine medicine) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(medicine);
		
	}

	@Override
	@Transactional
	public void deleteMedicine(int mediId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Medicine where id=:mediId");
		
		theQuery.setParameter("mediId", mediId);
		
	    theQuery.executeUpdate();
	}

	@Override
	@Transactional
	public Medicine getMedicine(int mediId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Medicine medicine = currentSession.get(Medicine.class,mediId);
		
		return medicine;
	}

	
	

}
