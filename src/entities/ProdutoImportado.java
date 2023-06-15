package entities;

public final class ProdutoImportado extends Produto{
	
	private Double taxaAlfandegaria;

	public ProdutoImportado() {
		super();
	}

	public ProdutoImportado(String nome, Double preco, Double taxaAlfandegaria) {
		super(nome, preco);
		this.taxaAlfandegaria = taxaAlfandegaria;
	}

	public Double getTaxaAlfandegaria() {
		return taxaAlfandegaria;
	}

	public void setTaxaAlfandegaria(Double taxaAlfandegaria) {
		this.taxaAlfandegaria = taxaAlfandegaria;
	}
	
	public final Double precoTotal() {
		return preco + taxaAlfandegaria;
	}
	
	public String etiquetaDePreco() {
		return nome +" R$ " + String.format("%.2f", precoTotal()) + " (Taxa alfandegária: R$ " + taxaAlfandegaria + ")";
	}


}
