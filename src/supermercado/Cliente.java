package supermercado;

import java.util.Scanner;

public class Cliente extends Pessoa {
    Scanner sn = new Scanner(System.in);
    Scanner ss = new Scanner(System.in);

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
        System.out.println("===== Dados =====");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("ID: " + getId());
        System.out.println("Saldo: R$" + getSaldo());
        System.out.println("=================");
        
    }

    public void depositarSaldo() {
        System.out.print("Quanto você quer depositar ? R$");
        float saldo = sn.nextFloat();
        setSaldo(getSaldo() + saldo);
        
    }

}
