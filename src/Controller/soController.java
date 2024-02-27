package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import util.SessionUtil;

public class soController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelandview =new ModelAndView("soldBook");
		
		Session session=SessionUtil.getSession();
		session.flush();
		Query query=session.createQuery("from kucun");
		modelandview.addObject("list",query.list());
		return modelandview;
	}

}
