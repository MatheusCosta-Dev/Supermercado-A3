package supermercado;

public class Cliente extends Pessoa {

    //Atributos
    private int id;
    private float saldo;

    //Construtor
    public Cliente(int id, float saldo, String nome, String cpf) {
        super(nome, cpf);
        this.id = id;
        this.saldo = saldo;
    }

    //Getters e Seters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    //Método herança
    @Override
    public void mostrarDados() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("ID: " + getId());
        System.out.println("Saldo: " + getSaldo());
    }

}
