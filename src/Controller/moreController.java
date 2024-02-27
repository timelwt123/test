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
		 * 批量进货
		 * 先读取供应商供货表 加上一列checkbox
		 *原本存在
		 *原本不存在
		 * */
		ModelAndView modelandview=new ModelAndView("moreinput");
		Session session=SessionUtil.getSession();
		Query q=session.createQuery("from proBook");//读取供货商表
		modelandview.addObject("list",q.list());
		return modelandview;
	}

}
