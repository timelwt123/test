package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import entity.dayxs;

import entity.kucun;
import entity.th;
import util.SessionUtil;

public class thController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelandview = new ModelAndView("th");
		String tuname = request.getParameter("tuname");
		String tbname = request.getParameter("tbname");
		Integer tnum = Integer.parseInt(request.getParameter("tnum"));
		String reson = request.getParameter("reson");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date nowdate = new Date();// 获取当前系统时间
		String df2 = df.format(nowdate);
		modelandview.addObject("dateInfo", df2);
		modelandview.addObject("tuname", tuname);
		modelandview.addObject("tbname", tbname);
		modelandview.addObject("tnum", tnum);
		modelandview.addObject("reson", reson);

		// 退货表中添加
		// 加载hibernate.cfg.xml配置
		Configuration config = new Configuration().configure();
		// 获取sessionFactory 读取解析映射文件信息，将信息复制到sessionFactory中
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 得到一个session， 让sessionFactory提供连接
		Session session = sessionFactory.openSession();
		// 开启事务，
		Transaction t = session.beginTransaction();

		// 操作

		// 退货表中不存在对象 添加
		Query query=session.createQuery("from th");
		List<th> list=query.list();
		int flag=0;
		for (th th : list) {//判断是否存在
			if((th.getBookname().equalsIgnoreCase(tbname))&&(th.getUsername().equalsIgnoreCase(tuname))) {//退货表中已经有了
				flag=1;
			}
			
		}
		if(flag==1) {//存在
			String hql="from th where bookname='tbname'"+" and username='tnume'";
			modelandview.addObject("mess1","修改1");
			Query q=session.createQuery(hql);
			List<th> listtemp=q.list();
			modelandview.addObject("mess2","修改2");
			if(listtemp==null) {
				modelandview.addObject("whe","空");
			}
			if(listtemp!=null) {
				modelandview.addObject("whe","非空");
			}
			for (th th : list) {
				if((th.getBookname().equalsIgnoreCase(tbname))&&(th.getUsername().equalsIgnoreCase(tuname))) {//退货表中已经有了
					modelandview.addObject("num",th.getThnum());
					int newthnum=th.getThnum()+tnum;
					th.setThnum(newthnum);
					session.update(th);
				}
			}
		}
		else {
			th newth=new th();
			// 创建对象，向对象中添加数据
			newth.setBookname(tbname);
			newth.setUsername(tuname);
			newth.setThnum(tnum);
			// 将数据存储到表中
			session.save(newth);
		}
		// 提交事务
		t.commit();
		// 关闭资源
		// session.close();
		// sessionFactory.close();
		//Query query = session.createQuery("from dayxs");

		//开启库存事务
		Session session2=SessionUtil.getSession();
		Transaction tkucun = session2.beginTransaction();
		kucun k = new kucun();
		Query querykucun = session2.createQuery("from kucun");// 遍历库存
		List<kucun> listku = querykucun.list();// 将查询后的结果存入数组
		int flag2=0;
		for (kucun kucun : listku) {
			if(kucun.getBookname().equalsIgnoreCase(tbname)) {//库存里存在书的时候
				flag2=1;
			}
		}
		
		if(flag2==1) {//存在 更新
			for (kucun kucun : listku) {
				if(kucun.getBookname().equalsIgnoreCase(tbname)) {//库存里存在书的时候
					int newquanity=kucun.getQuanity()+tnum;
					kucun.setQuanity(newquanity);
					session2.update(kucun);	
				}
			}
		}
		else {//不存在 添加
			kucun newkucun=new kucun();
			newkucun.setBookname(tbname);
			newkucun.setQuanity(tnum);
			session2.save(newkucun);
		}
		
		// 提交事务
		tkucun.commit();
		return modelandview;
	}

}
