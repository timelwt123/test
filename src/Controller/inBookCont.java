package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import entity.inBook;
import entity.kucun;
import entity.proBook;
import entity.th;
import util.SessionUtil;

public class inBookCont extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String inBook_Name = request.getParameter("inBook");
		Integer inBook_Num = Integer.parseInt(request.getParameter("inNum"));
		String inBook_From = request.getParameter("from");
		Double soldprice=Double.parseDouble(request.getParameter("soldprice"));
		
		ModelAndView modelandview = new ModelAndView("inBookViewjhd");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date nowdate = new Date();// 获取当前系统时间
		String df2 = df.format(nowdate);
		modelandview.addObject("dateInfo", df2);
		modelandview.addObject("bookname",inBook_Name);
		modelandview.addObject("jhnum",inBook_Num);
		modelandview.addObject("fromname",inBook_From);
		modelandview.addObject("soldprice",soldprice);
		
		
		// 退货表中添加
		// 加载hibernate.cfg.xml配置
		Configuration config = new Configuration().configure();
		// 获取sessionFactory 读取解析映射文件信息，将信息复制到sessionFactory中
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 得到一个session， 让sessionFactory提供连接
		Session session = sessionFactory.openSession();
		// 开启事务
		Transaction t = session.beginTransaction();

		// 操作

		// 进货表中不存在对象 添加
		Query query = session.createQuery("from inBook");
		
		//读取fprice供货表查询输入的信息是否正确
		Query qprobook=session.createQuery("from proBook");
		List<proBook> listpro=qprobook.list();
		double proprice=0.0;
		int flagpro=0;
		for (proBook proBook : listpro) {
			if(proBook.getPk().getBookName().equalsIgnoreCase(inBook_Name)&&proBook.getPk().getFromName().equalsIgnoreCase(inBook_From)) {
				flagpro=1;//供货表中存在
				proprice=proBook.getPrice();
				modelandview.addObject("proprice",proprice);
			}
		}
		if(flagpro==0) {
			//供货表中不存在
			request.setAttribute("mess", "输入的书名或者供应商不正确!请重新输入!");
			request.getRequestDispatcher("inBook2.jsp").forward(request, response);
			return modelandview;
		}
		double jhsumprice=proprice*inBook_Num;
		modelandview.addObject("jhsumprice", jhsumprice);
		
		//存所选书籍的供应商报价
		double bookfprice=0.0;
		Query qf=session.createQuery("from proBook");
		List<proBook> qfl=qf.list();
		for (proBook proBook : qfl) {
			if(proBook.getPk().getBookName().equalsIgnoreCase(inBook_Name)&&proBook.getPk().getFromName().equalsIgnoreCase(inBook_From)) {
				bookfprice=proBook.getPrice();
			}
		}
		
		List<inBook> list = query.list();
		int flag = 0;
		for (inBook th : list) {
			if ((th.getBookName().equalsIgnoreCase(inBook_Name))&&th.getFromName().equals(inBook_From)&&th.getFprice()==bookfprice) {// 进货表中已经有了
				flag = 1;
			}

		}
		if (flag == 1) {
			for (inBook th : list) {
				if ((th.getBookName().equalsIgnoreCase(inBook_Name))&&th.getFromName().equals(inBook_From)&&(th.getFprice()==bookfprice)) {// 进货表中已经有了
					int newthnum = th.getBookNum() + inBook_Num;
					th.setBookNum(newthnum);
					th.setFprice(bookfprice);
					session.update(th);
				}
			}
		} else {
			inBook newth = new inBook();
			// 创建对象，向对象中添加数据
			newth.setBookName(inBook_Name);
			newth.setBookNum(inBook_Num);
			newth.setFromName(inBook_From);
			newth.setFprice(bookfprice);
			// 将数据存储到表中
			session.save(newth);
		}
		// 提交事务
		t.commit();

		// 关闭资源
		// session.close();
		// sessionFactory.close();

		//开启库存事务
		Session session2=SessionUtil.getSession();
		Transaction tkucun = session2.beginTransaction();
		kucun k = new kucun();
		Query querykucun = session2.createQuery("from kucun");// 遍历库存
		List<kucun> listku = querykucun.list();// 将查询后的结果存入数组
		int flag2=0;
		for (kucun kucun : listku) {
			if(kucun.getBookname().equalsIgnoreCase(inBook_Name)) {//库存里存在书的时候
				flag2=1;
			}
		}
		
		if(flag2==1) {//存在 更新
			for (kucun kucun : listku) {
				if(kucun.getBookname().equalsIgnoreCase(inBook_Name)) {//库存里存在书的时候
					int newquanity=kucun.getQuanity()+inBook_Num;
					kucun.setQuanity(newquanity);
					kucun.setSoldprice(soldprice);
					session2.update(kucun);
				}
				
			}
		}
		else {//不存在 添加
			kucun newkucun=new kucun();
			newkucun.setBookname(inBook_Name);
			newkucun.setQuanity(inBook_Num);
			newkucun.setSoldprice(soldprice);
			session2.save(newkucun);
			
		}
		
		// 提交事务
		tkucun.commit();
		Session session3 = SessionUtil.getSession();
		Query query2 = session3.createQuery("from inBook");
		modelandview.addObject("list", query2.list());
		return modelandview;
	}

}
