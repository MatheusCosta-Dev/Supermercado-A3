package supermercado;

import java.util.Scanner;

public class Produto {
    
    //Scanners
    Scanner ss = new Scanner(System.in);
    Scanner sn = new Scanner(System.in);
    
    //Atributos
    private String nome;
    private int codigo;
    private float preco;
    
    //Geters e Seters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    // Construtor
    
    //Métodos 
    public void mostrarProdutos() {
        System.out.println("========================");
        System.out.println("Código: " + getCodigo());
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: " + getPreco());
        
    }

    public Produto(String nome, int codigo, float preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }

    public void cadastrarProduto() {
        System.out.print("Escreva o nome do produto: ");
        setNome(ss.nextLine());
        System.out.print("Escreva o preço: ");
        setPreco(sn.nextFloat());
    }
    /*
    
    public void editarProduto(){
        System.out.println("Escreva o nome do produto que deseja alterar: ");
        String nome = ss.nextLine();
    }
    
    */
}
