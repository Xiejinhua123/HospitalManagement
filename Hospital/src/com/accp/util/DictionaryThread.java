package com.accp.util;

import java.util.List;

import com.accp.bizdao.DictionaryBiz;
import com.accp.bizimpl.DictionaryBizImpl;
import com.accp.demo.Common;
import com.accp.demo.Dictionary;

public class DictionaryThread extends Thread {

	private DictionaryBiz dicbiz = new DictionaryBizImpl();
	private Dictionary dic = new Dictionary();
	
	@Override
	public void run() {
		while(true){
			getDic();
			
		}
	}
	
	private synchronized void getDic(){
		
		try {
			 List<Dictionary> list = dicbiz.getAll(dic);
			 if( null != list && list.size() != 0 ){
				 for (Dictionary dic : list) {
					Common.DICTIONA_MAP.put(dic.getTypeCode(), dic);
				}
			 }
		} catch (Exception e) {
			try {
				sleep(8*1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		try {
			sleep(5*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
