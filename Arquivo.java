import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import ClassesAuxiliares.Data;
import ClassesAuxiliares.Hora;
import ClassesFuncionario.Cozinheiro;
import ClassesFuncionario.Funcionario;
import ClassesFuncionario.Garcom;
import ClassesItem.Bebida;
import ClassesItem.Item;
import ClassesItem.Prato;
import ClassesItem.PratoPrincipal;
import ClassesItem.Sobremesa;
import ClassesPedido.Pedido;
import ClassesPedido.PedidoItem;


public class Arquivo {

    public static void cadastrarItem(Item item) throws IOException {
        if (item instanceof PratoPrincipal) {

            FileWriter fw = new FileWriter("arquivos/itens/" + item.getNome() + ".txt");

            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("PratoPrincipal");
            bw.newLine();

            bw.write(item.getNome());
            bw.newLine();

            bw.write(item.getCodigo());
            bw.newLine();

            DecimalFormat formato = new DecimalFormat("#.##");

            bw.write(formato.format(item.getPrecoUnitario()));
            bw.newLine();

            bw.write(formato.format(item.getPrecoCusto()));
            bw.newLine();

            bw.write(((Prato) item).getDescricaoPrato());
            bw.newLine();

            bw.write(formato.format(((Prato) item).getTempoPreparo()));
            bw.newLine();

            bw.write(formato.format(((Prato) item).getValorPagoCozinheiro()));
            bw.newLine();

            for (int i = 0; i < ((Prato) item).getListaIngredientes().size(); i++) {
                bw.write(((Prato) item).getListaIngredientes().get(i) + ";");
            }

            bw.close();

        } else if (item instanceof Sobremesa) {

        FileWriter fw = new FileWriter("arquivos/itens/" + item.getNome() + ".txt");

            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Sobremesa");
            bw.newLine();
            
            bw.write(item.getNome());
            bw.newLine();

            bw.write(item.getCodigo());
            bw.newLine();

            DecimalFormat formato = new DecimalFormat("#.##");

            bw.write(formato.format(item.getPrecoUnitario()));
            bw.newLine();

            bw.write(formato.format(item.getPrecoCusto()));
            bw.newLine();

            bw.write(((Prato) item).getDescricaoPrato());
            bw.newLine();

            bw.write(formato.format(((Prato) item).getTempoPreparo()));
            bw.newLine();

            bw.write(formato.format(((Prato) item).getValorPagoCozinheiro()));
            bw.newLine();
            
            bw.write(formato.format(((Sobremesa) item).getNumeroCalorias()));
            bw.newLine();

            for (int i = 0; i < ((Prato) item).getListaIngredientes().size(); i++) {
                bw.write(((Prato) item).getListaIngredientes().get(i) + ";");
            }

            bw.close();

        } else if (item instanceof Bebida) {

            FileWriter fw = new FileWriter("arquivos/itens/" + item.getNome() + ".txt");

            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Bebida");
            bw.newLine();
            
            bw.write(item.getNome());
            bw.newLine();

            bw.write(item.getCodigo());
            bw.newLine();

            DecimalFormat formato = new DecimalFormat("#.##");

            bw.write(formato.format(item.getPrecoUnitario()));
            bw.newLine();

            bw.write(formato.format(item.getPrecoCusto()));
            bw.newLine();
            
            bw.write(formato.format(((Bebida) item).getTamanhoEmbalagem()));
            bw.newLine();
            
            bw.write(((Bebida) item).getTipoEmbalagem());
            bw.newLine();
            
            bw.close();

        }
        
    }

    public static void cadastrarFuncionario(Funcionario funcionario) throws IOException {
        if (funcionario instanceof Cozinheiro) {

            FileWriter fw = new FileWriter("arquivos/funcionarios/" + funcionario.getNome() + ".txt");

            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Cozinheiro");
            bw.newLine();
            
            bw.write(funcionario.getNome());
            bw.newLine();

            bw.write(funcionario.getCPF());
            bw.newLine();

            bw.write(funcionario.getRG());
            bw.newLine();
            
            bw.write(funcionario.getEstadoCivil());
            bw.newLine();
            
            bw.write(funcionario.getEndereco());
            bw.newLine();
            
            bw.write(funcionario.getCarteiraTrabalho());
            bw.newLine();
            
            bw.write(funcionario.getData().getDia() + "-" + funcionario.getData().getMes() + "-" + funcionario.getData().getAno());
            bw.newLine();
            
            for (int i = 0; i < ((Cozinheiro) funcionario).getPratosCozinheiro().size(); i++) {
                bw.write(((Cozinheiro) funcionario).getPratosCozinheiro().get(i).getNome() + ";");
            }

            bw.close();

        }else if(funcionario instanceof Garcom) {
            FileWriter fw = new FileWriter("arquivos/funcionarios/" + funcionario.getNome() + ".txt");

            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Garcom");
            bw.newLine();
            
            bw.write(funcionario.getNome());
            bw.newLine();

            bw.write(funcionario.getCPF());
            bw.newLine();

            bw.write(funcionario.getRG());
            bw.newLine();
            
            bw.write(funcionario.getEstadoCivil());
            bw.newLine();
            
            bw.write(funcionario.getEndereco());
            bw.newLine();
            
            bw.write(funcionario.getCarteiraTrabalho());
            bw.newLine();
            
            bw.write(funcionario.getData().getDia() + "-" + funcionario.getData().getMes() + "-" + funcionario.getData().getAno());
            bw.newLine();

            DecimalFormat formato = new DecimalFormat("#.##");
            
            bw.write(formato.format(((Garcom) funcionario).getSalarioBase()));
            bw.newLine();
            
            bw.write(((Garcom) funcionario).getDiaFolga());
            bw.newLine();
            
            bw.close();
        }
    }
    
    public static void cadastrarIgredientes(ArrayList<String> igredientes) throws IOException {
        
        FileWriter fw = new FileWriter("arquivos/recursos/ingredientes.txt");

        BufferedWriter bw = new BufferedWriter(fw);
        
        for (int i = 0; i < igredientes.size(); i++) {
            bw.write(igredientes.get(i));
            bw.newLine();
        }
        
        bw.close();
        
    }
    
    public static void cadastrarTiposDeEmbalagem(ArrayList<String> tipos) throws IOException {
        
        FileWriter fw = new FileWriter("arquivos/recursos/tiposDeEmbalagem.txt");

        BufferedWriter bw = new BufferedWriter(fw);
        
        for (int i = 0; i < tipos.size(); i++) {
            bw.write(tipos.get(i));
            bw.newLine();
        }
        
        bw.close();
        
    }
    
    public static void cadastrarFormasDePagameto(ArrayList<String> formas) throws IOException {
        
        FileWriter fw = new FileWriter("arquivos/recursos/formasDePagamento.txt");

        BufferedWriter bw = new BufferedWriter(fw);
        
        for (int i = 0; i < formas.size(); i++) {
            bw.write(formas.get(i));
            bw.newLine();
        }
        
        bw.close();
        
    }
    
    public static void cadastrarRegistroDePedido(Pedido pedido, String nomeArq) throws IOException {
        
        FileWriter fw = new FileWriter("arquivos/pedidos/" + nomeArq + ".txt");

        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write(pedido.getData().getDia() + "-" + pedido.getData().getMes() + "-" + pedido.getData().getAno() );
        bw.newLine();
        
        bw.write(pedido.getHoraRegistro().getHoras() + ":" + pedido.getHoraRegistro().getMinutos() + ":" + pedido.getHoraRegistro().getSegundos());
        bw.newLine();
        
        bw.write(pedido.getHoraPagamento().getHoras() + ":" + pedido.getHoraPagamento().getMinutos() + ":" + pedido.getHoraPagamento().getSegundos());
        bw.newLine();
        
        bw.write(pedido.getFormaDePagamento());
        bw.newLine();
        
        DecimalFormat formato = new DecimalFormat("#.##");

        bw.write(formato.format(pedido.getValorTotal()));
        bw.newLine();
        
        bw.write(pedido.getCozinheiro().getNome());
        bw.newLine();
            
        bw.write(pedido.getGarcom().getNome());
        bw.newLine();
        
        for(int i = 0; i < pedido.getConjuntoItens().size(); i++) {
            bw.write(pedido.getConjuntoItens().get(i).getItem().getNome() + "-" + pedido.getConjuntoItens().get(i).getQtd() + ";");
        }
        
        bw.close();
    }
    
    private static Item lerItem(String dir) {
        try {
            FileReader fileReader = new FileReader(dir);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String tipo = bufferedReader.readLine();

            String nome = bufferedReader.readLine();
            String codigo = bufferedReader.readLine();

            String precoUnitarioStr = bufferedReader.readLine();
            float precoUnitario = Float.parseFloat(precoUnitarioStr.replaceAll(",", "."));

            String precoCustoStr = bufferedReader.readLine();
            float precoCusto = Float.parseFloat(precoCustoStr.replaceAll(",", "."));

            if (tipo.equals("PratoPrincipal")) {

                String desc = bufferedReader.readLine();

                String tempoPrepStr = bufferedReader.readLine();
                float tempoPrep = Float.parseFloat(tempoPrepStr.replaceAll(",", "."));

                String valorPagoCozStr = bufferedReader.readLine();
                float valorPagoCoz = Float.parseFloat(valorPagoCozStr.replaceAll(",", "."));

                String ingredientesStr = bufferedReader.readLine();
                String[] ingredientesArray = ingredientesStr.replaceAll(";$", "").split(";");
                ArrayList<String> ingredientes = new ArrayList<String>(Arrays.asList(ingredientesArray));
                
                bufferedReader.close();
                return new PratoPrincipal(nome, codigo, precoUnitario, precoCusto, ingredientes, desc, tempoPrep, valorPagoCoz);

            } else if (tipo.equals("Sobremesa")) {

                String desc = bufferedReader.readLine();

                String tempoPrepStr = bufferedReader.readLine();
                float tempoPrep = Float.parseFloat(tempoPrepStr.replaceAll(",", "."));

                String valorPagoCozStr = bufferedReader.readLine();
                float valorPagoCoz = Float.parseFloat(valorPagoCozStr.replaceAll(",", "."));

                String caloriasStr = bufferedReader.readLine();
                float calorias = Float.parseFloat(caloriasStr.replaceAll(",", "."));

                String ingredientesStr = bufferedReader.readLine();
                String[] ingredientesArray = ingredientesStr.replaceAll(";$", "").split(";");
                ArrayList<String> ingredientes = new ArrayList<String>(Arrays.asList(ingredientesArray));
                
                bufferedReader.close();
                return new Sobremesa(nome, codigo, precoUnitario, precoCusto, ingredientes, desc, tempoPrep, valorPagoCoz, calorias);
                
            } else if (tipo.equals("Bebida")) {

                String tamanhoStr = bufferedReader.readLine();
                float tamanho = Float.parseFloat(tamanhoStr.replaceAll(",", "."));

                String embalagem = bufferedReader.readLine();

                bufferedReader.close();
                return new Bebida(nome, codigo, precoUnitario, precoCusto, tamanho, embalagem);

            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Funcionario lerFuncionario(Restaurante restaurante, String dir) {

        try {

            FileReader fileReader = new FileReader(dir);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String tipo = bufferedReader.readLine();

            String nome = bufferedReader.readLine();
            String cpf = bufferedReader.readLine();
            String rg = bufferedReader.readLine();
            String estadoCivil = bufferedReader.readLine();
            String endereco = bufferedReader.readLine();
            String carteiraDeTrabalho = bufferedReader.readLine();

            String dataAdmStr = bufferedReader.readLine();
            String[] dataAdmArray = dataAdmStr.split("-");
            int[] dataAdm = new int[3];
            
            dataAdm[0] = Integer.parseInt(dataAdmArray[0]);
            dataAdm[1] = Integer.parseInt(dataAdmArray[1]);
            dataAdm[2] = Integer.parseInt(dataAdmArray[2]);
        

            if (tipo.equals("Cozinheiro")) {

                String pratosStr = bufferedReader.readLine();
                String[] pratosArray = pratosStr.replaceAll(";$", "").split(";");
                ArrayList<String> pratos = new ArrayList<String>(Arrays.asList(pratosArray));

                bufferedReader.close();

                Cozinheiro c = new Cozinheiro(nome, cpf, rg, estadoCivil, endereco, carteiraDeTrabalho, new Data(dataAdm[0], dataAdm[1], dataAdm[2]));
                for (int i = 0; i < pratos.size(); i++) {
                    c.addPratoCrozinheiro(restaurante.buscarItemPorNome(pratos.get(i)));
                }
                return c;

            } else if (tipo.equals("Garcom")) {

                String salarioBaseStr = bufferedReader.readLine();
                float salarioBase = Float.parseFloat(salarioBaseStr.replaceAll(",", "."));

                String folga = bufferedReader.readLine();
                
                bufferedReader.close();
                return new Garcom(nome, cpf, rg, estadoCivil, endereco, carteiraDeTrabalho, new Data(dataAdm[0], dataAdm[1], dataAdm[2]), salarioBase, folga);
            }

            bufferedReader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<String> lerRecursos(String dir) {
        FileReader fileReader;

        ArrayList<String> itens = new ArrayList<String>();
        try {
            fileReader = new FileReader(dir);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;
            try {
                while ((linha = bufferedReader.readLine()) != null) {
                    itens.add(linha);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            return itens;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    private static Pedido lerRegistroDePedido(Restaurante restaurante, String dir) {

        FileReader fileReader;
        try {
            fileReader = new FileReader(dir);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String dataPedidoStr = bufferedReader.readLine();
            String[] dataPedidoArray = dataPedidoStr.split("-");
            int[] dataPedido = new int[3];
            
            dataPedido[0] = Integer.parseInt(dataPedidoArray[0]);
            dataPedido[1] = Integer.parseInt(dataPedidoArray[1]);
            dataPedido[2] = Integer.parseInt(dataPedidoArray[2]);

            String horaRegistroStr = bufferedReader.readLine();
            String[] horaRegistroArray = horaRegistroStr.split(":");
            int[] horaRegistro = new int[3];
            
            horaRegistro[0] = Integer.parseInt(horaRegistroArray[0]);
            horaRegistro[1] = Integer.parseInt(horaRegistroArray[1]);
            horaRegistro[2] = Integer.parseInt(horaRegistroArray[2]);

            String horaPagamentoStr = bufferedReader.readLine();
            String[] horaPagamentoArray = horaPagamentoStr.split(":");
            int[] horaPagamento = new int[3];
            
            horaPagamento[0] = Integer.parseInt(horaPagamentoArray[0]);
            horaPagamento[1] = Integer.parseInt(horaPagamentoArray[1]);
            horaPagamento[2] = Integer.parseInt(horaPagamentoArray[2]);

            String formaDePagamento = bufferedReader.readLine();

            bufferedReader.readLine();

            String cozNome = bufferedReader.readLine();
            Funcionario coz = restaurante.buscarFuncionarioPorNome(cozNome);
            String garNome = bufferedReader.readLine();
            Funcionario gar = restaurante.buscarFuncionarioPorNome(garNome);

            String pedidoItensStr = bufferedReader.readLine();
            String[] pedidoItensArray = pedidoItensStr.replaceAll(";$", "").split(";");
            ArrayList<String> pedidoItensArrayList = new ArrayList<String>(Arrays.asList(pedidoItensArray));

            ArrayList<PedidoItem> apd = new ArrayList<PedidoItem>();
            for (int i = 0; i < pedidoItensArrayList.size(); i++) {

                String[] temp = pedidoItensArrayList.get(i).split("-");
                apd.add(new PedidoItem(restaurante.buscarItemPorNome(temp[0]), Integer.parseInt(temp[1])));

            }

            bufferedReader.close();
            return new Pedido(apd,  new Data(dataPedido[0], dataPedido[1], dataPedido[2]), new Hora(horaRegistro[0], horaRegistro[1], horaRegistro[2]), new Hora(horaPagamento[0], horaPagamento[1], horaPagamento[2]), formaDePagamento, (Cozinheiro )coz, (Garcom) gar);

        } catch (IOException e) {
            e.printStackTrace();
        }
            
        return null;
    }

    public static ArrayList<Funcionario> lerDirFuncionarios(Restaurante restaurante, String dir) {
        File diretorio = new File(dir);
        File[] arquivos = diretorio.listFiles();

        if (diretorio.isDirectory()) {
            ArrayList<Funcionario> x = new ArrayList<>();
            for (File arquivo : arquivos) {
                x.add(lerFuncionario(restaurante, dir + "/" + arquivo.getName()));
            }
            return x;
        }

        return null;
    }

    public static ArrayList<Item> lerDirItens(String dir) {
        File diretorio = new File(dir);
        File[] arquivos = diretorio.listFiles();

        if (diretorio.isDirectory()) {
            ArrayList<Item> x = new ArrayList<>();
            for (File arquivo : arquivos) {
                x.add(lerItem(dir + "/" + arquivo.getName()));
            }
            return x;
        }

        return null;
    }

    public static ArrayList<Pedido> lerDirPedidos(Restaurante restaurante, String dir) {
        File diretorio = new File(dir);
        File[] arquivos = diretorio.listFiles();

        if (diretorio.isDirectory()) {
            ArrayList<Pedido> x = new ArrayList<>();
            for (File arquivo : arquivos) {
                x.add(lerRegistroDePedido(restaurante, dir + "/" + arquivo.getName()));
            }
            return x;
        }

        return null;
    }
}
