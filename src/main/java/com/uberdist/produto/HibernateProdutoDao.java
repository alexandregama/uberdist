package com.uberdist.produto;

import javax.persistence.EntityManager;

import com.uberdist.infra.JPAUtil;

class HibernateProdutoDao implements Produtos {

	public void cadastra(Produto produto) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		manager.persist(produto);
		manager.getTransaction().commit();
		
		manager.close();
	}

}
