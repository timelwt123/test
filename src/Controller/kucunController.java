package Controller;

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
import util.SessionUtil;

public class kucunController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView modelandview=new ModelAndView("kucunView");
		// ����hibernate.cfg.xml����
		Configuration config = new Configuration().configure();
		// ��ȡsessionFactory ��ȡ����ӳ���ļ���Ϣ������Ϣ���Ƶ�sessionFactory��
		SessionFactory sessionFactory = config.buildSessionFactory();
		// �õ�һ��session�� ��sessionFactory�ṩ����
		Session session = sessionFactory.openSession();
		// ��������
		Transaction t = session.beginTransaction();
		Query q=session.createQuery("from kucun");
		List<kucun> list=q.list();
		for (kucun kucun : list) {
			if(kucun.getQuanity()==0) {//ɾ�����Ϊ0���鼮
				session.delete(kucun);
			}
		}
		t.commit();
		Session session2=SessionUtil.getSession();
		Query q2=session2.createQuery("from kucun");
		modelandview.addObject("ml",q2.list());
		return modelandview;
	}

}
