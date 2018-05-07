package com.accp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	// 閸掓繂顬婇崠鏍︾娑撶寘hreadLocal鐎电钖�
	private static final ThreadLocal sessionTL = new ThreadLocal(); // 1
	private static Configuration configuration;
	public final static SessionFactory sessionFactory;
	static {
		try {
			configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static Session currentSession() {
		//sessionTL閻ㄥ埀et()閺傝纭堕弽瑙勫祦瑜版挸澧犵痪璺ㄢ柤鏉╂柨娲栭崗璺侯嚠鎼存梻娈戠痪璺ㄢ柤閸愬懘鍎撮崣姗�鍣洪敍锟�
		//娑旂喎姘ㄩ弰顖涘灉娴狀剟娓剁憰浣烘畱Session閿涘苯顧嬬痪璺ㄢ柤閹懎鍠屾稉瀣彙娴滎偅鏆熼幑顔肩氨闁剧偓甯撮弰顖欑瑝鐎瑰鍙忛惃鍕╋拷
		//ThreadLocal娣囨繆鐦夋禍鍡樼槨娑擃亞鍤庣粙瀣厴閺堝鍤滃杈╂畱Session閵嗭拷
		Session session = (Session) sessionTL.get(); // 2
		// 婵″倹鐏塻ession娑撶皠ull閿涘苯鍨幍鎾崇磻娑擄拷閲滈弬鎵畱session
		if (session == null) { // 3
			//閸掓稑缂撴稉锟介嚋閺佺増宓佹惔鎾圭箾閹恒儱顕挒顡筫ssion閵嗭拷
			session = sessionFactory.openSession(); // 4
			// 娣囨繂鐡ㄧ拠銉︽殶閹诡喖绨辨潻鐐村复session閸掔櫉hreadLocal娑擃厹锟�
			sessionTL.set(session); // 5
		}
		//婵″倹鐏夎ぐ鎾冲缁捐法鈻煎鑼病鐠佸潡妫舵潻鍥ㄦ殶閹诡喖绨辨禍鍡礉
		//閸掓瑤绮爏essionTL娑撶挴et()鐏忓崬褰叉禒銉ㄥ箯閸欐牞顕氱痪璺ㄢ柤娑撳﹥顐奸懢宄板絿鏉╁洨娈戦弫鐗堝祦鎼存捁绻涢幒銉ヮ嚠鐠灺帮拷
		return session; // 6
	}
	public static void closeSession(){
		Session session = (Session) sessionTL.get(); // 2
		sessionTL.set(null);
		if(session!=null)
			session.close();
	}

}
