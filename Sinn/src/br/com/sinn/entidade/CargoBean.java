package br.com.sinn.entidade;

import java.io.Serializable;

public class CargoBean implements Serializable {

	private static final long serialVersionUID = 4888434330564636403L;

	private Long id;
	private String nome;

	public CargoBean() {
	}

	public CargoBean(Long id) {
		this.id = id;
		setNome(nome);
	}

	public CargoBean(Long id, String nome) {
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int compareTo(Long arg0) {
		return id.compareTo(arg0);
	}

	public boolean equals(Object arg0) {
		return id.equals(arg0);
	}

	public int hashCode() {
		return id.hashCode();
	}

	public String toString() {
		return id.toString();
	}

}
