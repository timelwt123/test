package Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.dayxs;
import util.SessionUtil;

/**
 * Servlet implementation class rxsServlet
 */
@WebServlet("/rxsServlet")
public class rxsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rxsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Date nowdate = new Date();// 获取当前系统时间	
		Session session=SessionUtil.getSession();
		Query q=session.createQuery("from dayxs");
		List<dayxs> list=q.list();
		List<dayxs> list2=new ArrayList<>();
		System.out.println(nowdate);
		for (dayxs dayxs : list) {
			if(dayxs.getXsday().getDay()==nowdate.getDay()&&dayxs.getXsday().getMonth()==nowdate.getMonth()) {
				list2.add(dayxs);
			}
		}
		request.setAttribute("list", list2);
		request.getRequestDispatcher("/view/dayView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
