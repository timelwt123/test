package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import util.SessionUtil;

public class jhdController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelandview=new ModelAndView("inBookView");
		Session session=SessionUtil.getSession();
		Query q=session.createQuery("from inBook");//读取进货表
		modelandview.addObject("list",q.list());
		return modelandview;
	}

}
