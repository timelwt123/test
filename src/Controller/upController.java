package Controller;

import java.util.ArrayList;
import java.util.Arrays;
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

import entity.kucun;
import entity.upBean;
import util.SessionUtil;

public class upController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelandview = new ModelAndView("upView");
		String[] upPrice = request.getParameterValues("upPrice");
		String[] upPrice2 = request.getParameterValues("upPrice2");//存填入的数字
		System.out.println(upPrice);
		System.out.println(upPrice2);

		ArrayList<upBean> up = new ArrayList<>();
		if (upPrice2 == null) {// 提交的信息为空
			//request.setAttribute("mess", "提交的信息为空!");
			//request.getRequestDispatcher("inBook2.jsp").forward(request, response);
			return null;
		}
		//输入内容不为数字
		for (int i = 0; i < upPrice2.length; i++) {
			if(upPrice2[i]!=null&&upPrice2[i]!="") {
				if(!(upPrice2[i].charAt(0)<='9'&&upPrice2[i].charAt(0)>='0')) {
					request.setAttribute("mess", "请输入数字!");
					request.getRequestDispatcher("inBook2.jsp").forward(request, response);
					return null;
				}
			}
		}
		// 提交的信息不为空
		// 加载配置 开启事务
		Configuration config = new Configuration().configure();
		// 获取sessionFactory 读取解析映射文件信息，将信息复制到sessionFactory中
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 得到一个session， 让sessionFactory提供连接
		Session session = sessionFactory.openSession();
		// 开启事务
		Transaction t = session.beginTransaction();
		
		//String upstr=Arrays.toString(upPrice);
		System.out.println("upPrice.length:"+upPrice.length);
		System.out.println("upPrice2.length:"+upPrice2.length);
		for (int i = 0; i < upPrice.length; i++) {
			if(upPrice2[i]!=null&&upPrice2[i]!="") {//填入了报价
				//存入upBean
				Double newprice=Double.valueOf(upPrice2[i]);
				upBean newupBean=new upBean(upPrice[i], newprice);
				up.add(newupBean);
			}
		}
		Query q=session.createQuery("from kucun");
		List<kucun> list=q.list();
		for (kucun kucun : list) {
			for (upBean upe : up) {
				if(kucun.getBookname().equalsIgnoreCase(upe.getBookname())) {
					kucun.setSoldprice(upe.getSoldprice());
					session.update(kucun);
				}
			}
		}
		t.commit();
		Session session2=SessionUtil.getSession();
		Query q2=session2.createQuery("from kucun");
		modelandview.addObject("list",q2.list());
		return modelandview;
	}

}
