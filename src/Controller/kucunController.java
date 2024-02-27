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
		// 加载hibernate.cfg.xml配置
		Configuration config = new Configuration().configure();
		// 获取sessionFactory 读取解析映射文件信息，将信息复制到sessionFactory中
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 得到一个session， 让sessionFactory提供连接
		Session session = sessionFactory.openSession();
		// 开启事务
		Transaction t = session.beginTransaction();
		Query q=session.createQuery("from kucun");
		List<kucun> list=q.list();
		for (kucun kucun : list) {
			if(kucun.getQuanity()==0) {//删除库存为0的书籍
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
