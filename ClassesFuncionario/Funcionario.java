package ClassesFuncionario;

import ClassesAuxiliares.Data;

public abstract class Funcionario {
    protected String nome;
    protected String CPF;
    protected String RG;
    protected String estadoCivil;
    protected String endereco;
    protected String carteiraDeTrabalho;
    protected Data dataAdmissao;
    private static final String VALID_FORMAT_REGEX = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})";
    
    //Cosntrutores
    public Funcionario(String nome, String CPF, String RG, String estadoCivil, String endereco, String carteiraTrabalho, Data dataAdmissao){
        this.nome = nome;
        if (validarCPF(CPF)) {
            this.CPF = CPF;
        } else {
            //**Exception
        }
        this.RG = RG;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.carteiraDeTrabalho = carteiraTrabalho;
        this.dataAdmissao = new Data(dataAdmissao.getDia(), dataAdmissao.getMes(), dataAdmissao.getAno());
    }

    public Funcionario(Funcionario funcionario) {
        this.nome = funcionario.getNome();
        this.CPF = funcionario.getCPF();
        this.RG = funcionario.getRG();
        this.estadoCivil = funcionario.getEstadoCivil();
        this.endereco = funcionario.getEndereco();
        this.carteiraDeTrabalho = funcionario.getCarteiraTrabalho();
        this.dataAdmissao = funcionario.getData();
    }

    public Funcionario(){
        nome = null;
        CPF = null;
        RG = null;
        estadoCivil = null;
        endereco = null;
        carteiraDeTrabalho = null;
        dataAdmissao = null;
    }   

    //Métodos GET/SET
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        if (validarCPF(CPF)) {
            this.CPF = CPF;
        } else {
            //**Exception
        }
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCarteiraTrabalho() {
        return carteiraDeTrabalho;
    }

    public void setCarteiraTrabalho(String carteiraTrabalho) {
        this.carteiraDeTrabalho = carteiraTrabalho;
    }

    public Data getData() {
        return new Data(dataAdmissao.getDia(), dataAdmissao.getMes(), dataAdmissao.getAno());
    }

    public void setDataAdmissao(int dia, int mes, int ano) {
        this.dataAdmissao = new Data(dia, mes, ano);
    }

    public void setDataAdmissao(Data dataAdmissao) {
        this.dataAdmissao = new Data(dataAdmissao.getDia(), dataAdmissao.getMes(), dataAdmissao.getAno());
    }

    //Outros métodos
    public static boolean validarCPF(String cpf){        
        if (cpf.matches(VALID_FORMAT_REGEX)) {
            return true;
        }
        else {
            return false;
        }
    }

    //**=======================================
    public abstract double calcSalario();  
}
