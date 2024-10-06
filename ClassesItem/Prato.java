package ClassesItem;

import java.util.ArrayList;

public abstract class Prato extends Item {
    private ArrayList<String> listaIngredientes;
    private String descricaoPrato;
    private double tempoPreparo;
    private double valorPagoCozinheiro;

    //Cosntrutor
    public Prato(String nome, String codigo, double precoUnitario, double precoCusto, ArrayList<String> listaIngredientes, String descricaoPrato, double tempoPreparo, double valorPagoCozinheiro) {
        super(nome, codigo, precoUnitario, precoCusto);
        this.listaIngredientes = new ArrayList<String>(listaIngredientes);
        this.descricaoPrato = descricaoPrato;
        this.tempoPreparo = tempoPreparo;
        this.valorPagoCozinheiro = valorPagoCozinheiro;
        this.valorPagoCozinheiro = valorPagoCozinheiro;
    }

    public Prato(Prato prato) {
        super(prato.getNome(), prato.getCodigo(), prato.getPrecoUnitario(), prato.getPrecoCusto());
        this.listaIngredientes = prato.getListaIngredientes();
        this.descricaoPrato = prato.getDescricaoPrato();
        this.tempoPreparo = prato.getTempoPreparo();
        this.valorPagoCozinheiro = prato.getValorPagoCozinheiro();
    }

    //Métodos GET/SET
    public ArrayList<String> getListaIngredientes() {
        return new ArrayList<String>(listaIngredientes);
    }

    public void setListaIngredientes(ArrayList<String> listaIngredientes) {
        this.listaIngredientes = new ArrayList<String>(listaIngredientes);
    }

    public String getDescricaoPrato() {
        return descricaoPrato;
    }

    public void setDescricaoPrato(String descricaoPrato) {
        this.descricaoPrato = descricaoPrato;
    }

    public double getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(double tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public double getValorPagoCozinheiro() {
        return valorPagoCozinheiro;
    }

    public void setValorPagoCozinheiro(double valorPagoCozinheiro) {
        this.valorPagoCozinheiro = valorPagoCozinheiro;
    }

    //Outros métodos
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Ingredientes: " + listaIngredientes +
                "\nDescrição do prato: " + descricaoPrato +
                "\nTempo de Preparo (min): " + tempoPreparo +
                "\nValor Pago ao Cozinheiro: " + valorPagoCozinheiro);
    }
}