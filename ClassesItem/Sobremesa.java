package ClassesItem;

import java.util.ArrayList;

public class Sobremesa extends Prato {
    private double numeroCalorias;

    //Construtores
    public Sobremesa(String nome, String codigo, double precoUnitario, double precoCusto, ArrayList<String> listaIngredientes, String descricaoPrato, double tempoPreparo, double valorPagoCozinheiro, double numeroCalorias) {
        super(nome, codigo, precoUnitario, precoCusto, listaIngredientes, descricaoPrato, tempoPreparo, valorPagoCozinheiro);
        this.numeroCalorias = numeroCalorias;
    }

    public Sobremesa(Sobremesa prato) {
        super(prato.getNome(), prato.getCodigo(), prato.getPrecoUnitario(), prato.getPrecoCusto(), prato.getListaIngredientes(), prato.getDescricaoPrato(), prato.getTempoPreparo(), prato.getValorPagoCozinheiro());
        this.numeroCalorias = prato.getNumeroCalorias();
    }

    //Métodos GET/SET
    public double getNumeroCalorias() {
        return numeroCalorias;
    }

    public void setNumeroCalorias(double numeroCalorias) {
        this.numeroCalorias = numeroCalorias;
    }

    //Outros métodos
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Quantidade de Calorias: " + numeroCalorias);
    }
}