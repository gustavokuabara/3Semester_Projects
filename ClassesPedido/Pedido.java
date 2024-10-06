package ClassesPedido;
import java.util.ArrayList;

import ClassesAuxiliares.Data;
import ClassesAuxiliares.Hora;
import ClassesItem.Item;
import ClassesFuncionario.Cozinheiro;
import ClassesFuncionario.Garcom;

public class Pedido {
    private ArrayList<PedidoItem> conjuntoItens;
    private Data dataDoPedido;
    private Hora horaRegistro;
    private Hora horaPagamento;
    private String formaDePagamento;
    private double valorTotal;
    private Cozinheiro cozinheiro;
    private Garcom garcom;

    //Construtor
    public Pedido(ArrayList<PedidoItem> conjuntoItens, Data dataDoPedido, Hora horaRegistro, Hora horaPagamento, String formaDePagamento, Cozinheiro coz, Garcom gar) {
        this.conjuntoItens = new ArrayList<PedidoItem>(conjuntoItens);
        this.dataDoPedido = new Data(dataDoPedido);
        this.horaRegistro = new Hora(horaRegistro);
        this.horaPagamento = new Hora(horaPagamento);
        this.formaDePagamento = formaDePagamento;
        this.cozinheiro = new Cozinheiro(coz);
        this.garcom = new Garcom(gar);

        double total = 0;
        for (int i = 0; i < conjuntoItens.size(); i++) {
            total += this.conjuntoItens.get(i).getPreco();
        }
        this.valorTotal = total;
    }

    public Pedido(Pedido pedido) {
        this.conjuntoItens = pedido.getConjuntoItens();
        this.dataDoPedido = pedido.getData();
        this.horaRegistro = pedido.getHoraRegistro();
        this.horaPagamento = pedido.getHoraPagamento();
        this.formaDePagamento = pedido.getFormaDePagamento();
        this.cozinheiro = pedido.getCozinheiro();
        this.garcom = pedido.getGarcom();

        double total = 0;
        for (int i = 0; i < conjuntoItens.size(); i++) {
            total += this.conjuntoItens.get(i).getPreco();
        }
        this.valorTotal = total;
    }

    //Métodos GET
    public ArrayList<PedidoItem> getConjuntoItens() {
        return new ArrayList<PedidoItem>(this.conjuntoItens);
    }

    public Data getData() {
        return new Data(this.dataDoPedido);
    }

    public Hora getHoraRegistro() {
        return new Hora(this.horaRegistro);
    }

    public Hora getHoraPagamento() {
        return new Hora(this.horaPagamento);
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public Cozinheiro getCozinheiro() {
        return new Cozinheiro(cozinheiro);
    }

    public Garcom getGarcom() {
        return new Garcom(garcom);
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    //Métodos SET
    public void setConjuntoItens(ArrayList<PedidoItem> conjuntoItems) {
        this.conjuntoItens = new ArrayList<PedidoItem>(conjuntoItens);

        double total = 0;
        for (int i = 0; i < conjuntoItens.size(); i++) {
            total += this.conjuntoItens.get(i).getPreco();
        }
        this.valorTotal = total;
    }

    public void addPedidoItem(PedidoItem pd) {
        conjuntoItens.add(new PedidoItem(pd));
    }

    public void addPedidoItem(Item item, int qtd) {
        conjuntoItens.add(new PedidoItem(item, qtd));
    }

    public void setDataDoPedido(int dia, int mes, int ano) {
        this.dataDoPedido = new Data(dia, mes, ano);
    }

    public void setDataDoPedido(Data data) {
        this.dataDoPedido = new Data(data);
    }

    public void setHoraRegistro(int horas, int minutos, int segundos) {
        this.horaRegistro = new Hora(horas, minutos, segundos);
    }

    public void setHoraRegistro(int horas, int minutos) {
        this.horaRegistro = new Hora(horas, minutos);
    }
    
    public void setHoraRegistro(Hora hora) {
        this.horaRegistro = new Hora(hora);
    }

    public void setHoraPagamento(int horas, int minutos, int segundos) {
        this.horaPagamento = new Hora(horas, minutos, segundos);
    }

    public void setHoraPagamento(int horas, int minutos) {
        this.horaPagamento = new Hora(horas, minutos);
    }
    
    public void setHoraPagamento(Hora hora) {
        this.horaPagamento = new Hora(hora);
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public void setCozinheiro(Cozinheiro coz) {
        this.cozinheiro = new Cozinheiro(coz);
    }

    public void setGarcom(Garcom gar) {
        this.garcom = new Garcom(gar);
    }
}
