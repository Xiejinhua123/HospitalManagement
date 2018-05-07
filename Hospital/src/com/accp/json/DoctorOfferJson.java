package com.accp.json;



public class DoctorOfferJson {

	private Integer doid; // 就诊编号
	private String patient; // 患者json格式
	private String usersName; // 医生姓名
	private String registeredid; // 挂号信息json格式 
	private String symptom; // 症状
//	private Double price; // 单价
//	private String name; // 药品名称
//	private String standard; // 规格
//	private Integer number; // 总量
//	private String unit; // 单位
	private String drugJson; // 药品信息
	
	public DoctorOfferJson() {
		super();
	}

	public DoctorOfferJson(Integer doid, String patient, String usersName, String registeredid, String symptom
		) {
		super();
		this.doid = doid;
		this.patient = patient;
		this.usersName = usersName;
		this.registeredid = registeredid;
		this.symptom = symptom;
		
	}

	public Integer getDoid() {
		return doid;
	}

	public void setDoid(Integer doid) {
		this.doid = doid;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getRegisteredid() {
		return registeredid;
	}

	public void setRegisteredid(String registeredid) {
		this.registeredid = registeredid;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getDrugJson() {
		return drugJson;
	}

	public void setDrugJson(String drugJson) {
		this.drugJson = drugJson;
	}

//	public Double getPrice() {
//		return price;
//	}
//
//	public void setPrice(Double price) {
//		this.price = price;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getStandard() {
//		return standard;
//	}
//
//	public void setStandard(String standard) {
//		this.standard = standard;
//	}
//
//	public Integer getNumber() {
//		return number;
//	}
//
//	public void setNumber(Integer number) {
//		this.number = number;
//	}
//
//	public String getUnit() {
//		return unit;
//	}
//
//	public void setUnit(String unit) {
//		this.unit = unit;
//	}

	
	
	
}
