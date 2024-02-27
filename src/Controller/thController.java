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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		Date nowdate = new Date();// ��ȡ��ǰϵͳʱ��
		String df2 = df.format(nowdate);
		modelandview.addObject("dateInfo", df2);
		modelandview.addObject("tuname", tuname);
		modelandview.addObject("tbname", tbname);
		modelandview.addObject("tnum", tnum);
		modelandview.addObject("reson", reson);

		// �˻��������
		// ����hibernate.cfg.xml����
		Configuration config = new Configuration().configure();
		// ��ȡsessionFactory ��ȡ����ӳ���ļ���Ϣ������Ϣ���Ƶ�sessionFactory��
		SessionFactory sessionFactory = config.buildSessionFactory();
		// �õ�һ��session�� ��sessionFactory�ṩ����
		Session session = sessionFactory.openSession();
		// ��������
		Transaction t = session.beginTransaction();

		// ����

		// �˻����в����ڶ��� ���
		Query query=session.createQuery("from th");
		List<th> list=query.list();
		int flag=0;
		for (th th : list) {//�ж��Ƿ����
			if((th.getBookname().equalsIgnoreCase(tbname))&&(th.getUsername().equalsIgnoreCase(tuname))) {//�˻������Ѿ�����
				flag=1;
			}
			
		}
		if(flag==1) {//����
			String hql="from th where bookname='tbname'"+" and username='tnume'";
			modelandview.addObject("mess1","�޸�1");
			Query q=session.createQuery(hql);
			List<th> listtemp=q.list();
			modelandview.addObject("mess2","�޸�2");
			if(listtemp==null) {
				modelandview.addObject("whe","��");
			}
			if(listtemp!=null) {
				modelandview.addObject("whe","�ǿ�");
			}
			for (th th : list) {
				if((th.getBookname().equalsIgnoreCase(tbname))&&(th.getUsername().equalsIgnoreCase(tuname))) {//�˻������Ѿ�����
					modelandview.addObject("num",th.getThnum());
					int newthnum=th.getThnum()+tnum;
					th.setThnum(newthnum);
					session.update(th);
				}
			}
		}
		else {
			th newth=new th();
			// ����������������������
			newth.setBookname(tbname);
			newth.setUsername(tuname);
			newth.setThnum(tnum);
			// �����ݴ洢������
			session.save(newth);
		}
		// �ύ����
		t.commit();
		// �ر���Դ
		// session.close();
		// sessionFactory.close();
		//Query query = session.createQuery("from dayxs");

		//�����������
		Session session2=SessionUtil.getSession();
		Transaction tkucun = session2.beginTransaction();
		kucun k = new kucun();
		Query querykucun = session2.createQuery("from kucun");// �������
		List<kucun> listku = querykucun.list();// ����ѯ��Ľ����������
		int flag2=0;
		for (kucun kucun : listku) {
			if(kucun.getBookname().equalsIgnoreCase(tbname)) {//�����������ʱ��
				flag2=1;
			}
		}
		
		if(flag2==1) {//���� ����
			for (kucun kucun : listku) {
				if(kucun.getBookname().equalsIgnoreCase(tbname)) {//�����������ʱ��
					int newquanity=kucun.getQuanity()+tnum;
					kucun.setQuanity(newquanity);
					session2.update(kucun);	
				}
			}
		}
		else {//������ ���
			kucun newkucun=new kucun();
			newkucun.setBookname(tbname);
			newkucun.setQuanity(tnum);
			session2.save(newkucun);
		}
		
		// �ύ����
		tkucun.commit();
		return modelandview;
	}

}
