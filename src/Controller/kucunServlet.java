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
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.kucun;
import util.SessionUtil;

/**
 * Servlet implementation class kucunServlet
 */
@WebServlet("/kucunServlet")
public class kucunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kucunServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// ����hibernate.cfg.xml����
				Configuration config = new Configuration().configure();
				// ��ȡsessionFactory ��ȡ����ӳ���ļ���Ϣ������Ϣ���Ƶ�sessionFactory��
				SessionFactory sessionFactory = config.buildSessionFactory();
				// �õ�һ��session�� ��sessionFactory�ṩ����
				Session session = sessionFactory.openSession();
				// ��������
				Transaction t = session.beginTransaction();
				Query q=session.createQuery("from kucun");
				List<kucun> list=q.list();
				for (kucun kucun : list) {
					if(kucun.getQuanity()==0) {//ɾ�����Ϊ0���鼮
						session.delete(kucun);
					}
				}
				t.commit();
				Session session2=SessionUtil.getSession();
				Query q2=session2.createQuery("from kucun");
				request.setAttribute("list", q2.list());
				request.getRequestDispatcher("/view/kucunView.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
