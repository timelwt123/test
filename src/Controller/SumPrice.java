package Controller;

import java.io.IOException;
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
 * Servlet implementation class SumPrice
 */
@WebServlet("/SumPrice")
public class SumPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SumPrice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Session session=SessionUtil.getSession();
		Query q=session.createQuery("from monthxs");//读取销售表
		
		//计算总销售金额 （所有书籍加起来）
		double sumprice=0.0;
		List<monthxs> list=q.list();
		for (monthxs monthxs : list) {
			sumprice=sumprice+monthxs.getMonsumprice();
		}
		request.setAttribute("sumprice", sumprice);
		
		//计算总销售金额 （所有书籍加起来）
				int sumcnt=0;
				List<monthxs> list2=q.list();
				for (monthxs monthxs : list2) {
					sumcnt+=monthxs.getMonthxs();
				}
				request.setAttribute("sumcnt", sumcnt);
		request.getRequestDispatcher("sumprice2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
