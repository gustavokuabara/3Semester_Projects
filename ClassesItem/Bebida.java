package ClassesItem;

public class Bebida extends Item {
    private double tamanhoEmbalagem;
    private String tipoEmbalagem;

    //Construtores
    public Bebida(String nome, String codigo, double precoUnitario, double precoCusto, double tamanhoEmbalagem, String tipoEmbalagem) {
        super(nome, codigo, precoUnitario, precoCusto);
        this.tamanhoEmbalagem = tamanhoEmbalagem;
        this.tipoEmbalagem = tipoEmbalagem;
    }

    public Bebida(Bebida bebida) {
        super(bebida.getNome(), bebida.getCodigo(), bebida.getPrecoUnitario(), bebida.getPrecoCusto());
        this.tamanhoEmbalagem = bebida.getTamanhoEmbalagem();
        this.tipoEmbalagem = bebida.getTipoEmbalagem();
    }

    //Métoddos GET/SET
    public double getTamanhoEmbalagem() {
        return tamanhoEmbalagem;
    }

    public void setTamanhoEmbalagem(double tamanhoEmbalagem) {
        this.tamanhoEmbalagem = tamanhoEmbalagem;
    }

    public String getTipoEmbalagem() {
        return tipoEmbalagem;
    }

    public void setTipoEmbalagem(String tipoEmbalagem) {
        this.tipoEmbalagem = tipoEmbalagem;
    }

    //Outros métodos
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Tamanho da Embalagem: " + tamanhoEmbalagem);
        System.out.println("Tipo de Embalagem: " + tipoEmbalagem);
    }
}