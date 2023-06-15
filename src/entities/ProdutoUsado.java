package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class ProdutoUsado extends Produto{
	
	private LocalDate dataDeFabricacao;

	public ProdutoUsado() {
		super();
	}

	public ProdutoUsado(String nome, Double preco, LocalDate dataDeFabricacao) {
		super(nome, preco);
		this.dataDeFabricacao = dataDeFabricacao;
	}

	public LocalDate getDataDeFabricacao() {
		return dataDeFabricacao;
	}

	public void setDataDeFabricacao(LocalDate dataDeFabricacao) {
		this.dataDeFabricacao = dataDeFabricacao;
	}
	
	public String etiquetaDePreco() {
		return nome 
					+ " (usado) R$ " 
					+ String.format("%.2f", preco) 
					+  " (Data de fabricação: " 
					+ dataDeFabricacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")";
	}


}
