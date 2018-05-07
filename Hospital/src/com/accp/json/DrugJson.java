package com.accp.json;

public class DrugJson {
	
	private Double price; // 单价
	private String name; // 药品名称
	private String standard; // 规格
	private Integer number; // 总量
	private String unit; // 单位
	
	public DrugJson(Double price, String name, String standard, Integer number, String unit) {
		super();
		this.price = price;
		this.name = name;
		this.standard = standard;
		this.number = number;
		this.unit = unit;
	}
	public DrugJson() {
		super();
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	
}
