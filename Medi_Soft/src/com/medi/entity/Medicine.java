package com.medi.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="medicine")
public class Medicine {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@Size(min=3,message="is required")
	@Column(name="medi_name")
	private String medi_name;
	
	@NotNull
	@Size(min=1,message="is required")
	@Column(name="price")
	private String price;
	
	public Medicine(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedi_name() {
		return medi_name;
	}

	public void setMedi_name(String medi_name) {
		this.medi_name = medi_name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", medi_name=" + medi_name + ", price=" + price + "]";
	}
	
	
}
