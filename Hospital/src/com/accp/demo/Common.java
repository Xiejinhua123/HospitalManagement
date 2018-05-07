package com.accp.demo;

import java.util.Hashtable;
import java.util.Map;

import com.accp.util.DictionaryThread;

public class Common {
	
	/**
	 * 数据字典的文件读取
	 * 
	 * 数据字典
	 */
	public static Map<String,Dictionary> DICTIONA_MAP = new Hashtable<>();
	
	static{
		new DictionaryThread().start();
	}
	
}
