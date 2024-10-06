package ClassesFuncionario;
import ClassesAuxiliares.Data;

public class Garcom extends Funcionario {
    private double salarioBase;
    public String diaFolga;
    
    //Cosntrutores
    public Garcom(String nome, String CPF, String RG, String estadoCivil, String endereco, String carteiraTrabalho, Data dataAdmissao, double salarioBase, String diaFolga){
        super(nome, CPF, RG, estadoCivil, endereco, carteiraTrabalho, dataAdmissao);
        this.salarioBase = salarioBase;
        this.diaFolga = diaFolga;
    }

    public Garcom(Garcom garcom) {
        super(garcom);
        this.salarioBase = garcom.getSalarioBase();
        this.diaFolga = garcom.getDiaFolga();
    }
    
    //Métodos GET/SET
    public void setDiaFolga(String diaFolga) {
        this.diaFolga = diaFolga;
    }

    public String getDiaFolga() {
        return diaFolga;
    }
    
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
    
    //Outros métodos
    public double calcSalario(){
        //***o calculo q eu n sei
        return 0.5;
    }

    public double calcSalario(double salarioBase, int numeroPedidosMes, double limitePedidos, double gratificacaoExtra) {
        double salario = salarioBase;
    
        if (numeroPedidosMes > limitePedidos) {
            salario += gratificacaoExtra;
        }
    
        return salario;
    }
}
