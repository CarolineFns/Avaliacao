package br.com.sinn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.sinn.entidade.CargoBean;

public class CargoDAO extends DAO {

	public void alterar(CargoBean cargo) {
		try {
			Connection conexao = getConexao();

			PreparedStatement pstmt = conexao.prepareStatement("update cargo SET nome = ?" + " where id = ? ");
			pstmt.setString(1, cargo.getNome());
			pstmt.setLong(2, cargo.getId());
			pstmt.execute();
			pstmt.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(CargoBean cargo) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("delete from cargo where id = ? ");
			pstm.setLong(1, cargo.getId());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (SQLException e) {
			Throwable cause = e;
			e.printStackTrace();
			System.out.println(cause);
		} 
	}

	public boolean existe(CargoBean cargo) {
		boolean achou = false;
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("select * from cargo where id =	?");
			pstm.setLong(1, cargo.getId());
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

	public void inserir(CargoBean cargo) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Insert into	cargo (nome) values	(?)");
			pstm.setString(1, cargo.getNome());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	public List<CargoBean> listar() {
		List<CargoBean> lista = new ArrayList<>();
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("select * from cargo");
			while (rs.next()) {
				CargoBean cargo = new CargoBean();
				cargo.setId(rs.getLong("id"));
				cargo.setNome(rs.getString("nome"));
				lista.add(cargo);
			}
			
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public CargoBean consultar(CargoBean cargo) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("select * from cargo where id = ?");
			pstm.setLong(1, cargo.getId());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				cargo.setId(rs.getLong("id"));
				cargo.setNome(rs.getString("nome"));
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cargo;
	}
}