package br.com.sinn.entidade;

import java.io.Serializable;

public class PessoaBean implements Serializable {

	private static final long serialVersionUID = -5813158407829020753L;

	private Long id;
	private CargoBean cargo = new CargoBean();
	private String nome;
	private String cpf;
	private Double salario;
	private Double salarioAntigo;
	private int aumento;

	public PessoaBean() {
	}

	public PessoaBean(Long id) {
		this.id = id;
	}

	public PessoaBean(Long id, CargoBean cargo, String nome, String cpf, Double salario) {
		this.id = id;
		this.cargo = cargo;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CargoBean getCargo() {
		return cargo;
	}

	public void setCargo(CargoBean cargo) {
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public int compareTo(Long arg0) {
		return cargo.compareTo(arg0);
	}

	public boolean equals(Object arg0) {
		return cargo.equals(arg0);
	}

	public int hashCode() {
		return cargo.hashCode();
	}

	public int getAumento() {
		return aumento;
	}

	public void setAumento(int aumento) {
		this.aumento = aumento;
	}

	public Double getSalarioAntigo() {
		return salarioAntigo;
	}

	public void setSalarioAntigo(Double salarioAntigo) {
		this.salarioAntigo = salarioAntigo;
	}

}
