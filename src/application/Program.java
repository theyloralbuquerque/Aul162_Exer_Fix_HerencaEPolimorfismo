package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// Formatação da data.
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		List<Produto> list = new ArrayList<>();
		
		System.out.print("Digite a quantidade de produtos: ");
		Integer n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println();
			System.out.print("Produto comum, usado ou importado [c/u/i]? ");
			char estado = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Preço: R$ ");
			Double preco = sc.nextDouble();
			
			// ifs e elses de instanciação dos objetos na Lista.
			if (estado == 'c') {
				list.add(new Produto(nome, preco));
			}
			else if (estado == 'u') {
				System.out.print("Digite a data de fabricação(dd/mm/yyyy): ");
				/*
				 * O Localdate dataDeFabricacao receberá uma String digitada pelo 
				 * usuário que vai ser na instância fmt da classe DateTimeFormatter,
				 * ou seja, a String que o usuário figitar no formato fmt que será 
				 * recebida pelo Localdate dataDeFabricacao. 
				 */
				LocalDate dataDeFabricacao = LocalDate.parse(sc.next(), fmt);
				list.add(new ProdutoUsado(nome, preco, dataDeFabricacao));
			}
			else if (estado == 'i') {
				System.out.print("Digite o valor da taxa alfandegária: R$ ");
				Double taxaAlfandegaria = sc.nextDouble();
				list.add(new ProdutoImportado(nome, preco, taxaAlfandegaria));
			}
			
		}
		
		System.out.println();
		System.out.println("ETIQUETAS DE PREÇO:");
		for (Produto prod : list) { // Execute a classe Produto aplidada de prod em Lista.
			System.out.println(prod.etiquetaDePreco());
			
		}
		
	}

}
