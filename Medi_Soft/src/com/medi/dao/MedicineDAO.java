package com.medi.dao;

import java.util.List;

import com.medi.entity.Medicine;

public interface MedicineDAO {

	List<Medicine> getMedicines();

	void saveMedicine(Medicine medicine);

	void deleteMedicine(int mediId);

	Medicine getMedicine(int mediId);
}
