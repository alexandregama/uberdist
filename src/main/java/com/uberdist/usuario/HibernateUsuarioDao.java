package com.uberdist.usuario;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.uberdist.infra.JPAUtil;

public class HibernateUsuarioDao implements Usuarios {

	@Override
	public boolean existe(Usuario usuario) {
		String jpql = "select u from " + Usuario.class.getSimpleName() + " u where u.nome = :nome and u.senha = :senha";
		EntityManager manager = new JPAUtil().getEntityManager();
		
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		query.setParameter("nome", usuario.getNome());
		query.setParameter("senha", usuario.getSenha());
				
		try {
			return query.getSingleResult() != null;
		} catch (NoResultException e) {
			return false;
		}
	}

}
