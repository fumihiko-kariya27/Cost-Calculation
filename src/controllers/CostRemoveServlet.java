package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CostRemoveServlet
 *
 */
@WebServlet("/cost/remove")
public class CostRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CostRemoveServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("r") != null) {
			request.getSession().removeAttribute("r");
		}
		if (request.getSession().getAttribute("c") != null) {
			request.getSession().removeAttribute("c");
		}
		if (request.getSession().getAttribute("result") != null) {
			request.getSession().removeAttribute("result");
		}
		if (request.getSession().getAttribute("remaining") != null) {
			request.getSession().removeAttribute("remaining");
		}
		if (request.getSession().getAttribute("parcent") != null) {
			request.getSession().removeAttribute("parcent");
		}

		response.sendRedirect(request.getContextPath()+"/cost/index");
	}

}
