package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import util.SessionUtil;

public class moreController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		/*
		 * ��������
		 * �ȶ�ȡ��Ӧ�̹����� ����һ��checkbox
		 *ԭ������
		 *ԭ��������
		 * */
		ModelAndView modelandview=new ModelAndView("moreinput");
		Session session=SessionUtil.getSession();
		Query q=session.createQuery("from proBook");//��ȡ�����̱�
		modelandview.addObject("list",q.list());
		return modelandview;
	}

}
