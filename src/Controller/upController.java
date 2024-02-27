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
		String[] upPrice2 = request.getParameterValues("upPrice2");//�����������
		System.out.println(upPrice);
		System.out.println(upPrice2);

		ArrayList<upBean> up = new ArrayList<>();
		if (upPrice2 == null) {// �ύ����ϢΪ��
			//request.setAttribute("mess", "�ύ����ϢΪ��!");
			//request.getRequestDispatcher("inBook2.jsp").forward(request, response);
			return null;
		}
		//�������ݲ�Ϊ����
		for (int i = 0; i < upPrice2.length; i++) {
			if(upPrice2[i]!=null&&upPrice2[i]!="") {
				if(!(upPrice2[i].charAt(0)<='9'&&upPrice2[i].charAt(0)>='0')) {
					request.setAttribute("mess", "����������!");
					request.getRequestDispatcher("inBook2.jsp").forward(request, response);
					return null;
				}
			}
		}
		// �ύ����Ϣ��Ϊ��
		// �������� ��������
		Configuration config = new Configuration().configure();
		// ��ȡsessionFactory ��ȡ����ӳ���ļ���Ϣ������Ϣ���Ƶ�sessionFactory��
		SessionFactory sessionFactory = config.buildSessionFactory();
		// �õ�һ��session�� ��sessionFactory�ṩ����
		Session session = sessionFactory.openSession();
		// ��������
		Transaction t = session.beginTransaction();
		
		//String upstr=Arrays.toString(upPrice);
		System.out.println("upPrice.length:"+upPrice.length);
		System.out.println("upPrice2.length:"+upPrice2.length);
		for (int i = 0; i < upPrice.length; i++) {
			if(upPrice2[i]!=null&&upPrice2[i]!="") {//�����˱���
				//����upBean
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
