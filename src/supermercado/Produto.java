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

    //Métodos 
    public void mostrarProdutos() {
        System.out.println("Código: " + getCodigo());
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: " + getPreco());
        System.out.println("========================");
    }

    public void cadastrar() {
        System.out.println("Escreva o nome do produto: ");
        setNome(ss.nextLine());
        System.out.println("Escreva o preço: ");
        setPreco(sn.nextFloat());
    }
    /*
    
    public void editarProduto(){
        System.out.println("Escreva o nome do produto que deseja alterar: ");
        String nome = ss.nextLine();
    }
    
    */
}
