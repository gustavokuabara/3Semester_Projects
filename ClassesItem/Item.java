package ClassesItem;

public class Item {
    private String nome;
    private String codigo;
    private double precoUnitario;
    private double precoCusto;
    private static final String VALID_FORMAT_REGEX = "^[A-Za-z]{2}\\d{3}$";

    //Cosntrutor
    public Item(String nome, String codigo, double precoUnitario, double precoCusto) {
        this.nome = nome;
        if (validarCodigo(codigo)) {
            this.codigo = codigo;
        } else {
            //Exception
        }
        

        if (precoCusto < 0) {
            this.precoCusto = 0;
        }
        else {
            this.precoCusto = precoCusto;
        }

        if (precoUnitario < this.precoCusto) {
            this.precoUnitario = this.precoCusto;
        }
        else {
            this.precoUnitario = precoUnitario;
        }        
    }

    public Item(Item item) {
        this.nome = item.getNome();
        this.codigo = item.getCodigo();
        this.precoUnitario = item.getPrecoUnitario();
        this.precoCusto = item.getPrecoCusto();
    }

    //Métodos GET/SET
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (validarCodigo(codigo)) {
            this.codigo = codigo;
        } else {
            //Exception
        }
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    //Outros métodos
    public static boolean validarCodigo(String codigo){        
        if (codigo.matches(VALID_FORMAT_REGEX)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Codigo: " + codigo);
        System.out.println("Preco Unitario: " + precoUnitario);
        System.out.println("Preco de Custo: " + precoCusto);
    }
}