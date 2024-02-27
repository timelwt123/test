package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import entity.admi;

public class signController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		// ����hibernate.cfg.xml����
		Configuration config = new Configuration().configure();
		// ��ȡsessionFactory ��ȡ����ӳ���ļ���Ϣ������Ϣ���Ƶ�sessionFactory��
		SessionFactory sessionFactory = config.buildSessionFactory();
		// �õ�һ��session�� ��sessionFactory�ṩ����
		Session session = sessionFactory.openSession();
		// ��������
		Transaction t = session.beginTransaction();
		admi newadmi = new admi();// �½�����Ա
		newadmi.setName(name);
		newadmi.setPwd(pwd);
		session.save(newadmi);
		t.commit();
		request.setAttribute("mess", "ע��ɹ�!���¼!");
		request.getRequestDispatcher("��¼.jsp").forward(request, response);
		return null;
	}

}
