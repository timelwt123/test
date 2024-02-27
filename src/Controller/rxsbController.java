package Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import entity.dayxs;
import util.SessionUtil;

public class rxsbController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView modelandview=new ModelAndView("dayView");
		Session session=SessionUtil.getSession();
		Query q=session.createQuery("from dayxs");
		List<dayxs> list1=q.list();
		List<dayxs> list2=new ArrayList<>();
		Date nowdate=new Date();
		for (dayxs dayxs : list1) {
			if(dayxs.getXsday().getDay()==nowdate.getDay()){
				list2.add(dayxs);
			}
		}
		modelandview.addObject("list",list2);
		return modelandview;
	}

}
