package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.monthxs;
import util.SessionUtil;

/**
 * Servlet implementation class cnt2
 */
@WebServlet("/cnt2")
public class cnt2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cnt2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//排序 按总销量
		Session session = SessionUtil.getSession();
		Query querymon = session.createQuery("from monthxs");// 读取月销售表
				List<monthxs> list1=querymon.list();
				List<Integer> numlist=new ArrayList<>();
				for (monthxs monthxs : list1) {
					numlist.add(monthxs.getMonthxs());
				}
				Collections.sort(numlist);
				System.out.println(numlist);
				
				list1.sort(new Comparator<monthxs>() {
					@Override
					public int compare(monthxs p1,monthxs p2) {
						/*
						 * 大于0 p1销量大于p2
						 * 小于0 p1销量小于p2
						 * */
						return p2.getMonthxs()-p1.getMonthxs();
					}
				});
				request.setAttribute("list1", list1);
	
				request.getRequestDispatcher("cntView33.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
