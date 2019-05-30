package cn.vote.model;

/**
 * 该类是菜单项需要的菜单信息
 * 
 * @author 解金化
 */
public class MenuModel {
	
	/*
	 * 在该类中，所有的信息，都将会被重新定义为一个html代码
	 * 
	 *  改代码将会作为返回给用户界面上的菜单栏的信息显示
	 *  
	 *  在发起请求的时候将会有主键信息被上传到服务器中进行验证，含有该权限的将会放行，没有该权限的进行重新登陆验证
	 */
	
	private Integer id;
	private Integer parId;
	private String name;
	private String resIco;
	private String address;
	private Integer grade;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParId() {
		return parId;
	}
	public void setParId(Integer parId) {
		this.parId = parId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getResIco() {
		return resIco;
	}

	public void setResIco(String resIco) {
		this.resIco = resIco;
	}
}
