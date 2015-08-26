package com.uberdist.produto;

import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProdutoBean {

	private Produto produto = new Produto();

	private Produtos produtos = new HibernateProdutoDao();
	
	private List<Produto> lista;
	
	public String salva() {
		produtos.cadastra(produto);
		
		return "produto?faces-redirect=true";
	}
	
	public String remove(Produto produto) {
		produtos.remove(produto);
		
		return "produto?faces-redirect=true";
	}
	
	public List<Produto> getLista() {
		if (lista == null) {
			lista = produtos.todos();
		}
		return lista;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
