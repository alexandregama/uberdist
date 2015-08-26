package com.uberdist.produto;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProdutoBean {

	private Produto produto = new Produto();

	private ProdutoDao produtos = new ProdutoDao();
	
	public void salva() {
		produtos.cadastra(produto);
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
