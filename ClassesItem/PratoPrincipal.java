package ClassesItem;

import java.util.ArrayList;

public class PratoPrincipal extends Prato {
    public PratoPrincipal(String nome, String codigo, double precoUnitario, double precoCusto, ArrayList<String> listaIngredientes, String descricaoPrato, double tempoPreparo, double valorPagoCozinheiro) {
        super(nome, codigo, precoUnitario, precoCusto, listaIngredientes, descricaoPrato, tempoPreparo, valorPagoCozinheiro);
    }

    public PratoPrincipal(PratoPrincipal prato) {
        super(prato.getNome(), prato.getCodigo(), prato.getPrecoUnitario(), prato.getPrecoCusto(), prato.getListaIngredientes(), prato.getDescricaoPrato(), prato.getTempoPreparo(), prato.getValorPagoCozinheiro());
    }
}