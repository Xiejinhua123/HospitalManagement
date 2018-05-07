package com.accp.util;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ����������ʱ�������������ɵĶ�ά��ͼƬɾ��
 * 
 * @author ���
 * @version 10.
 * @date 2017.03.16
 *
 */
public class TimerClear {
	
	/**
	 * �ڼ��2000�����ִ������
	 * 
	 * @param path
	 * 		ͼƬ·��
	 */
	public static void timer1(final String path) {
	    Timer timer = new Timer();
	    //System.out.println(new Date().toString());
	    timer.schedule(new TimerTask() {
	      @Override
		public void run() {
//	        System.out.println("-------�趨Ҫָ������--------");
//	        System.out.println(new Date().toString());
	    	  clear(path);
	      }
	    }, 2000);// �趨ָ����ʱ��time,�˴�Ϊ2000����	    
	  }
	
	/**
 	*�ڶ��ַ������趨ָ������task��ָ���ӳ�delay����й̶��ӳ�peroid��ִ��<br/>
  	* schedule(TimerTask task, long delay, long period)
	 */
	/**
	 * �ӳ�1000�����<br/>
	 * 
	 * �̶��ӳ�5000���룬ִ������
	 * 
	 * @param path
	 * 		ͼƬ·��
	 */
	 public static void timer2(final String path) {
		    Timer timer = new Timer();
//		    System.out.println(new Date().toString());
		    timer.schedule(new TimerTask() {
		      @Override
			public void run() {
//		        System.out.println("-------�趨Ҫָ������--------");
//		        System.out.println(new Date().toString());
		    	  clear(path);
		      }
		    }, 1000, 5000);
	 }
	 
	// �����ַ������趨ָ������task��ָ���ӳ�delay����й̶�Ƶ��peroid��ִ�С�
	  // scheduleAtFixedRate(TimerTask task, long delay, long period)
	 /**
	  * ���5000����<br/>
	  * 
	  * �ӳ�1000�����ִ�����
	  * 
	  * @param path
	  * 		ͼƬ·��
	  */
	 public static void timer3(final String path) {
		    Timer timer = new Timer();
//		    System.out.println(new Date().toString());
		    timer.scheduleAtFixedRate(new TimerTask() {
		      @Override
			public void run() {
		        //System.out.println("-------�趨Ҫָ������--------");
		        //System.out.println(new Date().toString());
		    	  clear(path);
//		    	  System.out.println(new Date().toString());
		      }
		    }, 1000, 5000);
		 }
	
	 // �����ַ���������ָ��������task��ָ����ʱ��firstTime��ʼ�����ظ��Ĺ̶�����periodִ�У�
	  // Timer.scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
	 /**
	  * ���һ��ִ��һ��������<br/>
	  * 
	  * ÿ���賿ִ�в���
	  * 
	  * @param path
	  * 		��ǰ��Ҫɾ����ͼƬ·��
	  */
	public static void timer4(final String path) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.HOUR_OF_DAY,0); // ����ʱ
	    calendar.set(Calendar.MINUTE, 0);    // ���Ʒ�
	    calendar.set(Calendar.SECOND, 0);    // ������
	 
	    Date time = calendar.getTime();     // �ó�ִ�������ʱ��,�˴�Ϊ�����12��00��00
//	    System.out.println(time);
	    Timer timer = new Timer();
	    timer.scheduleAtFixedRate(new TimerTask() {
	      @Override
		public void run() {
//	        System.out.println("-------�趨Ҫָ������--------");
	    	  clear(path);
	      }
	    }, time, 1000 * 60 * 60 * 24);// �����趨����ʱÿ��̶�ִ��
	  }
	
	/**
	 * ִ��ɾ�����ɾ���ļ����е��ļ�
	 * 
	 * @param path
	 * 		��ǰ�������ϵ��ļ��洢·��
	 */
	private static void clear(String path){
		
		  File file=new File(path);
		  File[] tempList = file.listFiles();

//		  System.out.println("��Ŀ¼�¶��������"+tempList.length);
		  
		  if(tempList != null){
			  for (int i = 0; i < tempList.length; i++) {
				   if (tempList[i].isFile()) {
				     //System.out.println("��     ����"+tempList[i]);
					   
					   tempList[i].delete();
					   
				   }
				   if (tempList[i].isDirectory()) {
//				    System.out.println("�ļ��У�"+tempList[i]);
				   }
			  }
		  }

	}
	
	public static void main(String[] args) {
		//clear("D://img");
		timer3("D://img");
	}
}
