package controllers;

import java.io.IOException;

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

		int result = (int) request.getSession().getAttribute("result");
		int remaining = (int) request.getSession().getAttribute("remaining");
		double parcent = (double) request.getSession().getAttribute("parcent");

		Cost r = new Cost();
		r.setRemaining(remaining);
		r.setResult(result);
		r.setParcent(parcent);


		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();

		request.setAttribute("r", r);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/cost/show.jsp");
		rd.forward(request, response);
	}

}
