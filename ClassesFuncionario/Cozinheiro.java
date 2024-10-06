package ClassesFuncionario;

import ClassesAuxiliares.Data;
import ClassesItem.Bebida;
import ClassesItem.Item;
import ClassesItem.PratoPrincipal;
import ClassesItem.Sobremesa;
import ClassesPedido.PedidoItem;

import java.util.ArrayList;

public class Cozinheiro extends Funcionario {
    private ArrayList<Item> pratosCozinheiro;
    
    //Construtores
    public Cozinheiro(String nome, String CPF, String RG, String estadoCivil, String endereco, String carteiraTrabalho, Data dataAdmissao){
        super(nome, CPF, RG, estadoCivil, endereco, carteiraTrabalho, dataAdmissao);
        this.pratosCozinheiro = new ArrayList<Item>();
    }

    public Cozinheiro(Cozinheiro cozinheiro) {
        super(cozinheiro);
        this.pratosCozinheiro = cozinheiro.getPratosCozinheiro();
    }
    
    //Métodos GET/SET
    public void addPratoCrozinheiro(Item item) {
        if (item instanceof Bebida) {
            pratosCozinheiro.add((Bebida) item);
        } else if (item instanceof PratoPrincipal) {
            pratosCozinheiro.add((PratoPrincipal) item);
        } else if (item instanceof Sobremesa) {
            pratosCozinheiro.add((Sobremesa) item);
        } else {
            pratosCozinheiro.add(item);
        }
    }

    public ArrayList<Item> getPratosCozinheiro() {
        return new ArrayList<Item>(pratosCozinheiro);
    }
    
    //Outros métodos
    public  double calcSalario(){
        //***o calculo q eu n sei
        return 0.5;
    }

    public double calcSalario(double valorPratoPrincipal, double valorSobremesa, ArrayList<PedidoItem> ped) {
        double salario = 0.0;

        for (PedidoItem item : ped) {
            if (item.getItem() instanceof PratoPrincipal) {
                salario += valorPratoPrincipal;
            } else if (item.getItem() instanceof Sobremesa) {
                salario += valorSobremesa;
            }
        }
    
        return salario;
    }

    // Verifica se o cozinheiro cozinha o prata dado com o código dado como parâmetro 
    public boolean verificarPrato(String cod) {

        for (int i = 0; i < pratosCozinheiro.size(); i++) {
            if (cod.equals(pratosCozinheiro.get(i).getCodigo())) {
                return true;
            }
        }

        return false;
    }
}
