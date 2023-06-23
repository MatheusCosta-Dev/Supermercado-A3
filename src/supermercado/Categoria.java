package supermercado;

import java.util.Scanner;

public class Categoria {
    Scanner ss = new Scanner(System.in);
    private String nome;
    private int id;
    private Funcionario funcionario;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Categoria() {
    }

    public void cadastrarCategoria() {
        System.out.print("Digite o nome: ");
        setNome(ss.nextLine());
        
    }
    
}
