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
		TypedQuery<Produto> produtos = manager.createQuery(jpql, Produto.class);
		
		return produtos.getResultList();
	}

}
