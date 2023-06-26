package supermercado;

import java.util.ArrayList;
import java.util.Scanner;

public class Produto {
    ArrayList<Produto> listarProduto = new ArrayList();
    //Scanners
    Scanner ss = new Scanner(System.in);
    Scanner sn = new Scanner(System.in);
    
    //Atributos
    private String nome;
    private int codigo, idCategoria, idFuncionario;
    private Categoria categoria;
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

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
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
    
    
    public Produto() {
        
    }

    public void cadastrarProduto() {
        categoria = new Categoria();
        
        System.out.print("Escreva o nome do produto: ");
        setNome(ss.nextLine());
        System.out.print("Escreva o preço: ");
        setPreco(sn.nextFloat());
        categoria.listarCategoria();
        System.out.print("Insira a categoria: ");
        setIdCategoria(sn.nextInt());
        
        String sql = "INSERT INTO produto (nome, preco, id_categoria, id_funcionario) VALUES ( '"
                + getNome() + "',"
                + getPreco() + ","
                + getIdCategoria() + ","
                + getIdFuncionario() + ")";

        Conexao.executar(sql);
        System.out.println("Produto cadastrado.");

    }
    
    
    
    
    /*
    
    public void editarProduto(){
        System.out.println("Escreva o nome do produto que deseja alterar: ");
        String nome = ss.nextLine();
    }
    
    */
}
