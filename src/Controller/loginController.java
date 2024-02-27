package Controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import entity.admi;
import util.SessionUtil;

public class loginController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		String rem=request.getParameter("rem");
		Session session=SessionUtil.getSession();
		Query q=session.createQuery("from admi");
		//�жϹ���Ա������û��� �����Ƿ���ȷ
		int flag=0;//�����ڹ���Ա
		List<admi> list=q.list();
		for (admi admi : list) {
			if((admi.getName().equals(user))&&(admi.getPwd().equals(pwd))) {
				flag=1;//������������ȷ
			}
			else if((admi.getName().equals(user))&&(!admi.getPwd().equals(pwd))) {
				flag=2;//�������
			}
		}
		if(flag==0) {
			request.setAttribute("mess", "�����ڸù���Ա!����ע��!");
			request.getRequestDispatcher("��¼.jsp").forward(request, response);
			return null;
		}
		else if(flag==2) {
			request.setAttribute("mess", "�������!");
			request.getRequestDispatcher("��¼.jsp").forward(request, response);
			return null;
		}
		
		//remember me
		if(rem!=null&&"rem".equals(rem)){//ѡ��remember me
			if(user!=null&&user!=""&&pwd!=null&&pwd!=null){//�û��������벻Ϊ�� ����ȷ
				//����Cookie ������������
				Cookie cookie1=new Cookie("username",user);
				Cookie cookie2=new Cookie("userpassword",pwd);
				//ck.setMaxAge(3600*24*3);//������������
				cookie1.setMaxAge(3600*24*3);//������������
				cookie2.setMaxAge(3600*24*3);//������������
				//��Cookieд�������
				//response.addCookie(ck);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
				request.setAttribute("mess", "��¼�ɹ�!");
				request.getRequestDispatcher("ͼ�����۹���.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("mess", "��¼�ɹ�!");
			request.getRequestDispatcher("ͼ�����۹���.jsp").forward(request, response);
		}
		
		return null;
	}

}
