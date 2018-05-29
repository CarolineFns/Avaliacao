package br.com.sinn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sinn.dao.CargoDAO;
import br.com.sinn.entidade.CargoBean;

/**
 * Servlet implementation class CargoServlet
 */
@WebServlet("/CargoServlet")
public class CargoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String destino = "cargoLista.jsp";
		List<CargoBean> lista = new ArrayList<>();

		CargoBean cargo = new CargoBean();
		CargoDAO dao = new CargoDAO();

		Long id = null;

		try {

			if (acao.equalsIgnoreCase("Listar")) {
				lista = dao.listar();
				request.setAttribute("listaCargo", lista);
				destino = "cargoLista.jsp";

			}

			if (acao.equalsIgnoreCase("Excluir")) {
				id = Long.parseLong(request.getParameter("id"));
				cargo = new CargoBean(id);
				dao.excluir(cargo);
			}

			if (acao.equalsIgnoreCase("Alterar")) {
				id = Long.parseLong(request.getParameter("id"));
				String nome = request.getParameter("nome");
				
				cargo = new CargoBean(id);
				cargo.setNome(nome);
				dao.alterar(cargo);
			}

			if (acao.equalsIgnoreCase("Consultar")) {
				request.setAttribute("cargo", cargo);
				cargo = dao.consultar(cargo);
				destino = "cargo.jsp";
			}

			if (acao.equalsIgnoreCase("Incluir")) {
				String nome = request.getParameter("nome");
				cargo.setNome(nome);
				dao.inserir(cargo);
			}
			
			if (acao.equalsIgnoreCase("IrParaTelaAlterar")) {
				destino = "cargoEdicao.jsp";
				id = Long.parseLong(request.getParameter("id"));
				
				cargo = new CargoBean(id);

				cargo = dao.consultar(cargo);
				request.setAttribute("cargo", cargo);
			}

			lista = dao.listar();
			request.setAttribute("listaCargo", lista);

			RequestDispatcher rd = request.getRequestDispatcher(destino);
			rd.forward(request, response);

		} catch (Exception e) {
			destino = "erro.jsp";
			e.printStackTrace();
		}

	}

}
