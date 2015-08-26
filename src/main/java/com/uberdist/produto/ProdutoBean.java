package com.uberdist.produto;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProdutoBean {

	private Produto produto = new Produto();

	private Produtos produtos = new HibernateProdutoDao();
	
	public String salva() {
		produtos.cadastra(produto);
		
		return "produto?faces-redirect=true";
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
