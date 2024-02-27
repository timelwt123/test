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
import entity.monthxs;
import util.SessionUtil;

//添加到日销售表并修改库存

public class xsController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelandview = new ModelAndView("xsd");
		String xsname = request.getParameter("xsname");
		String uesrname = request.getParameter("uesrname");
		Integer buynum = Integer.parseInt(request.getParameter("buynum"));
		modelandview.addObject("nameInfo", xsname);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date nowdate = new Date();// 获取当前系统时间
		String df2 = df.format(nowdate);
		modelandview.addObject("dateInfo", df2);
		modelandview.addObject("username", uesrname);
		modelandview.addObject("buynum",buynum);
		
		//判断书名是否存在/库存是否足够
		Session xsjudge=SessionUtil.getSession();
		Query xsjudgeq=xsjudge.createQuery("from kucun");//读取库存
		List<kucun> listxsjudge=xsjudgeq.list();
		int flag_book=0;//书名不存在
		for (kucun kucun : listxsjudge) {//遍历库存 看书名/库存量是否合理
			if(kucun.getBookname().equalsIgnoreCase(xsname)) {
				flag_book=1;//书名存在
			}
		}
		for (kucun kucun : listxsjudge) {//遍历库存 看书名/库存量是否合理
			if((kucun.getBookname().equalsIgnoreCase(xsname))&&(kucun.getQuanity()<buynum)) {
				flag_book=2;//书名存在 库存不足
			}
		}
		if(flag_book==0) {//书名不存在
			request.setAttribute("mess", "库存中不存在该书!请重新输入!");
			request.getRequestDispatcher("销售.jsp").forward(request, response);
			return modelandview;
		}
		else if(flag_book==2) {//书名存在 库存不足
			request.setAttribute("mess", "该书库存不足!");
			request.getRequestDispatcher("销售.jsp").forward(request, response);
			return modelandview;
		}
		
		double sumprice=0.0;//总金额
		
		// 日销售表中添加
		// 加载hibernate.cfg.xml配置
		Configuration config = new Configuration().configure();
		// 获取sessionFactory 读取解析映射文件信息，将信息复制到sessionFactory中
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 得到一个session， 让sessionFactory提供连接
		Session session2 = sessionFactory.openSession();
		// 开启事务，
		Transaction txsd = session2.beginTransaction();

		
		// 操作
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from dayxs");
				//开启库存事务
				Transaction tkucun = session.beginTransaction();
				kucun k = new kucun();
				Query querykucun = session.createQuery("from kucun");// 遍历库存
				List<kucun> list = querykucun.list();// 将查询后的结果存入数组
				for (kucun kucun : list) {
					if (kucun.getBookname().equalsIgnoreCase(xsname)) {
						sumprice=kucun.getSoldprice()*buynum;
						int newquanity = kucun.getQuanity() - buynum;
						kucun.setQuanity(newquanity);
						session.update(kucun);

					}
				}
				//提交事务
				tkucun.commit();
		
		Query queryxs=session2.createQuery("from dayxs");
		List<dayxs> listxs=queryxs.list();
		int flag=0;
		for (dayxs dayxs : listxs) {
			if(dayxs.getBookname().equalsIgnoreCase(xsname)&&(dayxs.getXsday().getDay()==nowdate.getDay())) {//日销售表中存在该书籍
				flag=1;
			}
		}
		
		if(flag==1) {
			//存在 更新
			for (dayxs dayxs : listxs) {
				if(dayxs.getBookname().equalsIgnoreCase(xsname)) {
					int newquanity=dayxs.getDayquanity()+buynum;
					dayxs.setDayquanity(newquanity);
					double newsolaprice=dayxs.getSoldprice()+sumprice;
					dayxs.setSoldprice(newsolaprice);
					session2.update(dayxs);
				}
			}
		}
		else {
			//不存在 添加
			dayxs c = new dayxs();

			// 创建对象，向对象中添加数据
			c.setDayquanity(buynum);
			//c.setPk(pk1);
			c.setBookname(xsname);
			c.setXsday(nowdate);
			c.setSoldprice(sumprice);
			session2.save(c);
		}
		txsd.commit();
		
		//开启计算销量事务
		Session session3=SessionUtil.getSession();
		Transaction txl = session3.beginTransaction();
		Query qxl=session3.createQuery("from monthxs");
		monthxs m=new monthxs();
		List<monthxs> listyxl=qxl.list();
		int flagmon=0;
		for (monthxs monthxs : listyxl) {
			if(monthxs.getBookname().equalsIgnoreCase(xsname)) {
				flagmon=1;
			}
		}
		if(flagmon==1) {//销量里存在该书
			for (monthxs monthxs : listyxl) {
				int newmonthxs=monthxs.getMonthxs()+buynum;
				double newsumprice=monthxs.getMonsumprice()+sumprice;
				monthxs.setMonthxs(newmonthxs);
				monthxs.setMonsumprice(newsumprice);
				session3.update(monthxs);
			}
		}
		else {
			monthxs newmonthxs=new monthxs();
			newmonthxs.setBookname(xsname);
			newmonthxs.setMonsumprice(sumprice);
			newmonthxs.setMonthxs(buynum);
			session3.save(newmonthxs);
		}
		txl.commit();
		// 关闭资源
		// session.close();
		// sessionFactory.close();
		Session sessionnew=SessionUtil.getSession();
		Query queryku = sessionnew.createQuery("from kucun");// 再次遍历库存
		Query querydy=sessionnew.createQuery("from dayxs");
		modelandview.addObject("listrxs", querydy.list());// 打印日销售单
		modelandview.addObject("listkucun", queryku.list());// 打印库存表
		modelandview.addObject("sumprice",sumprice);
		return modelandview;
	}

}
