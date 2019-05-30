 package cn.vote.action;

import java.util.List;


import cn.vote.entity.Users;
import cn.vote.model.UserModel;
import cn.vote.service.UserService;
import cn.vote.util.Page;

/**
 * 用户的相关接口
 * 
 * @author 解金化，李伊昌
 *
 */
public class UserAction extends FileAction {
	private static final long serialVersionUID = 4445613304320485276L;
	
	private Page<UserModel> page=new Page<UserModel>(); // 分页对象，需要向前台返回数据
	private Integer pagesize; // 第几页
	private Integer items; // 每页多少行
	private UserService userService;
	private Users users;
	private String uuid; // 被投票人的编号
	private String name;
	private String pwd;
	private Integer labelId;
	private String orderName;
	private String tj;//查询方式
	private Integer userNumber; // 需要添加的人数 仅限于添加机器人的时候
	private String manage;
	
	
	
	/**
	 * 获取达人
	 */
	public void getExpert()
	{
		try{
			page.setItems(this.items);
			page.setPageSize(this.pagesize);
			List<UserModel> mu=this.userService.getExpert(page);
			if(mu!=null)super.setJson(mu);
			else super.setJson("fail");
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.witerJson();
		}
		
	}

	/**
	 *  获取个人信息
	 */
	public void getMyMesage()
	{
		try{
			UserModel mu=this.userService.getMyUsers();
			if(mu!=null)super.setJson(mu);
			else super.setJson("fail");
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.witerJson();
		}
	}
	public void getHimMesage()
	{
		try{
			UserModel mu=this.userService.getHimUsers(uuid);
			if(mu!=null)super.setJson("success");
			else super.setJson("fail");
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.witerJson();
		}
	}
	
	public void doUserLogin(){
		try{
			boolean b=this.userService.doLoginUser(name, pwd);
			if(b)super.setJson("success");
			else super.setJson("fail");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			super.setJson(e.getMessage());
		}finally{
			super.witerJson();
		}
	}
	/**
	 * 分也形式获取所有的用户
	 */
	public void getAllUser(){
		try{
			page.setItems(this.items);
			page.setPageSize(this.pagesize);
			if(name==null||"".equals(name))userService.getPageUser( page ,null,null);
			else userService.getPageUser( page ,name,tj);
			super.setJson(page);
		}catch(Exception e){
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	/**
	 * 获取标签用户
	 */
	public void getUserByLabelId(){
		try{
			page.setItems(this.items);
			page.setPageSize(this.pagesize);
			userService.getPageUser( page ,name,tj);
			super.setJson(page);
		}catch(Exception e){
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	/**
	 * 投票排行榜
	 */
	public void votesRanking()
	{
		try{
			page.setItems(this.items);
			page.setPageSize(this.pagesize);
			userService.getVotesRanking(page , this.orderName);
			super.setJson(page);
		}catch(Exception e){
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	
	/**
	 * 自定义添加用户信息
	 * 
	 * @return
	 * 		"success" or "error"
	 */
	public String addUser(){
		try{
			String[] urls = new String[]{};
			if( null != super.getFileFileName() && super.getFileFileName().size() > 0 )
				urls = super.addImg("/Luck/img/userAvatar/");
			
			this.userService.add(this.users , this.userNumber , urls);
			this.manage = "添加成功";
			return "success";
		}catch (Exception e) {
			this.manage = "添加失败";
			return "error";
		}
	}
	
	/**
	 * 用户可以修改自己的信息
	 */
	public void updateUser(){
		try{
			this.userService.update(this.users);
			super.setJson("success");
		}catch (Exception e) {
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}

	/**
	 * 用户投票
	 */
	public void voteing(){	
		try{
			this.userService.doVote(this.users.getTotalVotes() , this.uuid ,labelId);
			super.setJson(SUCCESS);
		}catch (Exception e) {
			super.setJson(ERROR);
		}finally{
			super.witerJson();
		}
	}
	
	
	/**
	 * 获取投票排行榜前十名
	 * @return
	 */
	public void getvoteTen()
	{
		try{
			List<UserModel> list=userService.getVoteTen();
			if(list!=null) super.setJson(list);
			else super.setJson("null");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			super.setJson(ERROR);
		}finally{
			super.witerJson();
		}
	}
	/**
	 * 页输入网红姓名查询
	 */
	public void getUserByUserName()
	{
		try{
			page.setItems(this.items);
			page.setPageSize(this.pagesize);
			userService.getPageUser( page ,name,"userName");
			super.setJson(page);
		}catch(Exception e){
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	/**
	 * 获取随机三名用户
	 * @return
	 */
	public void getThreeUser()
	{
		try{
			List<UserModel> list=userService.getrandom();
			if(list!=null) super.setJson(list);
			else super.setJson("null");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			super.setJson(ERROR);
		}finally{
			super.witerJson();
		}
	}
	/**
	 * 验证用户注册的用户名是否存在
	 */
	public void selectByName(){
		try{
			Boolean bool = this.userService.selectByName( this.users.getUserName() );
			if(bool)
				super.setJson("false");
			else
				super.setJson("success");
		}catch (Exception e) {
			super.setJson("error");
		}finally{
			super.witerJson();
		}
	}
	
	public Page<UserModel> getPage() {
		return page;
	}
	public void setPage(Page<UserModel> page) {
		this.page = page;
	}
	public Integer getItems() {
		return items;
	}
	public void setItems(Integer items) {
		this.items = items;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getLabelId() {
		return labelId;
	}

	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getTj() {
		return tj;
	}
	public void setTj(String tj) {
		this.tj = tj;
	}
	public Integer getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(Integer userNumber) {
		this.userNumber = userNumber;
	}
	public String getManage() {
		return manage;
	}
	public void setManage(String manage) {
		this.manage = manage;
	}
}
