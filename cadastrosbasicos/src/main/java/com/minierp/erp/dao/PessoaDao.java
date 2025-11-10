package com.minierp.erp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.minierp.erp.model.Pessoa;

/**
 * PessoaDao - camada de acesso a dados responsável por persistir
 * e consultar a entidade Pessoa usando JPA (Hibernate).
 *
 * Observação: usamos EntityManagerFactory estático para reaproveitar
 * a fábrica durante a vida da aplicação.
 */
public class PessoaDao {

    // Nome da persistence-unit definido no persistence.xml
    private static final String PERSISTENCE_UNIT = "cadastrosbasicos";

    // Fábrica de EntityManager (leva algum tempo para inicializar)
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

    /**
     * Persiste uma nova Pessoa no banco.
     * Se a pessoa já tiver id, poderia ser usado merge() para atualizar.
     */
    public void salvar(Pessoa pessoa) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin(); // inicia transação
            em.persist(pessoa);          // persiste a entidade
            em.getTransaction().commit(); // confirma transação
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // desfaz em caso de erro
            }
            throw e; // propaga para o caller tratar / logar
        } finally {
            em.close(); // sempre fechar o EntityManager
        }
    }

    /**
     * Lista todas as pessoas existentes no banco.
     */
    public List<Pessoa> listarTodas() {
        EntityManager em = emf.createEntityManager();
        try {
            // JPQL "from Pessoa" retorna todas as instâncias da entidade Pessoa
            return em.createQuery("from Pessoa", Pessoa.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Remove uma Pessoa pelo ID.
     */
    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Pessoa p = em.find(Pessoa.class, id);
            if (p != null) {
                em.remove(p);
            }
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Atualiza (merge) uma pessoa existente.
     */
    public Pessoa atualizar(Pessoa pessoa) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Pessoa merged = em.merge(pessoa);
            em.getTransaction().commit();
            return merged;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
