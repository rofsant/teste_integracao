import cliente.Pedido;
import entrega.Acompanhar_pedido;
import entrega.Local_entrega;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;


public class Test_local_entrega {

@Test
    public void verificarStatusPedido(){
    Pedido pedido = new Pedido();
    pedido.setPedido(true);
    Local_entrega local_entrega = new Local_entrega();
    Assertions.assertEquals("Saiu para entrega", local_entrega.statusPedido(pedido));
}
    @Test
    public void naoSaiuParaEntrega(){
        Pedido pedido = new Pedido();
        pedido.setPedido(false);
        Local_entrega local_entrega = new Local_entrega();
        Assertions.assertEquals("Seu pedido sairá em breve", local_entrega.statusPedido(pedido));
    }

    @Test
    public void verificarGps(){
        Local_entrega local_entrega = new Local_entrega();
        Pedido pedido = Mockito.mock(Pedido.class);
        Mockito.when(pedido.getEnderecoEntrega()).thenReturn(true);

        Acompanhar_pedido acompanhar = Mockito.mock(Acompanhar_pedido.class);
        Mockito.when(acompanhar.getGps()).thenReturn(true);

        Assertions.assertTrue(local_entrega.gps(acompanhar, pedido));
        Mockito.verify(pedido, times(1)).getEnderecoEntrega();
    }

    @Test
    public void verificarGpsDesligado(){
        Local_entrega local_entrega = new Local_entrega();
        Pedido pedido = Mockito.mock(Pedido.class);
        Mockito.when(pedido.getEnderecoEntrega()).thenReturn(false);

        Acompanhar_pedido acompanhar = Mockito.mock(Acompanhar_pedido.class);
        Mockito.when(acompanhar.getGps()).thenReturn(false);

        Assertions.assertFalse(local_entrega.gps(acompanhar, pedido));
    }
}
