package com.ssafy.edu.vue.dto;

public class CaloryDto {
	private double calory;
	private double carbo;
	private double protein;
	private double fat;
	private double sugar;
	private double natrium;
	private double chole;
	private double fatty_acid;
	private double trans_fat;
	public CaloryDto(double calory, double carbo, double protein, double fat, double sugar, double natrium,
			double chole, double fatty_acid, double trans_fat) {
		super();
		this.calory = calory;
		this.carbo = carbo;
		this.protein = protein;
		this.fat = fat;
		this.sugar = sugar;
		this.natrium = natrium;
		this.chole = chole;
		this.fatty_acid = fatty_acid;
		this.trans_fat = trans_fat;
	}
	public double getCalory() {
		return calory;
	}
	public void setCalory(double calory) {
		this.calory = calory;
	}
	public double getCarbo() {
		return carbo;
	}
	public void setCarbo(double carbo) {
		this.carbo = carbo;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getSugar() {
		return sugar;
	}
	public void setSugar(double sugar) {
		this.sugar = sugar;
	}
	public double getNatrium() {
		return natrium;
	}
	public void setNatrium(double natrium) {
		this.natrium = natrium;
	}
	public double getChole() {
		return chole;
	}
	public void setChole(double chole) {
		this.chole = chole;
	}
	public double getFatty_acid() {
		return fatty_acid;
	}
	public void setFatty_acid(double fatty_acid) {
		this.fatty_acid = fatty_acid;
	}
	public double getTrans_fat() {
		return trans_fat;
	}
	public void setTrans_fat(double trans_fat) {
		this.trans_fat = trans_fat;
	}
	@Override
	public String toString() {
		return "CaloryDto [calory=" + calory + ", carbo=" + carbo + ", protein=" + protein + ", fat=" + fat + ", sugar="
				+ sugar + ", natrium=" + natrium + ", chole=" + chole + ", fatty_acid=" + fatty_acid + ", trans_fat="
				+ trans_fat + "]";
	}
	
	
}
