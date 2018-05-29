package br.com.sinn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.sinn.entidade.EmpresaBean;
import br.com.sinn.entidade.PessoaBean;

public class EmpresaDAO extends DAO {

	public void alterar(EmpresaBean empresa) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm;

			StringBuffer toReturn = new StringBuffer();
			toReturn.append("update empresa set nome=?, cnpj=?");

			pstm = conexao.prepareStatement(toReturn.toString());

			if (empresa.getDono() != null && empresa.getDono().getId() != null) {
				toReturn.append(", iddono=? where id=?");
				pstm = conexao.prepareStatement(toReturn.toString());
				pstm.setString(1, empresa.getNome());
				pstm.setString(2, empresa.getCnpj());
				pstm.setLong(3, empresa.getDono().getId());
				pstm.setLong(4, empresa.getId());
			} else {
				toReturn.append(" where id=?");
				pstm = conexao.prepareStatement(toReturn.toString());
				pstm.setString(1, empresa.getNome());
				pstm.setString(2, empresa.getCnpj());
				pstm.setLong(3, empresa.getId());
			}

			pstm.execute();
			pstm.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(EmpresaBean empresa) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("delete from empresa where id = ? ");
			pstm.setLong(1, empresa.getId());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean existe(EmpresaBean empresa) {
		boolean achou = false;
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("select * from empresa where id =	?");
			pstm.setLong(1, empresa.getId());
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
				achou = true;
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return achou;
	}

	public void inserir(EmpresaBean empresa) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm;

			StringBuffer toReturn = new StringBuffer();
			int numeroParamatros = 0;
			toReturn.append("Insert into empresa (");
			if (!empresa.getNome().equals(null)) {
				toReturn.append("nome");
				numeroParamatros++;
			}
			if (!empresa.getCnpj().equals(null)) {
				toReturn.append(",cnpj");
				numeroParamatros++;
			}
			if (empresa.getDono() != null && empresa.getDono().getId() != null) {
				toReturn.append(",iddono");
				numeroParamatros++;
			}
			toReturn.append(")values(");
			for (int i = 0; i < numeroParamatros; i++) {
				if (i < (numeroParamatros - 1))
					toReturn.append("?,");
				else
					toReturn.append("?");
			}
			toReturn.append(")");

			pstm = conexao.prepareStatement(toReturn.toString());

			pstm.setString(1, empresa.getNome());
			pstm.setString(2, empresa.getCnpj());
			if (empresa.getDono() != null && empresa.getDono().getId() != null)
				pstm.setLong(3, empresa.getDono().getId());

			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	public List<EmpresaBean> listar() {
		List<EmpresaBean> lista = new ArrayList<>();
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("select * from empresa");
			while (rs.next()) {
				EmpresaBean empresa = new EmpresaBean();
				empresa.setId(rs.getLong("id"));
				empresa.setNome(rs.getString("nome"));
				empresa.setCnpj(rs.getString("cnpj"));

				PessoaBean pessoa = new PessoaBean(rs.getLong("iddono"));
				PessoaDAO pessoaDao = new PessoaDAO();

				empresa.setDono(pessoaDao.consultar(pessoa));

				lista.add(empresa);
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public EmpresaBean consultar(EmpresaBean empresa) {
		try {
			PessoaBean pessoa = new PessoaBean();
			PessoaDAO pessoaDAO = new PessoaDAO();

			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("select * from empresa where id = ?");
			pstm.setLong(1, empresa.getId());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				empresa.setId(rs.getLong("id"));
				empresa.setNome(rs.getString("nome"));
				empresa.setCnpj(rs.getString("cnpj"));

				pessoa = new PessoaBean(rs.getLong("iddono"));
				pessoa = pessoaDAO.consultar(pessoa);
				empresa.setDono(pessoa);

			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empresa;
	}
}