package cliente;

public class Pedido {

    private boolean pedido;
    private boolean acompanharEntrega;
    private boolean enderecoEntrega;

    public void setPedido(boolean pedido) {
        this.pedido = pedido;
    }

    public boolean getPedido() {

        return pedido;
    }

    public boolean getAcompanharEntrega() {
        return acompanharEntrega;
    }

    public boolean getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public boolean entregaPedido(){
        if(this.getEnderecoEntrega() == true){
            return true;
        }else{
            return false;
        }
    }

    public  boolean pedidoFinal(){
        if(this.getPedido() == true){
            return true;
        }else{
            return false;
        }
    }

    public boolean statusEntrega(){
        if(this.getAcompanharEntrega() == true){
            return true;
        }else{
            return  false;
        }
    }
}
