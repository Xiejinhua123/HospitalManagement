package com.accp.bizimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.accp.bizdao.PatientBiz;
import com.accp.dao.PatientDao;
import com.accp.demo.Common;
import com.accp.demo.Dictionary;
import com.accp.demo.Patient;
import com.accp.impl.PatientImpl;
import com.accp.util.Page;

/**
 * 患者表的业务处理
 * @author xueshe01
 *
 */
public class PatientBizImpl implements PatientBiz {

	private Logger logger = Logger.getLogger(PatientBizImpl.class);
	private PatientDao patdao = new PatientImpl();
	
	@Override
	public Patient login(String name, String pwd) throws Exception {
		String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";  
		String card="(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9X])";
		Pattern pattern = Pattern.compile(regExp);//放入手机正则表达式
		Pattern sfCard=Pattern.compile(card,Pattern.CASE_INSENSITIVE);//放入身份证号正则表达式
		Matcher sj = pattern.matcher(name);//验证字符串放入   手机正则表达式中
		Matcher sf = sfCard.matcher(name);//验证字符串放入  身份证号正则表达式中
		
		Patient p = new Patient();
		if(sj.matches()) // 手机号
		{
			p.setPatPhone(name); // 手机号登录
		}
		else if(sf.matches()) // 身份证号
		{
			p.setPatCard(name); // 身份证登录
		}
		else // 用户名登录
		{
			p.setPatName(name); // 姓名登录
		}
		p.setPatPassword(pwd);
		
		List<Patient> list = getByColumn(p);
		
		if( null == list || list.size() == 0 ){
			p.setPatPassword(null);
			List<Patient> list1 = getByColumn(p);
			if( null == list1 || list1.size() == 0 ){
				logger.debug("登录失败，用户名不存在");
				throw new Exception("name is not found");				
			}else{
				logger.debug("登录失败，密码错误");
				throw new Exception("pwd is error");
			}
		}
		else{
			Patient pat = list.get(0);
			
			if( pat.getOnlineState().equals("1001") ){
				
				logger.debug("当前用户已经登录");
				throw new Exception("have login");
			}else{
				return pat;
			}
			
		}
	}

	@Override
	public Patient add(Patient p) throws Exception {
		
		if( null == p ){
			logger.debug("患者注册失败，某些信息不正确");
			throw new Exception("patient add() parameter is null");
		}
		
		/**
		 * 验证当下传过来的信息是否在数据库中重复
		 */
		Patient patient = new Patient();
		List<Patient> list = new ArrayList<Patient>();
		patient.setPatName(p.getPatName());
		patient.setPatPassword(p.getPatPassword());
		list = getByColumn(patient);
		if( list.size() != 0 ){
			throw new Exception("name");
		}
		patient = new Patient();
		patient.setPatCard(p.getPatCard());
		list = new ArrayList<Patient>();
		list = getByColumn(patient);
		if( list.size() == 1 ){ // 查到一个
			throw new Exception("card");
		}
		patient = new Patient();
		patient.setPatPhone(p.getPatPhone());
		list = new ArrayList<Patient>();
		list = getByColumn(patient);
		if( list.size() == 1 ){
			throw new Exception("phone");
		}
		
		/**
		 * 其中的信息在数据库中不存在
		 * 需要手动添加
		 */
		//数据字典访问
		Map<String,Dictionary> map = null;
		while(true){
			try{
				map = Common.DICTIONA_MAP;
				break;
			}catch(Exception e){
				wait(100);
				continue;
			}
		}
		for (Dictionary dic : map.values()) {
			if( dic.getTypeValus().equals("下线") ){
				p.setOnlineState(dic.getTypeCode());
				break;
			}
		}
		p.setCreateTime(new Date());
		p.setModifyTime(new Date());
		p.setLastLogin(null);
		
		Object obj = patdao.add(p);
		return getById((Integer) obj);
		
	}

	@Override
	public Patient update(Patient p) throws Exception {
		
		if( null == p || null == p.getPatId() ){
			logger.debug("修改患者信息失败");
			throw new Exception("patient update() parameter is error");
		}
		
		Boolean bool = patdao.update(p);
		
		if(bool)return getById(p.getPatId()); 
		else return null;
	}

	@Override
	public Boolean del(List<Integer> patId) throws Exception {
		if( null == patId || patId.size() <= 0 ){
			logger.debug("删除患者信息失败");
			throw new Exception("patient del() parameter is error");
		}
		int count = patId.size();
		int j = 0;
		
		for (Integer id : patId) {
			if(patdao.del(id))j++;
		}
		if(count == j)return true;
		else return false;
	}

	@Override
	public Patient getById(Integer id) throws Exception {
		if ( null == id || id <= 0 ){
			logger.debug("通过编号获取患者信息失败");
			throw new Exception("patient getById() parameter is error");
		}
		Patient p = new Patient();
		p.setPatId(id);
		List<Patient> list = getByColumn(p);
		if( null == list || list.size() == 0 )
			return null;
		Patient patient = list.get(0);
		return patient;
	}

	@Override
	public void getPage(Page<Patient> page, Patient p) throws Exception {
		if( null == page || page.getItems() <= 0 || page.getPagesize() <= 0 ){
			logger.debug("分页查询患者信息失败");
			throw new Exception("patient getPage() parameter is error");
		}
		patdao.getPage(page,p);
	}

	@Override
	public List<Patient> getByColumn(Patient p) throws Exception {	
		
		return patdao.getByColumn(p);
	}

}
