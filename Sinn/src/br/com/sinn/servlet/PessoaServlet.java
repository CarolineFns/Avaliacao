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

import br.com.sinn.controller.PessoaController;
import br.com.sinn.dao.CargoDAO;
import br.com.sinn.dao.PessoaDAO;
import br.com.sinn.entidade.CargoBean;
import br.com.sinn.entidade.PessoaBean;

/**
 * Servlet implementation class PessoaServlet
 */
@WebServlet("/PessoaServlet")
public class PessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String destino = "pessoaLista.jsp";
		List<PessoaBean> lista = new ArrayList<>();

		PessoaBean pessoa = new PessoaBean();
		PessoaDAO dao = new PessoaDAO();
		PessoaController controller = new PessoaController();

		Long id = null;

		try {

			if (acao.equalsIgnoreCase("AlterarSalario")) {
				Long idCargo = Long.parseLong(request.getParameter("cargo"));
				Double aumento = Double.parseDouble(request.getParameter("aumento"));

				CargoDAO cargoDao = new CargoDAO();
				List<CargoBean> listaCargos = cargoDao.listar();
				request.setAttribute("listaCargo", listaCargos);
				
				List<PessoaBean> listaPessoas = controller.aumentaSalario(idCargo, aumento);

				request.setAttribute("listaPessoas", listaPessoas);

				destino = "pessoaAlterarSalario.jsp";
			}

			if (acao.equalsIgnoreCase("IrParaTelaAlterarSalario")) {
				lista = dao.listar();
				request.setAttribute("listaPessoa", lista);

				CargoDAO cargoDao = new CargoDAO();
				List<CargoBean> listaCargos = cargoDao.listar();
				request.setAttribute("listaCargo", listaCargos);

				destino = "pessoaAlterarSalario.jsp";

			}

			if (acao.equalsIgnoreCase("Listar")) {
				lista = dao.listar();
				request.setAttribute("listaPessoa", lista);
				destino = "pessoaLista.jsp";

			}

			if (acao.equalsIgnoreCase("Excluir")) {
				id = Long.parseLong(request.getParameter("id"));
				pessoa = new PessoaBean(id);
				dao.excluir(pessoa);
			}

			if (acao.equalsIgnoreCase("IrParaTelaAlterar")) {
				destino = "pessoaEdicao.jsp";
				id = Long.parseLong(request.getParameter("id"));

				CargoDAO cargoDao = new CargoDAO();
				List<CargoBean> listaCargos = cargoDao.listar();
				request.setAttribute("listaCargo", listaCargos);

				pessoa = new PessoaBean(id);

				pessoa = dao.consultar(pessoa);
				request.setAttribute("pessoa", pessoa);

				if (pessoa.getCargo() != null)
					request.setAttribute("selecionado", pessoa.getCargo().getId());
			}

			if (acao.equalsIgnoreCase("Alterar")) {
				id = Long.parseLong(request.getParameter("id"));
				String nome = request.getParameter("nome");
				String cpf = request.getParameter("cpf");
				Double salario = Double.parseDouble(request.getParameter("salario"));

				pessoa = new PessoaBean(id);

				String aux = request.getParameter("cargo");
				Long cargo = null;
				if (!aux.isEmpty())
					cargo = Long.parseLong(request.getParameter("cargo"));

				pessoa.setNome(nome);
				pessoa.setCpf(cpf);
				pessoa.setSalario(salario);

				if (cargo != null) {
					CargoBean cargoNovo = new CargoBean(cargo);
					pessoa.setCargo(cargoNovo);
				}

				dao.alterar(pessoa);
			}

			if (acao.equalsIgnoreCase("Consultar")) {
				request.setAttribute("pessoa", pessoa);
				pessoa = dao.consultar(pessoa);
				destino = "pessoa.jsp";
			}

			if (acao.equalsIgnoreCase("IrParaTelaInsercao")) {
				destino = "pessoa.jsp";

				CargoDAO cargoDao = new CargoDAO();

				List<CargoBean> listaCargos = cargoDao.listar();
				request.setAttribute("listaCargo", listaCargos);
			}

			if (acao.equalsIgnoreCase("Incluir")) {

				String nome = request.getParameter("nome");
				String cpf = request.getParameter("cpf");
				Double salario = Double.parseDouble(request.getParameter("salario"));
				Long cargo = Long.parseLong(request.getParameter("cargo"));

				CargoBean cargoInsercao = new CargoBean(cargo);

				pessoa.setNome(nome);
				pessoa.setCpf(cpf);
				pessoa.setSalario(salario);
				pessoa.setCargo(cargoInsercao);

				dao.inserir(pessoa);
			}

			lista = dao.listar();
			request.setAttribute("listaPessoa", lista);

			RequestDispatcher rd = request.getRequestDispatcher(destino);
			rd.forward(request, response);

		} catch (Exception e) {
			destino = "erro.jsp";
			e.printStackTrace();
		}

	}

}
