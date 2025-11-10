package com.minierp.erp;

import javax.faces.bean.ManagedBean;
//@RequestScoped	Uma única requisição HTTP	N/A (específico da requisição)
//@ViewScoped	Interação na mesma página JSF	N/A (específico do usuário/página)
//@SessionScoped	Toda a sessão do usuário	Várias requisições do mesmo usuário
//@ApplicationScoped	Todo o ciclo da aplicação	Todos os usuários da aplicação

//Agora temos um controlador da pagina jsf, nomeado para chamar "pessoaBean"
@ManagedBean(name = "pessoaBean")
public class PessoaBean {

	// Precisamos receber dados da tela o nome e sobrenome 
	//Quando clicar no botao salvar vai vim esses atributos nome e sobrenome 
	private String nome;
	private String sobrenome;
	private String email;
	private String nomeCompleto;

	//Método
	public void mostrarNome(){
		nomeCompleto= nome + " " + sobrenome;
		return ;
		 
	}
	
	//Setters e Getters 
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
}
