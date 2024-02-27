package Controller;

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
import util.SessionUtil;

public class inBookCont2 extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//读取供货表
		ModelAndView modelandview =new ModelAndView("proBook");
		Session session=SessionUtil.getSession();
		Query query=session.createQuery("from proBook");
		modelandview.addObject("list",query.list());
		return modelandview;
	}

}
