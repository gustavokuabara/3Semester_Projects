// import java.util.Scanner;

import java.io.IOException;
import java.util.ArrayList;

import ClassesFuncionario.Funcionario;
import ClassesItem.Item;
import ClassesPedido.Pedido;

public class Main
{
	public static void main(String[] args) {
		ArrayList<String> ing = new ArrayList<>();
		ArrayList<String> emb = new ArrayList<>();
		ArrayList<String> pag = new ArrayList<>();
		ArrayList<Item> items = new ArrayList<>();

		Restaurante restaurante = new Restaurante();

		try {
			ing = Arquivo.lerRecursos("arquivos/recursos/ingredientes.txt");
			emb = Arquivo.lerRecursos("arquivos/recursos/tiposDeEmbalagem.txt");
			pag = Arquivo.lerRecursos("arquivos/recursos/formasDePagamento.txt");
			items = Arquivo.lerDirItens("arquivos/itens");

			restaurante.setIng(ing);
			restaurante.setEmb(emb);
			restaurante.setPag(pag);
			restaurante.setItens(items);

			ArrayList<Funcionario> func = Arquivo.lerDirFuncionarios(restaurante, "arquivos/funcionarios");
			restaurante.setFunc(func);

			ArrayList<Pedido> ped = Arquivo.lerDirPedidos(restaurante, "arquivos/pedidos");
			restaurante.setRegPed(ped);		
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (true) {
			int input;
			String[] itensMenu = new String[5]; //Itens do menu
			itensMenu[0] = new String("Pedidos");
			itensMenu[1] = new String("Cardapio");
			itensMenu[2] = new String("Funcionários");
			itensMenu[3] = new String("Recursos");
			itensMenu[4] = new String("Sair");

			input = Menu.menu(itensMenu, "Restaurante");

			if (input == 4) break;

			switch (input) { 
				case 0:
					Menu.menuPedidos(restaurante);
					break;
				case 1:
					Menu.menuCardapio(restaurante);
					break;
				case 2:
					Menu.menuFuncionarios(restaurante);
					break;
				case 3:
					Menu.menuRecursos(restaurante);
					break;
			}
		}	
		
		try {
			if (restaurante.getIngredientes().size() > 0) 
				Arquivo.cadastrarIgredientes(restaurante.getIngredientes());
			if (restaurante.getFormasDePagamento().size() > 0) 
				Arquivo.cadastrarFormasDePagameto(restaurante.getFormasDePagamento());
			if (restaurante.getTiposDeEmbalagem().size() > 0) 
				Arquivo.cadastrarTiposDeEmbalagem(restaurante.getTiposDeEmbalagem());
			

			for (int i = 0; i < restaurante.getFuncionarios().size(); i++) {
				Arquivo.cadastrarFuncionario(restaurante.getFuncionarios().get(i));
			}
			for (int i = 0; i < restaurante.getCardapio().size(); i++) {
				Arquivo.cadastrarItem(restaurante.getCardapio().get(i));
			}
			for (int i = 0; i < restaurante.getRegistroDePedidos().size(); i++) {
				Arquivo.cadastrarRegistroDePedido(restaurante.getRegistroDePedidos().get(i), Integer.toString(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void limparTermial() {
		System.out.print("\033[H\033[2J");
        System.out.flush();
	}
}
