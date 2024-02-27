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
		//判断管理员输入的用户名 密码是否正确
		int flag=0;//不存在管理员
		List<admi> list=q.list();
		for (admi admi : list) {
			if((admi.getName().equals(user))&&(admi.getPwd().equals(pwd))) {
				flag=1;//存在且密码正确
			}
			else if((admi.getName().equals(user))&&(!admi.getPwd().equals(pwd))) {
				flag=2;//密码错误
			}
		}
		if(flag==0) {
			request.setAttribute("mess", "不存在该管理员!请先注册!");
			request.getRequestDispatcher("登录.jsp").forward(request, response);
			return null;
		}
		else if(flag==2) {
			request.setAttribute("mess", "密码错误!");
			request.getRequestDispatcher("登录.jsp").forward(request, response);
			return null;
		}
		
		//remember me
		if(rem!=null&&"rem".equals(rem)){//选择remember me
			if(user!=null&&user!=""&&pwd!=null&&pwd!=null){//用户名和密码不为空 且正确
				//设置Cookie 设置生命周期
				Cookie cookie1=new Cookie("username",user);
				Cookie cookie2=new Cookie("userpassword",pwd);
				//ck.setMaxAge(3600*24*3);//三天生命周期
				cookie1.setMaxAge(3600*24*3);//三天生命周期
				cookie2.setMaxAge(3600*24*3);//三天生命周期
				//将Cookie写入浏览器
				//response.addCookie(ck);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
				request.setAttribute("mess", "登录成功!");
				request.getRequestDispatcher("图书销售管理.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("mess", "登录成功!");
			request.getRequestDispatcher("图书销售管理.jsp").forward(request, response);
		}
		
		return null;
	}

}
