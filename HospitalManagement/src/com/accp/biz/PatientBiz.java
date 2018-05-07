package com.accp.biz;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.accp.dao.PatientDao;
import com.accp.dao.impl.PatientImpl;
import com.accp.demo.Page;
import com.accp.demo.Patient;

/**
 * ��ǰ���ǻ��߱��ҵ������
 * 
 * @author ���
 * @version 1.0
 * 
 * 2017.03.09
 *
 */
public class PatientBiz {
	
	private Logger logger = Logger.getLogger(PatientBiz.class); // ��־����
	private PatientDao pd = new PatientImpl(); // ��ɾ�Ĳ����
	
	/**
	 * ִ�е�¼
	 * 
	 * @param name
	 * 		��������
	 * 
	 * @param pwd
	 *		���ߵ�¼���� 
	 *
	 * @return
	 * 		����null ����  ��½��Ļ��߶���
	 * 
	 * @throws Exception
	 * 		��������쳣
	 * 
	 */
	public Patient login(String name, String pwd) throws Exception{
		
		if(name == null || pwd == null || name.length() == 0 || pwd.length() ==0){
			logger.debug("��������쳣��û����ȷ�Ĳ���");
			throw new Exception("��¼ʧ�ܣ���¼���ƻ�������Ϊ��");
		}	
		
		List<Patient> list = pd.login(name, pwd);
		Patient p = null;
		for (Patient patient : list) {
			p = patient;
		}
		return p;
	}
	
	/**
	 * ִ���޸�
	 * 
	 * @param p
	 * 		�޸ĵĶ���
	 * 
	 * @return
	 * 		���ص�ǰ�޸�Ӱ�������
	 * 
	 * @throws Exception
	 * 		���ݿ��쳣�����ǰ̨�ύ������Ϣ����
	 */
	public int update(Patient p) throws Exception{
		
		if(p == null){
			
			logger.debug("�޸Ŀͻ���Ϣ���������Ϊ��");
			throw new Exception("������Ϣû����ȷ�ύ");
			
		}
		
		try {
			
			int a = pd.update(p); // ִ���޸Ĳ���������Ӱ������
			
			return a;
			
		} catch (Exception e) {
			
			logger.debug("������Ϣ�������ݿ��޸�ʧ��");
			throw new Exception("������Ϣ�ύ����");
			
		}
		
	}
	
	/**
	 * ִ��ע��
	 * 
	 * ��ǰ̨�ύ����ʱ����Ҫ��֤��ǰ�û���д����Ϣ
	 * ����ǵ绰���룺p.setPhone();
	 * ��������֤�ţ�p.setIdcard();
	 * ������û���	 ��p.setNickname();
	 * 
	 * @param p
	 * 		��Ҫ��ӵĶ���
	 * 
	 * @return
	 * 		�������ݿ�Ӱ�������
	 * 
	 * @throws Exception
	 * 		���ݿ��쳣���׳��쳣���ύ����
	 */
	public int add(Patient p) throws Exception{
		
		if(p == null){
			
			logger.debug("��ӿͻ���Ϣ���������Ϊ��");
			throw new Exception("������Ϣû����ȷ�ύ");
			
		}
		
		/*
		 * ͨ��ǰ̨�����ݼ�⣬�û���ʹ��ʲô����ע��
		 * 
		 * ���Ҷ���ע������������ݿ���֤������Ƿ����ظ�
		 * 
		 * ����ظ�������Ϣ���쳣����ʽ�׳�����ǰ̨���д���
		 */
		List<String> list = new ArrayList<String>();
		if(p.getPatPhone() != null){
			
			list = pd.getAllColumn("PatPhone");
			for (String string : list) {
				if(string == null)continue;
				if(p.getPatPhone().equals(string)){
					logger.debug("hasPhone");
					throw new Exception("hasPhone");
				}
			}
		}
		if(p.getPatNickname() != null) {

			list = pd.getAllColumn("PatNickname");
			for (String string : list) {
				if(string == null)continue;
				if(p.getPatNickname().equals(string)){
					logger.debug("hasName");
					throw new Exception("hasName");
				}					
			}
			
		}
		if(p.getPatCard() != null){
			
			list = pd.getAllColumn("PatCard");
			for (String string : list) {
				if(string == null)continue;
				if(p.getPatCard().equals(string)){
					logger.debug("hasCard");
					throw new Exception("hasCard");
				}
			}
			
		}			
		
		/**
		 * û���ظ�
		 * 
		 * ��������½�����ӻ���
		 */
		try {
			
			int a = pd.add(p); // ִ���޸Ĳ���������Ӱ������
			
			return a;
			
		} catch (Exception e) {
			
			logger.debug("������Ϣ�������ݿ��޸�ʧ��");
			throw new Exception("nothing");
			
		}
	}
	
	/**
	 * ��ҳ��ѯҳ����Ϣ
	 * 
	 * @param pagesize
	 * 		��ǰҳ��ҳ��
	 * 
	 * @return
	 * 		���ص�ǰҳ�Ļ�����Ϣ
	 */
	public Page<Patient> getAll(int pagesize){
		return pd.getPage(pagesize);
	}
	
	/**
	 * �÷��������жϵ�ǰ��¼�û�����Ϣ�Ƿ����
	 * @param name
	 * @return
	 */
	public Boolean exists(String name){
		List<String> list = new ArrayList<String>();
		list = pd.getAllColumn("PatNickname"); // ����ǳ�
		for (String s : list) {
			if(name.equals(s))
				return true;
		}
		list = pd.getAllColumn("PatCard"); // ������֤��
		for(String s : list){
			if(name.equals(s))
				return true;
		}
		list = pd.getAllColumn("PatPhone"); // ����ֻ�����
		for(String s : list){
			if(name.equals(s))
				return true;
		}
		return false;
	}
	
	public Patient getById(String patId) throws IllegalAccessException{
		if(patId == null){
			logger.debug("��ѯ������Ϣѧ����ȷ");
			throw new IllegalAccessException("idError");
		}
		Patient p = null;
		
		List<Patient> list = pd.getById(Integer.parseInt(patId));
		for (Patient patient : list) {
			
			p = patient;
			
		}
		return p;
	} 
	
	public static void main(String[] args) {
//		String name = "����";
//		String pwd = "123456789";
//		try {
//			Patient p = new PatientBiz().login(name, pwd);
//			System.out.println(p);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//System.out.println(new PatientBiz().exists("��������1"));
		
		Patient p = new Patient();
		p.setPatPassword("123456");
		p.getPatNickname();
		
	}
	
}
