package com.accp.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.accp.bizimpl.DictionaryBizImpl;
import com.accp.bizimpl.UserBizImpl;
import com.accp.demo.Common;
import com.accp.demo.Dictionary;
import com.accp.demo.Drug;
import com.accp.demo.Roles;
import com.accp.demo.UserRole;
import com.accp.demo.Users;
import com.accp.impl.RoleImpl;
import com.accp.impl.UserImpl;
import com.accp.impl.UserRoleImpl;
import com.accp.util.Generate;
import com.accp.util.HibernateUtil;
import com.accp.util.Page;

public class Main {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Main.class);
		logger.error("a");
		List<Integer> listint = (List<Integer>)null;
		if( null != listint )return;
	}

}
