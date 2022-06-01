package entrega;

import cliente.Pedido;

public class Acompanhar_pedido {

    private boolean gps;

    public boolean getGps() {
        return gps;
    }

    public String statusEntregador(Local_entrega local_entrega, Pedido pedido){
        if(local_entrega.statusPedido(pedido) == "Saiu para entrega"){
            return "Pedido a caminho";
        }else{
            return "Aguardando o entregador pegar o pedido";
        }
    }
    public boolean localizacaoTempoReal(Local_entrega entrega){
        if(entrega.getLocalizacaoEntregador() == true){
            return true;
        }else{
            return false;
        }
    }
}
