package supermercado;
import java.time.LocalDateTime;

public class Pedido {
    LocalDateTime dataHoraAtual = LocalDateTime.now();
    private float valor;
    private LocalDateTime data = LocalDateTime.now();
    private int id;

    //Geters e Seters
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }


    public Pedido() {
    }

    
    
}
