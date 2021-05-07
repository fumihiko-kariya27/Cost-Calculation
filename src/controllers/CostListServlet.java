package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.SQLGrammarException;

import models.Cost;
import utils.DBConnect;

/**
 * Servlet implementation class CostListServlet
 */
@WebServlet("/cost/list")
public class CostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CostListServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManager em = DBConnect.createEntityManager();

		int page = 1;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
		}

		try {
			List<Cost> costs = em.createNamedQuery("getAllResult", Cost.class).setFirstResult(10 * (page - 1))
					.setMaxResults(10).getResultList();

			long cost_counts = em.createNamedQuery("getResultCounts", Long.class).getSingleResult();

			request.setAttribute("costs", costs);
			request.setAttribute("cost_counts", cost_counts);
			request.setAttribute("page", page);
		} catch (SQLGrammarException ex) {
			String message = "数値が何も入力されていません";
			request.setAttribute("message", message);
		} finally {
			em.close();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/cost/list.jsp");
		rd.forward(request, response);
	}

}
