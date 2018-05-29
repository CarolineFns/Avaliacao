package br.com.sinn.controller;

import java.util.List;

import br.com.sinn.dao.PessoaDAO;
import br.com.sinn.entidade.PessoaBean;

public class PessoaController {

	PessoaBean pessoaBean = new PessoaBean();
	PessoaDAO pessoaDao = new PessoaDAO();

	public List<PessoaBean> aumentaSalario(Long idcargo, Double aumento) {
		List<PessoaBean> listaPessoas = pessoaDao.listarPorCargo(idcargo);

		for (PessoaBean pessoa : listaPessoas) {
			calculaSalario(pessoa, aumento);
			pessoaDao.alterarSalario(pessoa);
		}

		return listaPessoas;
	}

	public void calculaSalario(PessoaBean pessoa, Double aumento) {
		Double salarioAntigo = pessoa.getSalario();
		pessoa.setSalarioAntigo(salarioAntigo);
		pessoa.setSalario(salarioAntigo + (salarioAntigo * (aumento / 100)));
	}

}
