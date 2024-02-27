package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.servlet.ModelAndView;

import entity.dayxs;
import entity.monthxs;
import util.SessionUtil;

/**
 * Servlet implementation class cnt
 */
@WebServlet("/cnt")
public class cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cnt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//ModelAndView modelandview = new ModelAndView("countView");
		Session session = SessionUtil.getSession();
		Query querymon = session.createQuery("from monthxs");// ��ȡ�����۱�
	    

		/*
		 * ���������۱� ��ͬ�鼮��ͬ�·ݵ���� ���ݴ���monthxs�������۱��� monthxsԭ������ ���� monthxsԭ�������� ���
		 */
		
		//���� ��������
		List<monthxs> list1=querymon.list();
		list1.sort(new Comparator<monthxs>() {
			@Override
			public int compare(monthxs p1,monthxs p2) {
				/*
				 * ����0 p1��������p2
				 * С��0 p1����С��p2
				 * */
				return Integer.compare(p1.getMonthxs(),p2.getMonthxs());
				
				
			}
		});
		//request.setAttribute("list1", list1);
		
		//���� �������ܽ��
		Query querymon2 = session.createQuery("from monthxs");// ��ȡ�����۱�
		List<monthxs> list2=querymon2.list();
		list2.sort(new Comparator<monthxs>() {
			@Override
			public int compare(monthxs p1,monthxs p2) {
				/*
				 * ����0 p1��������p2
				 * С��0 p1����С��p2
				 * */
				return Double.compare(p2.getMonsumprice(), p1.getMonsumprice());
				
				
			}
		});
		request.setAttribute("list2", list2);
		request.getRequestDispatcher("cntView22.jsp").forward(request, response);
		
		//return modelandview;
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
