package br.com.sinn.entidade;

import java.io.Serializable;

public class EmpresaBean implements Serializable {

	private static final long serialVersionUID = -309513637403441918L;

	private Long id;
	private PessoaBean dono = new PessoaBean();
	private String cnpj;
	private String nome;

	public EmpresaBean() {
		setNome(getNome());
		setCnpj(getCnpj());
		setDono(getDono());
	}

	public EmpresaBean(Long id) {
		this.id = id;
		setNome(getNome());
		setCnpj(getCnpj());
		setDono(getDono());
	}

	public EmpresaBean(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PessoaBean getDono() {
		return dono;
	}

	public void setDono(PessoaBean dono) {
		this.dono = dono;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpresaBean other = (EmpresaBean) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (dono == null) {
			if (other.dono != null)
				return false;
		} else if (!dono.equals(other.dono))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmpresaBean [id=" + id + ", dono=" + dono + ", cnpj=" + cnpj + ", nome=" + nome + "]";
	}

}