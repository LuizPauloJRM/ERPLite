package com.minierp.erp;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;

import org.primefaces.component.commandbutton.CommandButton;
//@RequestScoped	Uma única requisição HTTP	N/A (específico da requisição)
//@ViewScoped	Interação na mesma página JSF	N/A (específico do usuário/página)
//@SessionScoped	Toda a sessão do usuário	Várias requisições do mesmo usuário
//@ApplicationScoped	Todo o ciclo da aplicação	Todos os usuários da aplicação

//Agora temos um controlador da pagina jsf, nomeado para chamar "pessoaBean"
@ManagedBean(name = "pessoaBean")
@ViewScoped
public class PessoaBean {

	// Precisamos receber dados da tela o nome e sobrenome 
	//Quando clicar no botao salvar vai vim esses atributos nome e sobrenome 
	private String nome;
	private HtmlCommandButton commandButton;
	private String sobrenome;
	private String email;
	private String nomeCompleto;
	//Adicionar o nome em uma lista, quando clicar adicionar nomes 
	//Pegar minha lista e adicionar o nome que vem da tela 
	private List<String> nomes = new ArrayList<String>();

	//Métodos	
	//Maior de 3 nomes desabilita
	public void adicionarNome(){
		nomes.add(nome);
		if (nomes.size() >3) {
			CommandButton commandButton = new CommandButton();
			commandButton.setDisabled(true);
			return;
			
		}
		return ;		 
	}
	
	//Setters e Getters)
	public void setCommandButton(HtmlCommandButton commandButton) {
		this.commandButton = commandButton;
	}
	public HtmlCommandButton getCommandButton() {
		return commandButton;
	}
	
	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}
	public List<String> getNomes() {
		return nomes;
	}
	
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
