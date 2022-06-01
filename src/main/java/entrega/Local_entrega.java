package entrega;

import cliente.Pedido;

public class Local_entrega {

    private boolean localizacaoEntregador;

    public boolean getLocalizacaoEntregador() {
        return localizacaoEntregador;
    }

    public void setLocalizacaoEntregador(boolean localizacaoEntregador) {
        this.localizacaoEntregador = localizacaoEntregador;
    }

    public String statusPedido(Pedido pedido){
        if(pedido.pedidoFinal() == true){
            return "Saiu para entrega";
        }else{
            return "Seu pedido sairá em breve";
        }
    }

    public boolean verificarLocalEntrega(Pedido local){
        if(local.entregaPedido() == true){
            return true;
        }else{
            return false;
        }
    }

    public boolean gps(Acompanhar_pedido acompanhar, Pedido local){
        if(acompanhar.getGps() == true && local.getEnderecoEntrega() == true){
            return true;
        }else{
            return false;
        }
    }
}
