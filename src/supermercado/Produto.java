package supermercado;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Produto {
    ArrayList<Produto> listarProdutos = new ArrayList();
    // Scanners
    Scanner ss = new Scanner(System.in);
    Scanner sn = new Scanner(System.in);

    // Atributos
    private String nome;
    private int codigo, idCategoria, idFuncionario, id_categoria, quantidade_estoque;
    private Categoria categoria;
    private float preco;
    private Produto produto;

    // Geters e Seters

    public int getCodigo() {
        return codigo;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
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

    // Métodos
    public void mostrarProdutos() {
        System.out.println("========================");
        System.out.println("Código: " + getCodigo());
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: " + getPreco());

    }

    public Produto() {

    }

    public Produto(String nome, float preco, int quantidade_estoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade_estoque = quantidade_estoque;
    }

    public void cadastrarProduto() {
        categoria = new Categoria();
        int excecoes = 0;
        float precoProduto = 0;

        System.out.print("Escreva o nome do produto: ");
        setNome(ss.nextLine());

        do {
            try {
                System.out.print("Digite o preço: ");
                precoProduto = sn.nextFloat();
                if (precoProduto < 0) {
                    System.out.println("Valor inserido é um valor negativo, ponha um valor valido {0, infinito}");
                    excecoes = 1;
                } else {
                    setPreco(precoProduto);
                    excecoes = 0;
                }

            } catch (InputMismatchException ae) {
                System.out.println("Letra em lugar de numero! ");
                excecoes = 1;
                sn.nextLine();
            } catch (Throwable ime) {
                System.out.println("Algo errado, tente novamente!");
                excecoes = 1;
                sn.nextLine();
            }

        } while (excecoes != 0);

        System.out.println("Escreva a quantidade:");
        setQuantidade_estoque(sn.nextInt());
        categoria.listarCategoria();
        System.out.print("Insira a categoria: ");
        setIdCategoria(sn.nextInt());

        String sql = "INSERT INTO produto (nome, preco, quantidade_estoque, id_categoria, id_funcionario) VALUES ( '"
                + getNome() + "',"
                + getPreco() + ","
                + getQuantidade_estoque() + ","
                + getIdCategoria() + ","
                + getIdFuncionario() + ")";

        Conexao.executar(sql);
        System.out.println("Produto cadastrado.");

    }

    public void listarProdutos() {
        listarProdutos = Produto.getProdutos();
        for (Produto p : listarProdutos) {
            System.out.println("====================");
            System.out.println("Nome: " + p.getNome());
            System.out.println("Valor: " + p.getPreco());
            System.out.println("Id: " + p.getCodigo());
        }

    }

    public static ArrayList<Produto> getProdutos() {
        ArrayList<Produto> lista = new ArrayList<>();

        String sql = "SELECT id, nome, preco, quantidade_estoque FROM produto ORDER BY nome";

        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {
            try {
                while (rs.next()) {
                    String nome = rs.getString(2);
                    Float preco = rs.getFloat(3);
                    int quantidade_estoque = rs.getInt(4);

                    Produto produto = new Produto(nome, preco, quantidade_estoque);
                    produto.setCodigo(rs.getInt(1));
                    lista.add(produto);
                }
            } catch (Exception e) {
                System.out.println("==>" + e);
            }
        }

        return lista;
    }

    public void comprar(int codigo) {
        String sql = "DELETE FROM produto WHERE id = " + getCodigo();
        Conexao.executar(sql);

    }

    public void editarValor() {
        int excecoes, idProduto;
        float novoPreco;
        produto = new Produto();
        produto.listarProdutos();

        do {
            try {
                System.out.print("Escreva o id do produto que você quer alterar o valor: ");
                idProduto = sn.nextInt();
                if (idProduto < 1) {
                    System.out.println("ID invalido.");
                    excecoes = 1;
                } else {
                    setCodigo(idProduto);
                    excecoes = 0;
                }

                
            } catch (InputMismatchException ae) {
                System.out.println("Letra em lugar de numero! ");
                excecoes = 1;
                sn.nextLine();
            } catch (Throwable ime) {
                System.out.println("Algo errado, tente novamente!");
                excecoes = 1;
                sn.nextLine();
            }
        } while (excecoes != 0);

        do {
            try {
                System.out.print("Digite qual o novo valor do produto: R$ ");
                novoPreco = sn.nextFloat();
                
                if (novoPreco < 0){
                    System.out.println("Valor digitado invalido.");
                    excecoes = 1;
                } else {
                    setPreco(novoPreco);
                    excecoes = 0;
                }
                
            } catch (InputMismatchException ae) {
                System.out.println("Letra em lugar de numero! ");
                excecoes = 1;
                sn.nextLine();
            } catch (Throwable ime) {
                System.out.print("Algo errado, tente novamente!");
                excecoes = 1;
                sn.nextLine();
            }
        } while (excecoes != 0);

        String sql2 = "UPDATE produto SET "
                + " preco = " + getPreco() + " "
                + " WHERE id = " + getCodigo();

        Conexao.executar(sql2);
        System.out.print("O valor foi alterado com sucesso.");
    }

    public void editarNome() {
        int excecoes, idProduto;

        produto = new Produto();
        produto.listarProdutos();
        do {
            try {
                System.out.print("Escreva o id do produto que você quer alterar o nome: ");
                idProduto = sn.nextInt();
                if (idProduto < 1) {
                    System.out.println("ID invalido.");
                    excecoes = 1;
                } else {
                    setCodigo(idProduto);
                    excecoes = 0;
                }

                
            } catch (InputMismatchException ae) {
                System.out.println("Letra em lugar de numero! ");
                excecoes = 1;
                sn.nextLine();
            } catch (Throwable ime) {
                System.out.println("Algo errado, tente novamente!");
                excecoes = 1;
                sn.nextLine();
            }
        } while (excecoes != 0);

        System.out.print("Digite o novo nome do produto:");
        setNome(ss.nextLine());

        String sql2 = "UPDATE produto SET "
                + " nome = '" + getNome() + "' "
                + " WHERE id = " + getCodigo();

        Conexao.executar(sql2);
        System.out.print("O nome do produto foi alterado com sucesso.");
    }

}
