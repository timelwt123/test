package Controller;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import entity.inBook;
import entity.kucun;
import entity.moreKucun;
import entity.morebook;
import entity.proBook;
import util.SessionUtil;

public class domoreController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelandview=new ModelAndView("domoreView");//名字相同 存为数组
		String[] checkop=request.getParameterValues("inornot");
		String num[]=request.getParameterValues("num");
		String checkop2=Arrays.toString(checkop);
		String num2=Arrays.toString(num);
		System.out.println(checkop);
		System.out.println(num);
		if(checkop==null) {
			request.setAttribute("mess", "勾选内容为空!");
			request.getRequestDispatcher("inBook2.jsp").forward(request, response);
			return null;
			
		}
		int mn=0;
		for (int i = 0; i < num.length; i++) {
			if(num[i]!="") {
				mn++;
			}
		}
		if(mn!=checkop.length) {
			request.setAttribute("mess", "勾选的文本内容必填/填写前请先勾选!");
			request.getRequestDispatcher("inBook2.jsp").forward(request, response);
			return null;
		}
		else if(mn==checkop.length) {
			for (int i = 0; i < checkop.length; i++) {
				if(checkop[i]==null&&checkop[i]=="") {
					if(num[i]!="") {
						request.setAttribute("mess", "勾选的文本内容必填/填写前请先勾选!");
						request.getRequestDispatcher("inBook2.jsp").forward(request, response);
						return null;
					}
				}
			}
		}
		//输入不为数字
		for (int i = 0; i < num.length; i++) {
			if(num[i]!="") {
				if(!(num[i].charAt(0)<='9'&&num[i].charAt(0)>='0')) {
					request.setAttribute("mess", "请输入数字!");
					request.getRequestDispatcher("inBook2.jsp").forward(request, response);
					return null;
				}
			}
		}
		

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date nowdate = new Date();// 获取当前系统时间
		String df2 = df.format(nowdate);
		modelandview.addObject("dateInfo", df2);
		modelandview.addObject("checkop",checkop2);//将书名+报价+供应商存入checkop数组
		modelandview.addObject("num",num2);//将相对应的进货数量存入num数组
		
		//操作
		
		/*
		 * 同单种书籍进货方式
		 * 库存表中有 更新
		 * 库存表种没有 添加
		 * */
		//加载配置 开启事务
		Configuration config = new Configuration().configure();
		// 获取sessionFactory 读取解析映射文件信息，将信息复制到sessionFactory中
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 得到一个session， 让sessionFactory提供连接
		Session session = sessionFactory.openSession();
		// 开启事务
		Transaction t = session.beginTransaction();
		
		//遍历数组
		//将获取的checkop数组存成morebook的形式
		List<String> bookname=new ArrayList<>();//存书名
		ArrayList<Double> sp=new ArrayList<>();//单个书籍报价
		ArrayList<String> fromname=new ArrayList<>();//存供应商
		ArrayList<Integer> innum=new ArrayList<>();//存进货数量
		ArrayList<morebook> morebookl=new ArrayList<>();
		
		
		//获取管理员check的以及Num
		for (int i = 0; i < checkop.length; i++) {
			String[] cp=checkop[i].split("\\+");
			System.out.println("checkop:"+checkop[i]);
			System.out.println("cp:"+cp.length);
			bookname.add(cp[0]);//存名称
			sp.add(Double.parseDouble(cp[1]));//存报价
			fromname.add(cp[2]);//存供应商
		}
		
		for (int i = 0; i < num.length; i++) {
			if(num[i]!=null&&num[i]!="")
			innum.add(Integer.parseInt(num[i]));
		}
		
		double sumprice=0.0;//所有书籍一共进货所花费的金额
		
		
		//遍历  添加到inbook批量进货表
		Query inq=session.createQuery("from inBook");
		List<inBook> inql=inq.list();
		
		for (int i = 0; i < bookname.size(); i++) {
			int flaginbook=0;
			for (int j = 0; j < inql.size(); j++) {//存在 更新
				if ((inql.get(j).getBookName().equalsIgnoreCase(bookname.get(i)))&&inql.get(j).getFromName().equals(fromname.get(i))) {// 进货表中已经有了
					flaginbook = 1;
					int newbooknum=innum.get(i)+inql.get(j).getBookNum();
					inql.get(j).setBookNum(newbooknum);
					session.update(inql.get(j));
				}
			}
			
			if(flaginbook==0) {//不存在 添加
				inBook newinbook=new inBook();
				newinbook.setBookName(bookname.get(i));
				newinbook.setBookNum(innum.get(i));
				newinbook.setFromName(fromname.get(i));
				newinbook.setFprice(sp.get(i));
				session.save(newinbook);
			}
			sumprice=sumprice+(sp.get(i)*innum.get(i));//计算进货消费的总金额
			morebook newmorebook=new morebook(bookname.get(i), fromname.get(i), sumprice, nowdate, innum.get(i));
			morebookl.add(newmorebook);

		}
		t.commit();
		Session newsession=SessionUtil.getSession();
		
		
		/*
		 * 当输入的书籍名字一样可库存表里面没有的时候 添加会出现错误 会添加两次（库存 报价不同的两行）
		 * 需要对传入的数组进行处理 存入moreKucun类中(只存名称 数量的亚库存)
		 * 名字相同的书籍在数组中一定是挨在一起的
		 * 前后相同的时候 合并 没有相同的直接存
		 * */
		Set<String> hSet = new HashSet<String>();//Set数组 存不重复元素
		ArrayList<moreKucun> morekucun=new ArrayList<>();
		int[] tn=new int[100];
		for (int i = 0; i < bookname.size(); i++) {
			if(!hSet.contains(bookname.get(i))) {
				
				//不存在 存入
				hSet.add(bookname.get(i));
			}
		}
		System.out.println(hSet.toString());
		for (String string : hSet) {
			int numm=0;
			double soldprice=0.0;
			for (int i = 0; i < bookname.size(); i++) {
				if(string.equals(bookname.get(i))) {
					soldprice=sp.get(i);
					if(sp.get(i)>soldprice) {
						soldprice=sp.get(i);
					}
					
				}
				}
			for (int j = 0; j < morebookl.size(); j++) {
				if(morebookl.get(j).getBookname().equalsIgnoreCase(string)) {
					numm+=morebookl.get(j).getNum();
					System.out.println(string+" ");
					System.out.println(morebookl.get(j).getBookname()+" ");
					System.out.println(numm);
					}
				}
			moreKucun newmorekucun=new moreKucun(string, numm, soldprice);
			morekucun.add(newmorekucun);
		}
		
		modelandview.addObject("ml",morebookl);
		modelandview.addObject("innum",innum.toString());
		ArrayList<Integer> temp=new ArrayList<>();
		
		modelandview.addObject("morekucun",morekucun);
		//存入库存 开启库存事务
		/*
		 * 遍历morekucun数组 存在更新 不存在添加
		 * */
		Session session2=SessionUtil.getSession();
		Transaction tkucun = session2.beginTransaction();
		kucun k = new kucun();
		Query querykucun = session2.createQuery("from kucun");// 遍历库存
		List<kucun> listku = querykucun.list();// 将查询后的结果存入数组
		
		for (int i = 0; i < morekucun.size(); i++) {
			int flag2=0;
				for (int j = 0; j < listku.size(); j++) {
					if(morekucun.get(i).getBookname().equalsIgnoreCase(listku.get(j).getBookname())) {
						//库存里存在的时候 更新
						int newquanity=listku.get(j).getQuanity()+morekucun.get(i).getQuanity();
						listku.get(j).setQuanity(newquanity);
						session2.update(listku.get(j));
						flag2=1;
						modelandview.addObject("mess1","更新1");
					}
				}
				if(flag2==0) {
					//不存在 添加
					kucun newkucun=new kucun();
					newkucun.setBookname(morekucun.get(i).getBookname());
					newkucun.setQuanity(morekucun.get(i).getQuanity());
					newkucun.setSoldprice(morekucun.get(i).getPrice());
					session2.save(newkucun);
				}
				modelandview.addObject("mess2","添加1");
		}
		// 提交事务
		tkucun.commit();
		/*for (int i = 0; i < innum.size(); i++) {
			int flag2=0;
			for (int j = 0; j < listku.size(); j++) {
				if(bookname.get(i).equalsIgnoreCase(listku.get(j).getBookname())) {
					//库存里存在书的时候 更新
					int newquanity=listku.get(j).getQuanity()+innum.get(i);
					listku.get(j).setQuanity(newquanity);
					//listku.get(i).setSoldprice(sp.get(i));
					session2.update(listku.get(j));
					flag2=1;
					modelandview.addObject("mess1","更新1");
				}
			}
			if(flag2==0) {
			//不存在 添加
			kucun newkucun=new kucun();
			newkucun.setBookname(bookname.get(i));
			newkucun.setQuanity(innum.get(i));
			newkucun.setSoldprice(sp.get(i));
			modelandview.addObject("mess2","添加1");
			session2.save(newkucun);
			}
		}*/
		
		return modelandview;
	}

}
