package mercado;
public class Cliente extends Pessoa {
  
      private String id;
      private float saldo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public void consultarDados() {
        System.out.println(nome);
        System.out.println(CPF);
        System.out.println(id);
        System.out.println(saldo);
        
    }

    public void cadastroCliente(String nome, String CPF, String id, Float saldo){
        setNome(nome);
        setCPF(CPF);
        setId(id);
        setSaldo(saldo);
    }
}
