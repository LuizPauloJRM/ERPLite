package com.minierp.erp;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.minierp.erp.dao.PessoaDao;
import com.minierp.erp.model.Pessoa;

/**
 * PessoaBean - Backing bean JSF que faz a ponte entre a view (XHTML) e a camada
 * de persistência (PessoaDao).
 *
 * @ViewScoped - mantém o bean durante a interação na mesma página.
 */
@ManagedBean(name = "pessoaBean")
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// Modelo que será ligado ao formulário (nome, email, etc).
	private Pessoa pessoa = new Pessoa();

	// DAO para persistência
	private PessoaDao pessoaDao = new PessoaDao();

	// Lista usada pela dataTable para exibir registros do banco
	private List<Pessoa> listaPessoas;

	/**
	 * Método chamado pelo botão "Salvar". Persiste a pessoa no banco e recarrega a
	 * lista.
	 */
	public void salvar() {
		try {
			// Salva no banco (inserção)
			pessoaDao.salvar(pessoa);

			// Mensagem de feedback para o usuário
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Pessoa cadastrada com sucesso."));

			// Limpa o formulário (novo objeto)
			pessoa = new Pessoa();

			// Atualiza a lista para refletir o novo registro
			listaPessoas = pessoaDao.listarTodas();
		} catch (Exception e) {
			// Em caso de erro mostramos mensagem de erro
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Falha ao salvar: " + e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * Retorna a lista de pessoas - carrega do banco apenas na primeira chamada.
	 */
	public List<Pessoa> getListaPessoas() {
		if (listaPessoas == null) {
			listaPessoas = pessoaDao.listarTodas();
		}
		return listaPessoas;
	}

	public void novaPessoa() {
		this.pessoa = new Pessoa();
	}

	// Método para remover um registro (pode ser ligado a um botão na tabela)
	public void remover(Pessoa p) {
		try {
			pessoaDao.remover(p.getId());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Removido", "Pessoa removida com sucesso."));
			listaPessoas = pessoaDao.listarTodas(); // recarrega lista
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível remover."));
			e.printStackTrace();
		}
	}

	// GETTERS E SETTERS

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}
}
