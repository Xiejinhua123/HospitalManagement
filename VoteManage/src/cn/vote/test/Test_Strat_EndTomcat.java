package cn.vote.test;

import java.io.File;
import java.io.IOException;

public class Test_Strat_EndTomcat {

	public static void main(String args[]) {
		Runnable r = new ProcessOutputThread();
		r.run();
	}
	public static void deleteFile( String filePath ){
		
		File file = new File(filePath);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
			File f = files[i];
			if( f.isFile() ){
				f.delete();
			}else{
				deleteFile( files[i].getAbsolutePath() );
			}
		}
	}
	
	
}

class ProcessOutputThread extends Thread {

	@Override
	public void run() {
		
		String strcmd = "cmd /c start  D:\\tomcat\\bin\\shutdown.bat";
		Runtime rt = Runtime.getRuntime(); // Runtime.getRuntime()返回当前应用程序的Runtime对象
		Process ps = null; // Process可以控制该子进程的执行或获取该子进程的信息。
		try {
			ps = rt.exec(strcmd); // 该对象的exec()方法指示Java虚拟机创建一个子进程执行指定的可执行程序，并返回与该子进程对应的Process对象实例。
			ps.waitFor(); // 等待子进程完成再往下执行。
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int i = ps.exitValue(); // 接收执行完毕的返回值
		if (i == 0) {
			System.out.println("执行完成.");
		} else {
			System.out.println("执行失败.");
		}

		ps.destroy(); // 销毁子进程
		ps = null;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Test_Strat_EndTomcat.deleteFile("D:\\tomcat\\webapps");
		
		Runtime run=Runtime.getRuntime();
		  try {
		   run.exec("Shutdown.exe -s");
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
	}
}
