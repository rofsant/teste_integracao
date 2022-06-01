import cliente.Pedido;
import entrega.Acompanhar_pedido;
import entrega.Local_entrega;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Test_acompanhar_pedido {

    @Test
    public void verificarLocalizacaoTempoRealLigado(){
        Acompanhar_pedido statusPedido = new Acompanhar_pedido();
        Local_entrega local_entrega = new Local_entrega();
        local_entrega.setLocalizacaoEntregador(true);
        Assertions.assertTrue(statusPedido.localizacaoTempoReal(local_entrega));
    }

    @Test
    public void verificarLocalizacaoTempoRealDesligado(){
        Acompanhar_pedido statusPedido = new Acompanhar_pedido();
        Local_entrega local_entrega = new Local_entrega();
        local_entrega.setLocalizacaoEntregador(false);
        Assertions.assertFalse(statusPedido.localizacaoTempoReal(local_entrega));
    }

    @Test
    public void verificarEntregadorSaiuEntrega(){
        Acompanhar_pedido statusPedido = new Acompanhar_pedido();
        Pedido pedido = Mockito.mock(Pedido.class);
        Mockito.when(pedido.getEnderecoEntrega()).thenReturn(true);

        Local_entrega acompanhar = Mockito.mock(Local_entrega.class);
        Mockito.when(acompanhar.statusPedido(pedido)).thenReturn("Saiu para entrega");

        Assertions.assertEquals("Pedido a caminho", statusPedido.statusEntregador(acompanhar, pedido));
    }

    @Test
    public void verificarEntregadorNaoSaiuEntrega(){
        Acompanhar_pedido statusPedido = new Acompanhar_pedido();
        Pedido pedido = Mockito.mock(Pedido.class);
        Mockito.when(pedido.getEnderecoEntrega()).thenReturn(false);

        Local_entrega acompanhar = Mockito.mock(Local_entrega.class);
        Mockito.when(acompanhar.statusPedido(pedido)).thenReturn("Seu pedido sairá em breve");

        Assertions.assertEquals("Aguardando o entregador pegar o pedido", statusPedido.statusEntregador(acompanhar, pedido));
    }
}
