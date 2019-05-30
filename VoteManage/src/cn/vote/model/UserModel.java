package cn.vote.model;

import java.util.Date;
import java.util.List;

import cn.vote.entity.Lable;

/**
 * 首页显示用户信息
 * 
 * @author 解金化
 *
 */
public class UserModel {
	
	private String imgUrl;
	private String id;
	private String name;
	private Date birthday;
	private String telephone;
	private Integer voteNumber; // 手中剩余没有投出去的票数
	private Integer totalVotes; // 得票总数
	private Integer boxNumber; // 拥有宝箱总数
	private Integer ballNumber; // 所有的龙珠总数
	private Integer loveNumber; // 拥有爱心总数
	private List<Lable> labelList;
	private Integer maxLabelNum;
	private Integer oneball;
	private Integer twoball;
	private Integer threeball;
	private Integer fourball;
	private Integer fiveball;
	private Integer sixball;
	private Integer sevenball;
	private String operations;
	private String userType;
	private String deleteds;
	
	public String getDeleteds() {
		return deleteds;
	}
	public void setDeleteds(String deleteds) {
		this.deleteds = deleteds;
	}
	public String getOperations() {
		return operations;
	}
	public void setOperations(String operations) {
		this.operations = operations;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getId() {
		return id;
	}
	public Integer getBallNumber() {
		return ballNumber;
	}
	public void setBallNumber(Integer ballNumber) {
		this.ballNumber = ballNumber;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTotalVotes() {
		return totalVotes;
	}
	public void setTotalVotes(Integer totalVotes) {
		this.totalVotes = totalVotes;
	}
	public Integer getBoxNumber() {
		return boxNumber;
	}
	public void setBoxNumber(Integer boxNumber) {
		this.boxNumber = boxNumber;
	}
	public Integer getLoveNumber() {
		return loveNumber;
	}
	public void setLoveNumber(Integer loveNumber) {
		this.loveNumber = loveNumber;
	}
	public Integer getVoteNumber() {
		return voteNumber;
	}
	public void setVoteNumber(Integer voteNumber) {
		this.voteNumber = voteNumber;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getOneball() {
		return oneball;
	}
	public void setOneball(Integer oneball) {
		this.oneball = oneball;
	}
	public Integer getTwoball() {
		return twoball;
	}
	public void setTwoball(Integer twoball) {
		this.twoball = twoball;
	}
	public Integer getThreeball() {
		return threeball;
	}
	public void setThreeball(Integer threeball) {
		this.threeball = threeball;
	}
	public Integer getFourball() {
		return fourball;
	}
	public void setFourball(Integer fourball) {
		this.fourball = fourball;
	}
	public Integer getFiveball() {
		return fiveball;
	}
	public void setFiveball(Integer fiveball) {
		this.fiveball = fiveball;
	}
	public Integer getSixball() {
		return sixball;
	}
	public void setSixball(Integer sixball) {
		this.sixball = sixball;
	}
	public Integer getSevenball() {
		return sevenball;
	}
	public void setSevenball(Integer sevenball) {
		this.sevenball = sevenball;
	}
	public List<Lable> getLabelList() {
		return labelList;
	}
	public void setLabelList(List<Lable> labelList) {
		this.labelList = labelList;
	}
	public Integer getMaxLabelNum() {
		return maxLabelNum;
	}
	public void setMaxLabelNum(Integer maxLabelNum) {
		this.maxLabelNum = maxLabelNum;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	
}
