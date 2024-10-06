import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Scanner;

import ClassesAuxiliares.Data;
import ClassesAuxiliares.Hora;
import ClassesFuncionario.Funcionario;
import ClassesFuncionario.Cozinheiro;
import ClassesFuncionario.Garcom;
import ClassesItem.Bebida;
import ClassesItem.Item;
import ClassesItem.PratoPrincipal;
import ClassesItem.Sobremesa;
import ClassesPedido.Pedido;
import ClassesPedido.PedidoItem;

public class Menu {
    public static int menu(String[] itens, String titulo) {
        Scanner scanner = new Scanner(System.in);
        int input;
        int tamanhoLado = (60 - titulo.length()) / 2;
        String linha = "=".repeat(tamanhoLado) + " " + titulo + " " + "=".repeat(tamanhoLado);

        while (true) {
            Main.limparTermial();
            System.out.format(linha);
            for (int i = 0; i < itens.length; i++) {
                System.out.format("\n %d - %s", i, itens[i]);
            }
            System.out.format("\n=============================================================");

            System.out.format("\nOpção: ");

            try {
                input = scanner.nextInt();
            } catch(Exception e) {
                input = -1;
            } 
            if (input >= 0 || input < itens.length) break;
        }
         
        return input;   
    }

    public static void menuPedidos(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);

        //numPedidos n pode ser aqui
        int numPedidos = 0;

        while (true) {
            String[] itensMenuPedidos = new String[3];
            itensMenuPedidos[0] = new String("Realizar Pedido");
            itensMenuPedidos[1] = new String("Ver Pedidos Realizados");
            itensMenuPedidos[2] = new String("Voltar");

            int input01 = menu(itensMenuPedidos, "Pedidos");

            if (input01 == 2) break; 

            switch (input01) {
                case 0:
                    realizarPedido(restaurante);
                    break;

                case 1:
                    System.out.println("\n===== Pedidos Realizados =====");
                    for (int i = 0; i < restaurante.getRegistroDePedidos().size(); i++) {
                        System.out.format("\nItens:");
                        for (int j = 0; j < restaurante.getRegistroDePedidos().get(i).getConjuntoItens().size(); j++) {
                            System.out.format("\n - Nome: %s", restaurante.getRegistroDePedidos().get(i).getConjuntoItens().get(j).getItem().getNome());
                            System.out.format("\n - Quantidade: %d", restaurante.getRegistroDePedidos().get(i).getConjuntoItens().get(j).getQtd());
                        }
                        System.out.format("\nData: %02d/%02d/%d", restaurante.getRegistroDePedidos().get(i).getData().getDia(), restaurante.getRegistroDePedidos().get(i).getData().getMes(), restaurante.getRegistroDePedidos().get(i).getData().getAno());
                        System.out.format("\nHora do registro: %02d:%02d:%02d", restaurante.getRegistroDePedidos().get(i).getHoraRegistro().getHoras(), restaurante.getRegistroDePedidos().get(i).getHoraRegistro().getMinutos(), restaurante.getRegistroDePedidos().get(i).getHoraRegistro().getSegundos());
                        System.out.format("\nHora do pagamento: %02d:%02d:%02d", restaurante.getRegistroDePedidos().get(i).getHoraPagamento().getHoras(), restaurante.getRegistroDePedidos().get(i).getHoraPagamento().getMinutos(), restaurante.getRegistroDePedidos().get(i).getHoraPagamento().getSegundos());
                        System.out.format("\nForma de pagamento: %s", restaurante.getRegistroDePedidos().get(i).getFormaDePagamento());
                        System.out.format("\nValor total: %.2f R$", restaurante.getRegistroDePedidos().get(i).getValorTotal());
                        System.out.format("\nCozinheiro: %s", restaurante.getRegistroDePedidos().get(i).getCozinheiro().getNome());
                        System.out.format("\nGarçom: %s", restaurante.getRegistroDePedidos().get(i).getGarcom().getNome());
                    }
                    scanner.nextLine();
                    break;
            }
        }
    }

    private static void realizarPedido(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<PedidoItem> itensDoPedido = new ArrayList<PedidoItem>();
        while (true) {
            Main.limparTermial();
            System.out.println("===== Cardápio =====");
            restaurante.mostrarCardapio();
            System.out.println("====================");
            scanner.nextLine();
            System.out.println("Digite o código do item a ser adicionado [-1 para continuar]: ");
            String cod = scanner.nextLine();

            if (cod.equals("-1")) break;

            System.out.println("Quantidade: ");
            int qtd = scanner.nextInt();

            itensDoPedido.add(new PedidoItem(restaurante.buscarItemPorCodigo(cod), qtd));
        }

        System.out.println("Data do pedido:");
        System.out.format(" - Dia: ");
        int dia = scanner.nextInt();
        System.out.format(" - Mes: ");
        int mes = scanner.nextInt();
        System.out.format(" - Ano: ");
        int ano = scanner.nextInt();
        
        Data data = new Data(dia, mes, ano);

        System.out.println("Hora do registro:");
        System.out.format(" - Hora: ");
        int h1 = scanner.nextInt();
        System.out.format(" - Minutos: ");
        int m1 = scanner.nextInt();
        System.out.format(" - Segundos: ");
        int s1 = scanner.nextInt();
        
        Hora horaRegistro = new Hora(h1, m1, s1);

        System.out.println("Hora do pagamento:");
        System.out.format(" - Hora: ");
        int h2 = scanner.nextInt();
        System.out.format(" - Minutos: ");
        int m2 = scanner.nextInt();
        System.out.format(" - Segundos: ");
        int s2 = scanner.nextInt();
        
        Hora horaPagamento = new Hora(h2, m2, s2);

        ArrayList<String> garcom = new ArrayList<>();
        for(int i = 0; i < restaurante.getFuncionarios().size() ; i++){
            if(restaurante.getFuncionarios().get(i) instanceof Garcom){
                garcom.add(restaurante.getFuncionarios().get(i).getNome());
            }
        }

        System.out.format("Informe o garçom responsável: ");

        for (int i = 0; i < garcom.size(); i++) {
            System.out.format("\n %d - %s", i, garcom.get(i));
        }
        System.out.println("\nOpção: ");

        int indexGar = scanner.nextInt();
        Funcionario gar = restaurante.buscarFuncionarioPorNome(garcom.get(indexGar));


        ArrayList<String> cozinheiros = new ArrayList<String>();
            for (int i = 0; i < restaurante.getFuncionarios().size(); i++) {
                if (restaurante.getFuncionarios().get(i) instanceof Cozinheiro ){
                    if (((Cozinheiro) restaurante.getFuncionarios().get(i)).verificarPrato(itensDoPedido.get(0).getItem().getCodigo())) {
                        cozinheiros.add(restaurante.getFuncionarios().get(i).getNome());
                    }
                }
            }

        System.out.format("Informe o cozinheiro responsável: ");

        for (int i = 0; i < cozinheiros.size(); i++) {
            System.out.format("\n %d - %s", i, cozinheiros.get(i));
        }
        System.out.println("\nOpção: ");

        int indexCoz = scanner.nextInt();
        Funcionario coz = restaurante.buscarFuncionarioPorNome(cozinheiros.get(indexCoz));

        System.out.println("Forma de pagamento");
        for (int i = 0; i < restaurante.getFormasDePagamento().size(); i++) {
            System.out.format("\n %d - %s ", i, restaurante.getFormasDePagamento().get(i));
        }
        System.out.println("\nOpção: ");
        String formaPag = restaurante.getFormasDePagamento().get(scanner.nextInt());

        
        Pedido p = new Pedido(itensDoPedido, data, horaRegistro, horaPagamento, formaPag, (Cozinheiro) coz, (Garcom) gar);
        restaurante.cadastrarPedido(p);

        
        System.out.println("Pedido realizado com sucesso!");
    }

    //A fazer
    public static void menuCardapio(Restaurante restaurante) {
        String[] itensMenuCardapio = new String[3]; //Itens do menu
        itensMenuCardapio[0] = new String("Ver Itens cadastrados");
        itensMenuCardapio[1] = new String("Cadastrar Item");
        itensMenuCardapio[2] = new String("Voltar");

        while (true) {
            Scanner scanner = new Scanner(System.in);

            int input01 = Menu.menu(itensMenuCardapio, "Cardápio");

            if (input01 == 2) break; //sair do loop

            switch (input01) {
                case 0:
                    System.out.println();
                    if (restaurante.getCardapio().size() == 0) {
                        System.out.println("Nenhum item cadastrado");
                    } else {
                        restaurante.mostrarCardapio();
                    }

                    scanner.nextLine();
                    break;

                case 1:
                    cadastrarItem(restaurante);
                    break;
            }
        }
    }

    private static void cadastrarItem(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);

        String[] itensMenuCadastroItem = new String[4]; //Itens do menu
        itensMenuCadastroItem[0] = new String("Cadastrar Prato Principal");
        itensMenuCadastroItem[1] = new String("Cadastrar Sobremesa");
        itensMenuCadastroItem[2] = new String("Cadastrar bebida");
        itensMenuCadastroItem[3] = new String("Voltar");


        while (true) {
            Main.limparTermial();

            int input01 = Menu.menu(itensMenuCadastroItem, "Cadastrar Item");

            if (input01 == 3) break;

            switch (input01) {
                case 0:
                    cadastrarPratoPrincial(restaurante);
                    break;
                case 1:
                    cadastrarSobremesa(restaurante);
                    break;
                case 2:
                    cadastrarBebida(restaurante);
                    break;
            }

            scanner.nextLine();
        }
    }

    private static void cadastrarPratoPrincial(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);

        if (restaurante.getIngredientes().size() == 0) {

            System.out.println("Nenhum ingrediente cadastrado!");
            scanner.nextLine();

        } else {

            System.out.format("Nome do prato: ");
            String nome = scanner.nextLine();

            String codigo;
            while (true) {
                System.out.format("Código do prato [AA000]: ");
                codigo = scanner.nextLine();
                if (Item.validarCodigo(codigo)) {
                    break;
                } else {
                    System.out.format("\nCódigo inválido!\n\n");
                }
            }
            
            System.out.format("Decrição do prato: ");
            String descricao = scanner.nextLine();
            System.out.format("Preço unitário: ");
            double precoUnitario = scanner.nextFloat();
            System.out.format("Preço de custo: ");
            double precoCusto = scanner.nextFloat();
            System.out.format("Tempo de preparo: ");
            double tempoDePreparo = scanner.nextDouble();
            System.out.format("Valor pago ao cozinheiro: ");
            double valorPagoCozinheiro = scanner.nextDouble();

            ArrayList<String> listaIngredientes = new ArrayList<String>();
            ArrayList<String> intensMenuIng = new ArrayList<String>(restaurante.getIngredientes());
            intensMenuIng.add("Continuar");

            while (true) {
                Main.limparTermial();
            
                System.out.format("================== Ingredientes Adicionados =================\n");
                for (int i = 0; i < listaIngredientes.size(); i++) {
                    System.out.println(" - " + listaIngredientes.get(i));
                }
                System.out.format("\n=================== Adicionar Ingredientes ==================");
                
                for (int i = 0; i < intensMenuIng.size(); i++) {
                    System.out.format("\n %d - %s", i, intensMenuIng.get(i));
                }
                System.out.format("\n=============================================================");
                System.out.println("\nOpção: ");

                int input02 = scanner.nextInt();

                if (input02 == intensMenuIng.size()-1) break;
                else {
                    listaIngredientes.add(intensMenuIng.get(input02));
                }
            }

            listaIngredientes = listaIngredientes.stream().distinct().collect(Collectors.toCollection(ArrayList::new));

            PratoPrincipal prato = new PratoPrincipal(nome, codigo, precoUnitario, precoCusto, listaIngredientes, descricao, tempoDePreparo, valorPagoCozinheiro);
            restaurante.cadastrarItem(prato);
            System.out.println("Prato cadastrado");
            scanner.nextLine();

        }
        
    }

    private static void cadastrarSobremesa(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);
        
        if (restaurante.getIngredientes().size() == 0) {

            System.out.println("Nenhum ingrediente cadastrado!");
            scanner.nextLine();

        } else {

            System.out.format("Nome do prato: ");
            String nome = scanner.nextLine();

            String codigo;
            while (true) {
                System.out.format("Código do prato [AA000]: ");
                codigo = scanner.nextLine();
                if (Item.validarCodigo(codigo)) {
                    break;
                } else {
                    System.out.format("\nCódigo inválido!\n\n");
                }
            }
            
            System.out.format("Decrição do prato: ");
            String descricao = scanner.nextLine();
            System.out.format("Número de calorias: ");
            double calorias = scanner.nextDouble();
            System.out.format("Preço unitário: ");
            double precoUnitario = scanner.nextDouble();
            System.out.format("Preço de custo: ");
            double precoCusto = scanner.nextDouble();
            System.out.format("Tempo de preparo: ");
            double tempoDePreparo = scanner.nextDouble();
            System.out.format("Valor pago ao cozinheiro: ");
            double valorPagoCozinheiro = scanner.nextDouble();

            ArrayList<String> listaIngredientes = new ArrayList<String>();
            ArrayList<String> intensMenuIng = new ArrayList<String>(restaurante.getIngredientes());
            intensMenuIng.add("Continuar");

            while (true) {
                Main.limparTermial();
            
                System.out.format("================== Ingredientes Adicionados =================\n");
                for (int i = 0; i < listaIngredientes.size(); i++) {
                    System.out.println(" - " + listaIngredientes.get(i));
                }
                System.out.format("\n=================== Adicionar Ingredientes ==================");
                
                for (int i = 0; i < intensMenuIng.size(); i++) {
                    System.out.format("\n %d - %s", i, intensMenuIng.get(i));
                }
                System.out.format("\n=============================================================");
                System.out.println("\nOpção: ");

                int input02 = scanner.nextInt();

                if (input02 == intensMenuIng.size()-1) break;
                else {
                    listaIngredientes.add(intensMenuIng.get(input02));
                }
            }

            listaIngredientes = listaIngredientes.stream().distinct().collect(Collectors.toCollection(ArrayList::new));

            Sobremesa prato = new Sobremesa(nome, codigo, precoUnitario, precoCusto, listaIngredientes, descricao, tempoDePreparo, valorPagoCozinheiro, calorias);
            restaurante.cadastrarItem(prato);
            System.out.println("Prato cadastrado");
            scanner.nextLine();

        }
    }

    private static void cadastrarBebida(Restaurante restaurante) {
    Scanner scanner = new Scanner(System.in);

    System.out.format("Nome da bebida: ");
    String nome = scanner.nextLine();

    String codigo;
    while (true) {
        System.out.format("Código da bebida [AA000]: ");
        codigo = scanner.nextLine();
        if (Item.validarCodigo(codigo)) {
            break;
        } else {
            System.out.format("\nCódigo inválido!\n\n");
        }
    }

    System.out.format("Tamanho da embalagem (ml): ");
    double tamanhoEmbalagem = scanner.nextDouble();
    scanner.nextLine();


    for (int i = 0; i < restaurante.getTiposDeEmbalagem().size(); i++) {
        System.out.format("\n %d - %s", i, restaurante.getTiposDeEmbalagem().get(i));
    }
    System.out.format("\nTipo de embalagem: ");
    int tipoEmbalagem = scanner.nextInt();

    System.out.format("Preço unitário: ");
    double precoUnitario = scanner.nextDouble();
    
    System.out.format("Preço de custo: ");
    double precoCusto = scanner.nextDouble();

    Bebida bebida = new Bebida(nome, codigo, precoUnitario, precoCusto, tamanhoEmbalagem, restaurante.getTiposDeEmbalagem().get(tipoEmbalagem));
    restaurante.cadastrarItem(bebida);

    System.out.println("Bebida cadastrada");
    scanner.nextLine();
}

    public static void menuFuncionarios(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);

        String[] itensMenuFuncionarios = new String[3]; //Itens do menu
        itensMenuFuncionarios[0] = new String("Ver Funcionários Cadastrados");
        itensMenuFuncionarios[1] = new String("Cadastrar Funcionário");
        itensMenuFuncionarios[2] = new String("Voltar");

        while (true) {
            int input01 = Menu.menu(itensMenuFuncionarios, "Funcionário");
            
            if (input01 == 2) break; //sair do loop

            switch (input01) {
                case 0:
                    System.out.println();
                    if (restaurante.getFuncionarios().size() == 0) {
                        System.out.println("Nenhum funcionário cadastrado");
                    } else {
                        restaurante.mostrarFuncionarios();
                    }

                    scanner.nextLine();

                    break;

                case 1:
                    menuCadastroFuncionarios(restaurante);

                    scanner.nextLine();

                    break;
            }
        }
    }

    private static void menuCadastroFuncionarios(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);

        String[] menuTipoFuncionario = new String[2];
        menuTipoFuncionario[0] = new String("Cozinheiro");
        menuTipoFuncionario[1] = new String("Garçom");

        int input01 = Menu.menu(menuTipoFuncionario, "Cadastrar Funcionário");

        System.out.format("=============================================================");
        System.out.format("\nNome: ");
        String nome = scanner.nextLine();

        String cpf;
        while (true) {
            System.out.format("CPF: ");
            cpf = scanner.nextLine();

            if (Funcionario.validarCPF(cpf)) {
                break;
            }
            else {
                System.out.format("\nCPF inválido!\n\n");
            }
        }
        
        System.out.format("RG: ");
        String rg = scanner.nextLine();
        System.out.format("Estado Civil: ");
        String ec = scanner.nextLine();
        System.out.format("Endereço: ");
        String end = scanner.nextLine();
        System.out.format("Carteira de Trabalho: ");
        String ct = scanner.nextLine();
        
        System.out.format("Data de Adimissão: ");
        System.out.format("\n - Dia: ");
        int dia = scanner.nextInt();
        System.out.format(" - Mes: ");
        int mes = scanner.nextInt();
        System.out.format(" - Ano: ");
        int ano = scanner.nextInt();

        if (input01 == 0) { //Cozinheiro
            ArrayList<Item> itensCadastrados = new ArrayList<Item>();

            while (true) {
                Main.limparTermial();
                
                System.out.format("=============== Pratos que o Cozinheiro Prepara =============\n");
                System.out.format("===================== Pratos Adicionados ====================\n");
                
                for (int i = 0; i < itensCadastrados.size(); i++) {
                    System.out.println(" - " + itensCadastrados.get(i).getNome());
                }

                System.out.format("\n======================= Adicionar Prato =====================");
                
                for (int i = 0; i < restaurante.getCardapio().size(); i++) {
                    System.out.format("\n %d - %s", i, restaurante.getCardapio().get(i).getNome());
                }
                System.out.format("\n %d - Continuar", restaurante.getCardapio().size());

                System.out.format("\n=============================================================");
                System.out.println("\nOpção: ");

                int input02 = scanner.nextInt();

                if (input02 == restaurante.getCardapio().size()) break;
                else {
                    itensCadastrados.add(restaurante.getCardapio().get(input02));
                }
            }

            Cozinheiro c = new Cozinheiro(nome, cpf, rg, ec, end, ct, new Data(dia,mes,ano));

            for (int i = 0; i < itensCadastrados.size(); i++) {
                c.addPratoCrozinheiro(itensCadastrados.get(i));
            } 

            restaurante.cadastrarFuncionario(c);
            
        } else if (input01 == 1) { //garçom
            System.out.format("Salário Base: ");
            double sb = scanner.nextFloat();

            String[] menuDiaFolga = new String[7];
            menuDiaFolga[0] = new String("Domingo");
            menuDiaFolga[1] = new String("Segunda");
            menuDiaFolga[2] = new String("terça");
            menuDiaFolga[3] = new String("Quarta");
            menuDiaFolga[4] = new String("Quinta");
            menuDiaFolga[5] = new String("Sexta");
            menuDiaFolga[6] = new String("Sábado");

            // MUDAR
            System.out.format("Dia de Folga: ");
            System.out.format("\n=============================================================");
            for (int i = 0; i < 7; i++) {
                System.out.format("\n %d - %s", i, menuDiaFolga[i]);
            }
            System.out.format("\n=============================================================");
            System.out.println("\nOpção: ");
            int inputDiaFolga = scanner.nextInt();

            restaurante.cadastrarFuncionario(new Garcom(nome, cpf, rg, ec, end, ct, new Data(dia,mes,ano), sb, menuDiaFolga[inputDiaFolga]));
        }
    }

    public static void menuRecursos(Restaurante restaurante) {
        String[] itensMenuRecursos = new String[4];
        itensMenuRecursos[0] = new String("Ingredientes");
        itensMenuRecursos[1] = new String("Embalagens");
        itensMenuRecursos[2] = new String("Formas de Pagamento");
        itensMenuRecursos[3] = new String("Voltar");

        while (true) {
            int input01 = Menu.menu(itensMenuRecursos, "Recursos");

            if (input01 == 3) break;

            switch (input01) {
                case 0:
                    menuIngredientes(restaurante);
                    break;
            
                case 1:
                    menuEmbalagens(restaurante);
                    break;
                
                case 2:
                    menuFormasDePagamento(restaurante);
                    break;
            }
        }
    }

    private static void menuIngredientes(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);

        String[] itensMenuIngredintes = new String[3]; //Itens do menu
        itensMenuIngredintes[0] = new String("Ver Ingredientes Cadastrados");
        itensMenuIngredintes[1] = new String("Cadastrar Ingrediente");
        itensMenuIngredintes[2] = new String("Voltar");

        while (true) {
            int input01 = Menu.menu(itensMenuIngredintes, "Ingredientes");
            
            if (input01 == 2) break; //sair do loop

            switch (input01) {
                case 0:
                    System.out.println();
                    if (restaurante.getIngredientes().size() == 0) {
                        System.out.println("Nenhum ingrediente cadastrado");
                    } else {
                        restaurante.mostrarIngredientes();
                    }
                    
                    scanner.nextLine();
                    break;

                case 1:
                    System.out.format("\nDigite o nome do ingrediente a ser cadastrado: ");
                    String nomeIngrediente = scanner.nextLine();
                    restaurante.cadastrarIngrediente(nomeIngrediente);
                    System.out.println("Ingrediente cadastrado");
                    scanner.nextLine();
                    break;
            }
        }
    }

    private static void menuEmbalagens(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);

        String[] itensMenuEmbalagens = new String[3]; //Itens do menu
        itensMenuEmbalagens[0] = new String("Ver Embalagens Cadastradas");
        itensMenuEmbalagens[1] = new String("Cadastrar Embalagem");
        itensMenuEmbalagens[2] = new String("Voltar");

        while (true) {
            int input01 = Menu.menu(itensMenuEmbalagens, "Embalagens");
            
            if (input01 == 2) break; //Sair do loop

            switch (input01) {
                case 0:
                    System.out.println();
                    if (restaurante.getTiposDeEmbalagem().size() == 0) {
                        System.out.println("Nenhuma embalagem cadastrada");
                    } else {
                        restaurante.mostrarEmbalagens();
                    }
                    
                    scanner.nextLine();
                    break;

                case 1:
                    System.out.format("\nDigite o nome da embalagem a ser cadastrada: ");
                    String nomeEmbalagem = scanner.nextLine();
                    restaurante.cadastrarEmbalagem(nomeEmbalagem);
                    System.out.println("Embalagem cadastrada");
                    scanner.nextLine();
                    break;
            }
        }
    }

    private static void menuFormasDePagamento(Restaurante restaurante) {
        Scanner scanner = new Scanner(System.in);

        String[] itensMenuPagmento = new String[3]; //Itens do menu
        itensMenuPagmento[0] = new String("Ver Formas de Pagamento Cadastradas");
        itensMenuPagmento[1] = new String("Cadastrar Forma de Pagamento");
        itensMenuPagmento[2] = new String("Voltar");

        while (true) {
            int input01 = Menu.menu(itensMenuPagmento, "Pagamento");
            
            if (input01 == 2) break; //Sair do loop

            switch (input01) {
                case 0:
                    System.out.println();
                    if (restaurante.getFormasDePagamento().size() == 0) {
                        System.out.println("Nenhuma forma de pagamento cadastrada");
                    } else {
                        restaurante.mostrarFormasDePagamento();
                    }
                    
                    scanner.nextLine();
                    break;

                case 1:
                    System.out.format("\nDigite o nome da Forma de Pagamento a ser cadastrada: ");
                    String nomeForma = scanner.nextLine();
                    restaurante.cadastrarFormaDePagamento(nomeForma);
                    System.out.println("Forama de pagamento cadastrada");
                    scanner.nextLine();
                    break;
            }
        }
    }
}
