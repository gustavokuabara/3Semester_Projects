package ClassesPedido;

import ClassesItem.Bebida;
import ClassesItem.Item;
import ClassesItem.PratoPrincipal;
import ClassesItem.Sobremesa;

public class PedidoItem {
    private Item item;
    private int qtd;
    
    //Construtor
    public PedidoItem(Item item, int qtd) {
        if (item instanceof Bebida) {
            this.item = new Bebida((Bebida) item);
        } else if (item instanceof PratoPrincipal) {
            this.item = new PratoPrincipal((PratoPrincipal) item);                                          
        } else if (item instanceof Sobremesa) {
            this.item = new Sobremesa((Sobremesa) item);
        } else {
            this.item = new Item(item);
        }
        
        this.qtd = qtd;
    }

    public PedidoItem(PedidoItem pd) {
        this.item = pd.getItem();
        this.qtd = pd.getQtd();
    }

    //Métodos GET
    public Item getItem() {
        if (item instanceof Bebida) {
            return new Bebida((Bebida) item);
        } else if (item instanceof PratoPrincipal) {
            return new PratoPrincipal((PratoPrincipal) item);                                          
        } else if (item instanceof Sobremesa) {
            return new Sobremesa((Sobremesa) item);
        } else {
            return new Item(item);
        }
    }

    public int getQtd() {
        return this.qtd;
    }

    public double getPreco() {
        return (double) qtd * item.getPrecoUnitario();
    }

    public double getPrecoCusto() {
        return (double) qtd * item.getPrecoCusto();
    }
    
    //Métodos SET
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void setItem(Item item) {
        if (item instanceof Bebida) {
            this.item = new Bebida((Bebida) item);
        } else if (item instanceof PratoPrincipal) {
            this.item = new PratoPrincipal((PratoPrincipal) item);                                          
        } else if (item instanceof Sobremesa) {
            this.item = new Sobremesa((Sobremesa) item);
        } else {
            this.item = new Item(item);
        }
    }
}
