package com.uberdist.produto;

import java.util.List;

public interface Produtos {

	void cadastra(Produto produto);

	List<Produto> todos();

	void remove(Produto produto);
	
}
