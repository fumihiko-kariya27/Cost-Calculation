package controllers;

import java.io.IOException;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cost;
import utils.DBConnect;

/**
 * Servlet implementation class CostSaveServlet
 */
@WebServlet("/cost/save")
public class CostSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CostSaveServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManager em = DBConnect.createEntityManager();
		//CostServletで計算した数値をmodels.Costに代入し、データベースに保存
		//現在日時を取得し、登録日時として保存
		int result = (int) request.getSession().getAttribute("result");
		int remaining = (int) request.getSession().getAttribute("remaining");
		double parcent = (double) request.getSession().getAttribute("parcent");

		Cost c = new Cost();
		c.setRemaining(remaining);
		c.setResult(result);
		c.setParcent(parcent);
		c.setDate(new Date(System.currentTimeMillis()));

		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();

		request.getSession().setAttribute("c", c);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/cost/show.jsp");
		rd.forward(request, response);
	}

}
