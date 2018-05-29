package br.com.sinn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.sinn.entidade.CargoBean;
import br.com.sinn.entidade.PessoaBean;

public class PessoaDAO extends DAO {

	public void alterarSalario(PessoaBean pessoa) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm;

			StringBuffer toReturn = new StringBuffer();
			toReturn.append("update pessoa set salario = ? where id = ?");

			pstm = conexao.prepareStatement(toReturn.toString());
			pstm.setDouble(1, pessoa.getSalario());
			pstm.setLong(2, pessoa.getId());

			pstm.execute();
			pstm.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<PessoaBean> listarPorCargo(Long idcargo) {
		List<PessoaBean> lista = new ArrayList<>();
		try {
			Connection conexao = getConexao();
			PreparedStatement stm = conexao.prepareStatement("select * from pessoa where idcargo = ?");
			stm.setLong(1, idcargo);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				PessoaBean pessoa = new PessoaBean();
				pessoa.setId(rs.getLong("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setSalario(rs.getDouble("salario"));

				CargoBean cargo = new CargoBean(rs.getLong("idcargo"));
				CargoDAO cargoDao = new CargoDAO();

				pessoa.setCargo(cargoDao.consultar(cargo));
				lista.add(pessoa);
			}

			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void alterar(PessoaBean pessoa) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm;

			StringBuffer toReturn = new StringBuffer();
			toReturn.append("update pessoa set nome=?, cpf=?, salario=? ");

			pstm = conexao.prepareStatement(toReturn.toString());

			if (pessoa.getCargo() != null && pessoa.getCargo().getId() != null) {
				toReturn.append(", idcargo=? where id=?");
				pstm = conexao.prepareStatement(toReturn.toString());
				pstm.setString(1, pessoa.getNome());
				pstm.setString(2, pessoa.getCpf());
				pstm.setDouble(3, pessoa.getSalario());
				pstm.setLong(4, pessoa.getCargo().getId());
				pstm.setLong(5, pessoa.getId());
			} else {
				toReturn.append(" where id=?");
				pstm = conexao.prepareStatement(toReturn.toString());
				pstm.setString(1, pessoa.getNome());
				pstm.setString(2, pessoa.getCpf());
				pstm.setDouble(3, pessoa.getSalario());
				pstm.setLong(4, pessoa.getId());
			}

			pstm.execute();
			pstm.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(PessoaBean pessoa) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("delete from pessoa where id = ? ");
			pstm.setLong(1, pessoa.getId());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean existe(PessoaBean pessoa) {
		boolean achou = false;
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("select * from pessoa where id =	?");
			pstm.setLong(1, pessoa.getId());
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

	public void inserir(PessoaBean pessoa) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm;

			StringBuffer toReturn = new StringBuffer();
			int numeroParamatros = 0;
			toReturn.append("Insert into pessoa (");
			if (!pessoa.getNome().equals(null)) {
				toReturn.append("nome");
				numeroParamatros++;
			}
			if (!pessoa.getCpf().equals(null)) {
				toReturn.append(",cpf");
				numeroParamatros++;
			}
			if (pessoa.getCargo() != null && pessoa.getCargo().getId() != null) {
				toReturn.append(",idcargo");
				numeroParamatros++;
			}
			if (pessoa.getSalario() > 0) {
				toReturn.append(",salario");
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

			pstm.setString(1, pessoa.getNome());
			pstm.setString(2, pessoa.getCpf());
			if (pessoa.getCargo() != null && pessoa.getCargo().getId() != null)
				pstm.setLong(3, pessoa.getCargo().getId());
			pstm.setDouble(4, pessoa.getSalario());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	public List<PessoaBean> listar() {
		List<PessoaBean> lista = new ArrayList<>();
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("select * from pessoa");
			while (rs.next()) {
				PessoaBean pessoa = new PessoaBean();
				pessoa.setId(rs.getLong("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setSalario(rs.getDouble("salario"));

				CargoBean cargo = new CargoBean(rs.getLong("idcargo"));
				CargoDAO cargoDao = new CargoDAO();

				pessoa.setCargo(cargoDao.consultar(cargo));
				lista.add(pessoa);
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public PessoaBean consultar(PessoaBean pessoa) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("select * from pessoa where id = ?");
			pstm.setLong(1, pessoa.getId());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				pessoa.setId(rs.getLong("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				if (pessoa.getCargo() != null)
					pessoa.getCargo().setId(rs.getLong("idcargo"));
				pessoa.setSalario(rs.getDouble("salario"));
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pessoa;
	}
}