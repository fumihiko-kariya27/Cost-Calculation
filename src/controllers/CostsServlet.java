package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Result;

/**
 * Servlet implementation class CostsServlet
 */
@WebServlet("/cost/index")
public class CostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CostsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.getParameter("input"));
		if (request.getParameter("input") == null) {
			// 最初のアクセスではトップ画面を表示
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/cost/form.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("input") != null) {
			// フォームから送信された値を取得し、変数に代入
			int budget = Integer.parseInt(request.getParameter("budget"));
			int hourly_wage = Integer.parseInt(request.getParameter("hourly_wage"));
			double time = Integer.parseInt(request.getParameter("time"));
			int number_of_people = Integer.parseInt(request.getParameter("number_of_people"));

			// 1日の合計の人件費、残りの予算、進捗を計算する
			Result r = new Result(budget, hourly_wage, time, number_of_people);
			int result = (int) Math.round(r.getResult());
			int remaining = budget - result;
			double parcent = Math.ceil((((double) result * 100) / budget) * 10) / 10;

			// スコープにセットし、JSPに処理を飛ばす
			request.getSession().setAttribute("r", r);
			request.getSession().setAttribute("result", result);
			request.getSession().setAttribute("remaining", remaining);
			request.getSession().setAttribute("parcent", parcent);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/cost/result.jsp");
			rd.forward(request, response);
		}

	}

}
