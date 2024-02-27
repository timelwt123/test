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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		Date nowdate = new Date();// ��ȡ��ǰϵͳʱ��
		String df2 = df.format(nowdate);
		modelandview.addObject("dateInfo", df2);
		modelandview.addObject("bookname",inBook_Name);
		modelandview.addObject("jhnum",inBook_Num);
		modelandview.addObject("fromname",inBook_From);
		modelandview.addObject("soldprice",soldprice);
		
		
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

		// �������в����ڶ��� ���
		Query query = session.createQuery("from inBook");
		
		//��ȡfprice�������ѯ�������Ϣ�Ƿ���ȷ
		Query qprobook=session.createQuery("from proBook");
		List<proBook> listpro=qprobook.list();
		double proprice=0.0;
		int flagpro=0;
		for (proBook proBook : listpro) {
			if(proBook.getPk().getBookName().equalsIgnoreCase(inBook_Name)&&proBook.getPk().getFromName().equalsIgnoreCase(inBook_From)) {
				flagpro=1;//�������д���
				proprice=proBook.getPrice();
				modelandview.addObject("proprice",proprice);
			}
		}
		if(flagpro==0) {
			//�������в�����
			request.setAttribute("mess", "������������߹�Ӧ�̲���ȷ!����������!");
			request.getRequestDispatcher("inBook2.jsp").forward(request, response);
			return modelandview;
		}
		double jhsumprice=proprice*inBook_Num;
		modelandview.addObject("jhsumprice", jhsumprice);
		
		//����ѡ�鼮�Ĺ�Ӧ�̱���
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
			if ((th.getBookName().equalsIgnoreCase(inBook_Name))&&th.getFromName().equals(inBook_From)&&th.getFprice()==bookfprice) {// ���������Ѿ�����
				flag = 1;
			}

		}
		if (flag == 1) {
			for (inBook th : list) {
				if ((th.getBookName().equalsIgnoreCase(inBook_Name))&&th.getFromName().equals(inBook_From)&&(th.getFprice()==bookfprice)) {// ���������Ѿ�����
					int newthnum = th.getBookNum() + inBook_Num;
					th.setBookNum(newthnum);
					th.setFprice(bookfprice);
					session.update(th);
				}
			}
		} else {
			inBook newth = new inBook();
			// ����������������������
			newth.setBookName(inBook_Name);
			newth.setBookNum(inBook_Num);
			newth.setFromName(inBook_From);
			newth.setFprice(bookfprice);
			// �����ݴ洢������
			session.save(newth);
		}
		// �ύ����
		t.commit();

		// �ر���Դ
		// session.close();
		// sessionFactory.close();

		//�����������
		Session session2=SessionUtil.getSession();
		Transaction tkucun = session2.beginTransaction();
		kucun k = new kucun();
		Query querykucun = session2.createQuery("from kucun");// �������
		List<kucun> listku = querykucun.list();// ����ѯ��Ľ����������
		int flag2=0;
		for (kucun kucun : listku) {
			if(kucun.getBookname().equalsIgnoreCase(inBook_Name)) {//�����������ʱ��
				flag2=1;
			}
		}
		
		if(flag2==1) {//���� ����
			for (kucun kucun : listku) {
				if(kucun.getBookname().equalsIgnoreCase(inBook_Name)) {//�����������ʱ��
					int newquanity=kucun.getQuanity()+inBook_Num;
					kucun.setQuanity(newquanity);
					kucun.setSoldprice(soldprice);
					session2.update(kucun);
				}
				
			}
		}
		else {//������ ���
			kucun newkucun=new kucun();
			newkucun.setBookname(inBook_Name);
			newkucun.setQuanity(inBook_Num);
			newkucun.setSoldprice(soldprice);
			session2.save(newkucun);
			
		}
		
		// �ύ����
		tkucun.commit();
		Session session3 = SessionUtil.getSession();
		Query query2 = session3.createQuery("from inBook");
		modelandview.addObject("list", query2.list());
		return modelandview;
	}

}
