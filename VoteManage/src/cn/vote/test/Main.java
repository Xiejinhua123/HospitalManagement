package cn.vote.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.ParseException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.xml.internal.bind.v2.model.core.Ref;

import sun.reflect.generics.tree.Tree;

import cn.vote.dao.AdminDao;
import cn.vote.dao.AdminResourceDao;
import cn.vote.dao.AwardsDao;
import cn.vote.dao.ResourceDao;
import cn.vote.dao.UserDao;
import cn.vote.dao.impl.AwardsDaoImpl;
import cn.vote.entity.Admin;
import cn.vote.entity.AdminResource;
import cn.vote.entity.Awards;
import cn.vote.entity.Game;
import cn.vote.entity.Resource;
import cn.vote.entity.Users;
import cn.vote.model.BoxAwardsModel;
import cn.vote.model.MenuModel;
import cn.vote.service.GameService;
import cn.vote.service.LoveService;
import cn.vote.service.UserService;
import cn.vote.service.impl.GameServiceImpl;
import cn.vote.service.impl.LoveServiceImpl;

public class Main {

	public void show() {
		int j = 0;
		for (int i = 0; i < 1000; i++) {
			double d = Math.random();
			if (0.06 > d)
				j++;
		}
		System.out.println("中奖" + j + "次");
	}

//	int grade = 0;

	/**
	 * 递归算法
	 * 
	 * 用来组建菜单
	 * 
	 * 该方法将不涵盖以及菜单，如果是一级菜单的话，需要从集合中单独拿出来进行循环
	 * 
	 * 循环一级菜单，循环期间调用该递归方法
	 * 
	 * @param list
	 * 		需要的数据库中查询出来的所有集合
	 * 
	 * @param parentId
	 * 		父级编号
	 */
	public void dg(List<MenuModel> list, int parentId) {
			System.out.println("<ul>");
		
		for (MenuModel m : list) {
			if (m.getParId() == parentId) {
//				grade = m.getGrade();
				System.out.println("<li>" + m.getId() + m.getName());
				dg(list, m.getId());
				System.out.println("</li>");
			}
		}
		
			System.out.println("</ul>");
	}

	public static void main(String[] args) {

		// ApplicationContext ac = new
		// ClassPathXmlApplicationContext("applicationContext*.xml");
		//
		// ResourceDao ad = ac.getBean(ResourceDao.class);
		// Resource r = new Resource();
		// r.setId(23);
		// Resource b = ad.getById( r.getId() );
		// System.out.println(b);

//		List<MenuModel> list = new ArrayList<MenuModel>();
//		MenuModel mm = new MenuModel();
//		mm.setId(1);
//		mm.setGrade(1);
//		mm.setName("一级");
//		mm.setParId(null);
//		MenuModel mm1 = new MenuModel();
//		mm1.setId(2);
//		mm1.setGrade(2);
//		mm1.setName("二级，父级是一");
//		mm1.setParId(1);
//		MenuModel mm2 = new MenuModel();
//		mm2.setId(3);
//		mm2.setGrade(2);
//		mm2.setName("二级，父级是1");
//		mm2.setParId(1);
//		MenuModel mm3 = new MenuModel();
//		mm3.setId(4);
//		mm3.setGrade(3);
//		mm3.setName("三级，父级是3");
//		mm3.setParId(3);
//		MenuModel mm4 = new MenuModel();
//		mm4.setId(5);
//		mm4.setGrade(1);
//		mm4.setName("一级");
//		mm4.setParId(null);
//		MenuModel mm5 = new MenuModel();
//		mm5.setId(6);
//		mm5.setGrade(2);
//		mm5.setName("二级，父级是5");
//		mm5.setParId(5);
//		list.add(mm1);
//		list.add(mm3);
//		list.add(mm4);
//		list.add(mm2);
//		list.add(mm);
//		list.add(mm5);
//
//		List<MenuModel> list1 = new ArrayList<MenuModel>();
//		list1.addAll(list);
//
//		Main m = new Main();
//
//		List<MenuModel> l = new ArrayList<MenuModel>();
//		for (MenuModel mmm : list) {
//
//			if (mmm.getGrade() == 1) {
//				list1.remove(mmm);
//				l.add(mmm);
//			}
//
//		}
//
//		for (MenuModel m1 : l) {
//			System.out.println("<li>" + m1.getId() + m1.getName());
//			m.dg(list1, m1.getId());
//			System.out.println("</li>");
//		}

		/**
		 * 1 2 3 4 5 6
		 */

		// String html = new Main().toHtml(list);
		// System.out.println(html);

		// for( int i = 0 ; i < 100000; i++ ){
		//
		// String id = new Date().getTime()+"";
		// id = i%9 + id.substring( 1, id.length() );
		//
		// Users u = new Users();
		// u.setBoxNumber(0);
		// u.setBallNumber(0);
		// u.setBirthday(new Date());
		// u.setDeleteds(0);
		// u.setId( id );
		// u.setLoveNumber(0);
		// u.setTelephone("13838838438");
		// u.setTotalVotes(0);
		// u.setUserAvatar("D://");
		// u.setWechatName("");
		// u.setTelephone("13598838569");
		// u.setTotalVotes(0);
		// u.setUserName("1");
		// u.setUserPassword("123456");
		// u.setUserType(0);
		// u.setVoteNumber(0);
		//
		// UserDao userDao = ac.getBean(UserDao.class);
		// userDao.addUser(u);
		// }
		//

		// GameService gs = (GameService) ac.getBean("gameService");
		// AwardsDao awardsDao = (AwardsDao) ac.getBean("awardsDao");

		// List<Awards> awards = awardsDao.getByGameId( 2 ); //
		// 这个奖项应该是按照概率从小到大自动排列
		// for (int i = 0; i < awards.size(); i++) {
		// Awards a = awards.get(i);
		// System.out.println(a.getId() + "\t" + a.getProbability());
		// }
		//
		// BoxAwardsModel b = gs.getBam(1, awards);
		//
		// System.out.println("中奖商品：");
		// System.out.println("名称" + "\t" + "数量");
		// Map<String , Integer> goods = new HashMap<String, Integer>();
		// goods = b.getGoods();
		// if( null != goods )
		// for (String s : goods.keySet()) {
		// System.out.println(s + "\t" + goods.get(s));
		// }
		//
		// System.out.println("中奖龙珠：");
		// System.out.println("名称" + "\t" + "数量");
		// Map<String , Integer> balls = b.getBalls();
		// if( null != balls )
		// for (String s : balls.keySet()) {
		// System.out.println(s + "\t" + balls.get(s));
		// }
		//
		// System.out.println("中奖的宝箱：" + b.getBoxNumber());
		// System.out.println("中奖的爱心：" + b.getLovaNumber());

		// UserDao ud = (UserDao) ac.getBean("userDao");
		//
		// for (int i = 1300; i < 100000; i++) {
		//
		//
		// Users u = new Users();
		// u.setBoxNumber(0);
		// u.setDeleted(0);
		// u.setId(""+i);
		// u.setLoveNumber(0);
		// u.setTelephone("13838838438");
		// u.setTotalVotes(0);
		// u.setUserAvatar("D://");
		// u.setWechatName(i+"");
		// System.out.println( ud.addUser(u) );
		// }
		//
		//
		// try {
		// aaa(new Date().toLocaleString(),date.toLocaleString());
		// } catch (java.text.ParseException e1) {
		// e1.printStackTrace();
		// }

		// AdminDao ad = ac.getBean(AdminDao.class);
		// Admin a = new Admin();
		// a.setDeleted(0);
		// a.setManageAccount("admin");
		// a.setManagePassword(new MD5("admin").compute());
		// a.setName("123");
		// a.setRank(1);
		// a.setTelephone("13838838438");
		// try{
		// ad.insert( a );
		// }catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	public static void aaa(String tn, String to)
			throws java.text.ParseException {
		String t1 = to;
		String t2 = tn;

		Date d1 = null;
		Date d2 = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		d1 = sdf.parse(t1);
		d2 = sdf.parse(t2);

		long dd1 = d1.getTime();
		long dd2 = d2.getTime();
		// double hours = (double)(dd2-dd1)/3600/1000;
		double hours = (double) (dd2 - dd1) / 1000;
		System.out.println("时间差是：" + hours + "秒");
	}
}
