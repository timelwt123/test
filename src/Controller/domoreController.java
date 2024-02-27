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
		ModelAndView modelandview=new ModelAndView("domoreView");//������ͬ ��Ϊ����
		String[] checkop=request.getParameterValues("inornot");
		String num[]=request.getParameterValues("num");
		String checkop2=Arrays.toString(checkop);
		String num2=Arrays.toString(num);
		System.out.println(checkop);
		System.out.println(num);
		if(checkop==null) {
			request.setAttribute("mess", "��ѡ����Ϊ��!");
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
			request.setAttribute("mess", "��ѡ���ı����ݱ���/��дǰ���ȹ�ѡ!");
			request.getRequestDispatcher("inBook2.jsp").forward(request, response);
			return null;
		}
		else if(mn==checkop.length) {
			for (int i = 0; i < checkop.length; i++) {
				if(checkop[i]==null&&checkop[i]=="") {
					if(num[i]!="") {
						request.setAttribute("mess", "��ѡ���ı����ݱ���/��дǰ���ȹ�ѡ!");
						request.getRequestDispatcher("inBook2.jsp").forward(request, response);
						return null;
					}
				}
			}
		}
		//���벻Ϊ����
		for (int i = 0; i < num.length; i++) {
			if(num[i]!="") {
				if(!(num[i].charAt(0)<='9'&&num[i].charAt(0)>='0')) {
					request.setAttribute("mess", "����������!");
					request.getRequestDispatcher("inBook2.jsp").forward(request, response);
					return null;
				}
			}
		}
		

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		Date nowdate = new Date();// ��ȡ��ǰϵͳʱ��
		String df2 = df.format(nowdate);
		modelandview.addObject("dateInfo", df2);
		modelandview.addObject("checkop",checkop2);//������+����+��Ӧ�̴���checkop����
		modelandview.addObject("num",num2);//�����Ӧ�Ľ�����������num����
		
		//����
		
		/*
		 * ͬ�����鼮������ʽ
		 * �������� ����
		 * ������û�� ���
		 * */
		//�������� ��������
		Configuration config = new Configuration().configure();
		// ��ȡsessionFactory ��ȡ����ӳ���ļ���Ϣ������Ϣ���Ƶ�sessionFactory��
		SessionFactory sessionFactory = config.buildSessionFactory();
		// �õ�һ��session�� ��sessionFactory�ṩ����
		Session session = sessionFactory.openSession();
		// ��������
		Transaction t = session.beginTransaction();
		
		//��������
		//����ȡ��checkop������morebook����ʽ
		List<String> bookname=new ArrayList<>();//������
		ArrayList<Double> sp=new ArrayList<>();//�����鼮����
		ArrayList<String> fromname=new ArrayList<>();//�湩Ӧ��
		ArrayList<Integer> innum=new ArrayList<>();//���������
		ArrayList<morebook> morebookl=new ArrayList<>();
		
		
		//��ȡ����Աcheck���Լ�Num
		for (int i = 0; i < checkop.length; i++) {
			String[] cp=checkop[i].split("\\+");
			System.out.println("checkop:"+checkop[i]);
			System.out.println("cp:"+cp.length);
			bookname.add(cp[0]);//������
			sp.add(Double.parseDouble(cp[1]));//�汨��
			fromname.add(cp[2]);//�湩Ӧ��
		}
		
		for (int i = 0; i < num.length; i++) {
			if(num[i]!=null&&num[i]!="")
			innum.add(Integer.parseInt(num[i]));
		}
		
		double sumprice=0.0;//�����鼮һ�����������ѵĽ��
		
		
		//����  ��ӵ�inbook����������
		Query inq=session.createQuery("from inBook");
		List<inBook> inql=inq.list();
		
		for (int i = 0; i < bookname.size(); i++) {
			int flaginbook=0;
			for (int j = 0; j < inql.size(); j++) {//���� ����
				if ((inql.get(j).getBookName().equalsIgnoreCase(bookname.get(i)))&&inql.get(j).getFromName().equals(fromname.get(i))) {// ���������Ѿ�����
					flaginbook = 1;
					int newbooknum=innum.get(i)+inql.get(j).getBookNum();
					inql.get(j).setBookNum(newbooknum);
					session.update(inql.get(j));
				}
			}
			
			if(flaginbook==0) {//������ ���
				inBook newinbook=new inBook();
				newinbook.setBookName(bookname.get(i));
				newinbook.setBookNum(innum.get(i));
				newinbook.setFromName(fromname.get(i));
				newinbook.setFprice(sp.get(i));
				session.save(newinbook);
			}
			sumprice=sumprice+(sp.get(i)*innum.get(i));//����������ѵ��ܽ��
			morebook newmorebook=new morebook(bookname.get(i), fromname.get(i), sumprice, nowdate, innum.get(i));
			morebookl.add(newmorebook);

		}
		t.commit();
		Session newsession=SessionUtil.getSession();
		
		
		/*
		 * ��������鼮����һ���ɿ�������û�е�ʱ�� ��ӻ���ִ��� ��������Σ���� ���۲�ͬ�����У�
		 * ��Ҫ�Դ����������д��� ����moreKucun����(ֻ������ �������ǿ��)
		 * ������ͬ���鼮��������һ���ǰ���һ���
		 * ǰ����ͬ��ʱ�� �ϲ� û����ͬ��ֱ�Ӵ�
		 * */
		Set<String> hSet = new HashSet<String>();//Set���� �治�ظ�Ԫ��
		ArrayList<moreKucun> morekucun=new ArrayList<>();
		int[] tn=new int[100];
		for (int i = 0; i < bookname.size(); i++) {
			if(!hSet.contains(bookname.get(i))) {
				
				//������ ����
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
		//������ �����������
		/*
		 * ����morekucun���� ���ڸ��� ���������
		 * */
		Session session2=SessionUtil.getSession();
		Transaction tkucun = session2.beginTransaction();
		kucun k = new kucun();
		Query querykucun = session2.createQuery("from kucun");// �������
		List<kucun> listku = querykucun.list();// ����ѯ��Ľ����������
		
		for (int i = 0; i < morekucun.size(); i++) {
			int flag2=0;
				for (int j = 0; j < listku.size(); j++) {
					if(morekucun.get(i).getBookname().equalsIgnoreCase(listku.get(j).getBookname())) {
						//�������ڵ�ʱ�� ����
						int newquanity=listku.get(j).getQuanity()+morekucun.get(i).getQuanity();
						listku.get(j).setQuanity(newquanity);
						session2.update(listku.get(j));
						flag2=1;
						modelandview.addObject("mess1","����1");
					}
				}
				if(flag2==0) {
					//������ ���
					kucun newkucun=new kucun();
					newkucun.setBookname(morekucun.get(i).getBookname());
					newkucun.setQuanity(morekucun.get(i).getQuanity());
					newkucun.setSoldprice(morekucun.get(i).getPrice());
					session2.save(newkucun);
				}
				modelandview.addObject("mess2","���1");
		}
		// �ύ����
		tkucun.commit();
		/*for (int i = 0; i < innum.size(); i++) {
			int flag2=0;
			for (int j = 0; j < listku.size(); j++) {
				if(bookname.get(i).equalsIgnoreCase(listku.get(j).getBookname())) {
					//�����������ʱ�� ����
					int newquanity=listku.get(j).getQuanity()+innum.get(i);
					listku.get(j).setQuanity(newquanity);
					//listku.get(i).setSoldprice(sp.get(i));
					session2.update(listku.get(j));
					flag2=1;
					modelandview.addObject("mess1","����1");
				}
			}
			if(flag2==0) {
			//������ ���
			kucun newkucun=new kucun();
			newkucun.setBookname(bookname.get(i));
			newkucun.setQuanity(innum.get(i));
			newkucun.setSoldprice(sp.get(i));
			modelandview.addObject("mess2","���1");
			session2.save(newkucun);
			}
		}*/
		
		return modelandview;
	}

}
