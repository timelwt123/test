package Controller;

import java.io.IOException;
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
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.dayxs;
import entity.kucun;
import util.SessionUtil;

/**
 * Servlet implementation class baobiaoServlet
 */
@WebServlet("/baobiaoServlet")
public class baobiaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public baobiaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//进货表
		Session sessionjh=SessionUtil.getSession();
		Query qjh=sessionjh.createQuery("from inBook");
		request.setAttribute("listjh", qjh.list());
		request.getRequestDispatcher("/view/baobiao.jsp").forward(request, response);
		
		//库存
		// 加载hibernate.cfg.xml配置
		Configuration config = new Configuration().configure();
		// 获取sessionFactory 读取解析映射文件信息，将信息复制到sessionFactory中
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 得到一个session， 让sessionFactory提供连接
		Session sessionkucun = sessionFactory.openSession();
		// 开启事务
		Transaction t = sessionkucun.beginTransaction();
		Query qkucun=sessionkucun.createQuery("from kucun");
		List<kucun> list=qkucun.list();
		for (kucun kucun : list) {
			if(kucun.getQuanity()==0) {//删除库存为0的书籍
				sessionkucun.delete(kucun);
			}
		}
		t.commit();
		Session session2=SessionUtil.getSession();
		Query q2=session2.createQuery("from kucun");
		request.setAttribute("listkc", q2.list());
		request.getRequestDispatcher("/view/baobiao.jsp").forward(request, response);
		
		//退货表
		Session sessionth=SessionUtil.getSession();
		Query qth=sessionth.createQuery("from th");
		request.setAttribute("listth", qth.list());
		request.getRequestDispatcher("/view/baobiao.jsp").forward(request, response);
		
		//日销售表
		Date nowdate = new Date();// 获取当前系统时间	
		Session sessionrxs=SessionUtil.getSession();
		Query qrxs=sessionrxs.createQuery("from dayxs");
		List<dayxs> listrxs=qrxs.list();
		List<dayxs> list2=new ArrayList<>();
		for (dayxs dayxs : listrxs) {
			if(dayxs.getXsday().getDay()==nowdate.getDay()) {
				list2.add(dayxs);
			}
		}
		request.setAttribute("listrxs", list2);
		request.getRequestDispatcher("/view/baobiao.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
