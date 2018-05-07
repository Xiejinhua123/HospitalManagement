package com.accp.tools;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 该类用来定时将服务器上生成的二维码图片删除
 * 
 * @author 解金化
 * @version 10.
 * @date 2017.03.16
 *
 */
public class TimerClear {
	
	/**
	 * 在间隔2000毫秒后执行清理
	 * 
	 * @param path
	 * 		图片路径
	 */
	public static void timer1(final String path) {
	    Timer timer = new Timer();
	    //System.out.println(new Date().toString());
	    timer.schedule(new TimerTask() {
	      public void run() {
//	        System.out.println("-------设定要指定任务--------");
//	        System.out.println(new Date().toString());
	    	  clear(path);
	      }
	    }, 2000);// 设定指定的时间time,此处为2000毫秒	    
	  }
	
	/**
 	*第二种方法：设定指定任务task在指定延迟delay后进行固定延迟peroid的执行<br/>
  	* schedule(TimerTask task, long delay, long period)
	 */
	/**
	 * 延迟1000毫秒后<br/>
	 * 
	 * 固定延迟5000毫秒，执行清理
	 * 
	 * @param path
	 * 		图片路径
	 */
	 public static void timer2(final String path) {
		    Timer timer = new Timer();
//		    System.out.println(new Date().toString());
		    timer.schedule(new TimerTask() {
		      public void run() {
//		        System.out.println("-------设定要指定任务--------");
//		        System.out.println(new Date().toString());
		    	  clear(path);
		      }
		    }, 1000, 5000);
	 }
	 
	// 第三种方法：设定指定任务task在指定延迟delay后进行固定频率peroid的执行。
	  // scheduleAtFixedRate(TimerTask task, long delay, long period)
	 /**
	  * 间隔5000毫秒<br/>
	  * 
	  * 延迟1000毫秒后执行清除
	  * 
	  * @param path
	  * 		图片路径
	  */
	 public static void timer3(final String path) {
		    Timer timer = new Timer();
//		    System.out.println(new Date().toString());
		    timer.scheduleAtFixedRate(new TimerTask() {
		      public void run() {
		        //System.out.println("-------设定要指定任务--------");
		        //System.out.println(new Date().toString());
		    	  clear(path);
//		    	  System.out.println(new Date().toString());
		      }
		    }, 1000, 5000);
		 }
	
	 // 第四种方法：安排指定的任务task在指定的时间firstTime开始进行重复的固定速率period执行．
	  // Timer.scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
	 /**
	  * 间隔一天执行一次清理工作<br/>
	  * 
	  * 每天凌晨执行操作
	  * 
	  * @param path
	  * 		当前需要删除的图片路径
	  */
	public static void timer4(final String path) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.HOUR_OF_DAY,0); // 控制时
	    calendar.set(Calendar.MINUTE, 0);    // 控制分
	    calendar.set(Calendar.SECOND, 0);    // 控制秒
	 
	    Date time = calendar.getTime();     // 得出执行任务的时间,此处为今天的12：00：00
//	    System.out.println(time);
	    Timer timer = new Timer();
	    timer.scheduleAtFixedRate(new TimerTask() {
	      public void run() {
//	        System.out.println("-------设定要指定任务--------");
	    	  clear(path);
	      }
	    }, time, 1000 * 60 * 60 * 24);// 这里设定将延时每天固定执行
	  }
	
	/**
	 * 执行删除命令，删除文件夹中的文件
	 * 
	 * @param path
	 * 		当前服务器上的文件存储路径
	 */
	private static void clear(String path){
		
		  File file=new File(path);
		  File[] tempList = file.listFiles();

//		  System.out.println("该目录下对象个数："+tempList.length);
		  
		  if(tempList != null){
			  for (int i = 0; i < tempList.length; i++) {
				   if (tempList[i].isFile()) {
				     //System.out.println("文     件："+tempList[i]);
					   
					   tempList[i].delete();
					   
				   }
				   if (tempList[i].isDirectory()) {
//				    System.out.println("文件夹："+tempList[i]);
				   }
			  }
		  }

	}
	
	public static void main(String[] args) {
		//clear("D://img");
		timer3("D://img");
	}
}
