package com.uberdist.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.google.common.base.MoreObjects;
import com.uberdist.notafiscal.NotaFiscal;
import com.uberdist.produto.Produto;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;
	
	@Column(name = "quantidade", length = 5, nullable = false)
	private int quantidade;
	
	@ManyToOne
	@JoinColumn(name = "nota_fiscal_id", nullable = false)
	private NotaFiscal notaFiscal;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("produto", produto)
				.add("quantidade", quantidade)
				.add("notaFiscalId", (notaFiscal == null? "": notaFiscal.getId()))
				.toString();
	}

	public Long getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
