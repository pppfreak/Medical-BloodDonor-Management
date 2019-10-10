package com.medi.dao;

import java.util.List;

import com.medi.entity.Donor;
import com.medi.entity.Medicine;

public interface DonorDAO {

	public List<Donor> getDonors();

	public void saveDonor(Donor theDonor);

	public Donor getDonor(int theId);

	public void deleteDonor(int theId);


}
