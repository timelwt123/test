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

//��ӵ������۱��޸Ŀ��

public class xsController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelandview = new ModelAndView("xsd");
		String xsname = request.getParameter("xsname");
		String uesrname = request.getParameter("uesrname");
		Integer buynum = Integer.parseInt(request.getParameter("buynum"));
		modelandview.addObject("nameInfo", xsname);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		Date nowdate = new Date();// ��ȡ��ǰϵͳʱ��
		String df2 = df.format(nowdate);
		modelandview.addObject("dateInfo", df2);
		modelandview.addObject("username", uesrname);
		modelandview.addObject("buynum",buynum);
		
		//�ж������Ƿ����/����Ƿ��㹻
		Session xsjudge=SessionUtil.getSession();
		Query xsjudgeq=xsjudge.createQuery("from kucun");//��ȡ���
		List<kucun> listxsjudge=xsjudgeq.list();
		int flag_book=0;//����������
		for (kucun kucun : listxsjudge) {//������� ������/������Ƿ����
			if(kucun.getBookname().equalsIgnoreCase(xsname)) {
				flag_book=1;//��������
			}
		}
		for (kucun kucun : listxsjudge) {//������� ������/������Ƿ����
			if((kucun.getBookname().equalsIgnoreCase(xsname))&&(kucun.getQuanity()<buynum)) {
				flag_book=2;//�������� ��治��
			}
		}
		if(flag_book==0) {//����������
			request.setAttribute("mess", "����в����ڸ���!����������!");
			request.getRequestDispatcher("����.jsp").forward(request, response);
			return modelandview;
		}
		else if(flag_book==2) {//�������� ��治��
			request.setAttribute("mess", "�����治��!");
			request.getRequestDispatcher("����.jsp").forward(request, response);
			return modelandview;
		}
		
		double sumprice=0.0;//�ܽ��
		
		// �����۱������
		// ����hibernate.cfg.xml����
		Configuration config = new Configuration().configure();
		// ��ȡsessionFactory ��ȡ����ӳ���ļ���Ϣ������Ϣ���Ƶ�sessionFactory��
		SessionFactory sessionFactory = config.buildSessionFactory();
		// �õ�һ��session�� ��sessionFactory�ṩ����
		Session session2 = sessionFactory.openSession();
		// ��������
		Transaction txsd = session2.beginTransaction();

		
		// ����
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from dayxs");
				//�����������
				Transaction tkucun = session.beginTransaction();
				kucun k = new kucun();
				Query querykucun = session.createQuery("from kucun");// �������
				List<kucun> list = querykucun.list();// ����ѯ��Ľ����������
				for (kucun kucun : list) {
					if (kucun.getBookname().equalsIgnoreCase(xsname)) {
						sumprice=kucun.getSoldprice()*buynum;
						int newquanity = kucun.getQuanity() - buynum;
						kucun.setQuanity(newquanity);
						session.update(kucun);

					}
				}
				//�ύ����
				tkucun.commit();
		
		Query queryxs=session2.createQuery("from dayxs");
		List<dayxs> listxs=queryxs.list();
		int flag=0;
		for (dayxs dayxs : listxs) {
			if(dayxs.getBookname().equalsIgnoreCase(xsname)&&(dayxs.getXsday().getDay()==nowdate.getDay())) {//�����۱��д��ڸ��鼮
				flag=1;
			}
		}
		
		if(flag==1) {
			//���� ����
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
			//������ ���
			dayxs c = new dayxs();

			// ����������������������
			c.setDayquanity(buynum);
			//c.setPk(pk1);
			c.setBookname(xsname);
			c.setXsday(nowdate);
			c.setSoldprice(sumprice);
			session2.save(c);
		}
		txsd.commit();
		
		//����������������
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
		if(flagmon==1) {//��������ڸ���
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
		// �ر���Դ
		// session.close();
		// sessionFactory.close();
		Session sessionnew=SessionUtil.getSession();
		Query queryku = sessionnew.createQuery("from kucun");// �ٴα������
		Query querydy=sessionnew.createQuery("from dayxs");
		modelandview.addObject("listrxs", querydy.list());// ��ӡ�����۵�
		modelandview.addObject("listkucun", queryku.list());// ��ӡ����
		modelandview.addObject("sumprice",sumprice);
		return modelandview;
	}

}
