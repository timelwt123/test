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
		
		// 加载hibernate.cfg.xml配置
		Configuration config = new Configuration().configure();
		// 获取sessionFactory 读取解析映射文件信息，将信息复制到sessionFactory中
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 得到一个session， 让sessionFactory提供连接
		Session session = sessionFactory.openSession();
		// 开启事务
		Transaction t = session.beginTransaction();
		admi newadmi = new admi();// 新建管理员
		newadmi.setName(name);
		newadmi.setPwd(pwd);
		session.save(newadmi);
		t.commit();
		request.setAttribute("mess", "注册成功!请登录!");
		request.getRequestDispatcher("登录.jsp").forward(request, response);
		return null;
	}

}
