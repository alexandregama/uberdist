package com.uberdist.produto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.uberdist.infra.JPAUtil;

class HibernateProdutoDao implements Produtos {

	public void cadastra(Produto produto) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		manager.persist(produto);
		manager.getTransaction().commit();
		
		manager.close();
	}

	@Override
	public List<Produto> todos() {
		EntityManager manager = new JPAUtil().getEntityManager();
		String jpql = "select p from " + Produto.class.getSimpleName() + " p";
		TypedQuery<Produto> query = manager.createQuery(jpql, Produto.class);
		
		List<Produto> produtos = query.getResultList();
		manager.close();
		
		return produtos;
	}

	@Override
	public void remove(Produto produto) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Produto produtoParaRemover = manager.find(Produto.class, produto.getId());
		manager.getTransaction().begin(); 
		manager.remove(produtoParaRemover);
		manager.getTransaction().commit(); 
		
		manager.close();
	}

	@Override
	public void altera(Produto produto) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(produto);
		manager.getTransaction().commit();
		
		manager.close();
	}

}
