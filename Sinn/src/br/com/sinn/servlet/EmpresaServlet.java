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

import br.com.sinn.dao.EmpresaDAO;
import br.com.sinn.dao.PessoaDAO;
import br.com.sinn.entidade.EmpresaBean;
import br.com.sinn.entidade.PessoaBean;

@WebServlet("/EmpresaServlet")
public class EmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String destino = "empresaLista.jsp";
		List<EmpresaBean> lista = new ArrayList<>();

		EmpresaBean empresa = new EmpresaBean();
		EmpresaDAO dao = new EmpresaDAO();

		Long id = null;

		try {

			if (acao.equalsIgnoreCase("Listar")) {
				lista = dao.listar();
				request.setAttribute("listaEmpresa", lista);
				destino = "empresaLista.jsp";

			}

			if (acao.equalsIgnoreCase("Excluir")) {
				id = Long.parseLong(request.getParameter("id"));
				empresa = new EmpresaBean(id);
				dao.excluir(empresa);
			}

			if (acao.equalsIgnoreCase("IrParaTelaInsercao")) {
				destino = "empresa.jsp";

				PessoaDAO pessoaDao = new PessoaDAO();

				List<PessoaBean> listaPessoas = pessoaDao.listar();
				request.setAttribute("listaPessoa", listaPessoas);
			}

			if (acao.equalsIgnoreCase("IrParaTelaAlterar")) {
				destino = "empresaEdicao.jsp";
				id = Long.parseLong(request.getParameter("id"));

				PessoaDAO pessoaDao = new PessoaDAO();
				List<PessoaBean> listaPessoas = pessoaDao.listar();
				request.setAttribute("listaPessoa", listaPessoas);

				empresa = new EmpresaBean(id);

				empresa = dao.consultar(empresa);
				request.setAttribute("empresa", empresa);

				if (empresa.getDono() != null)
					request.setAttribute("selecionado", empresa.getDono().getId());
			}

			if (acao.equalsIgnoreCase("Alterar")) {
				id = Long.parseLong(request.getParameter("id"));
				String nome = request.getParameter("nome");
				String cnpj = request.getParameter("cnpj");

				empresa = new EmpresaBean(id);

				String aux = request.getParameter("dono");
				Long dono = null;
				if (!aux.isEmpty())
					dono = Long.parseLong(request.getParameter("dono"));

				empresa.setNome(nome);
				empresa.setCnpj(cnpj);

				if (dono != null) {
					PessoaBean pessoa = new PessoaBean(dono);
					empresa.setDono(pessoa);
				}

				dao.alterar(empresa);
			}

			if (acao.equalsIgnoreCase("Consultar")) {
				request.setAttribute("empresa", empresa);
				empresa = dao.consultar(empresa);
				destino = "empresa.jsp";
			}

			if (acao.equalsIgnoreCase("Incluir")) {
				String nome = request.getParameter("nome");
				String cnpj = request.getParameter("cnpj");

				String aux = request.getParameter("dono");
				Long dono = null;
				if (!aux.isEmpty())
					dono = Long.parseLong(request.getParameter("dono"));

				empresa.setNome(nome);
				empresa.setCnpj(cnpj);

				if (dono != null) {
					PessoaBean pessoa = new PessoaBean(dono);
					empresa.setDono(pessoa);
				}

				dao.inserir(empresa);
			}

			lista = dao.listar();
			request.setAttribute("listaEmpresa", lista);

			RequestDispatcher rd = request.getRequestDispatcher(destino);
			rd.forward(request, response);

		} catch (Exception e) {
			destino = "erro.jsp";
			e.printStackTrace();
		}

	}
}