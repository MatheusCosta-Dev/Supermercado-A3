package supermercado;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Categoria {

    ArrayList<Categoria> listaCategorias = new ArrayList();

    Scanner ss = new Scanner(System.in);
    Scanner sn = new Scanner(System.in);

    private String nome;
    private int id, idFuncionario;
    private Categoria categoria;

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

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Categoria() {
    }

    public Categoria(String nome, int idFuncionario) {
        this.nome = nome;
        this.idFuncionario = idFuncionario;
    }

    public void cadastrarCategoria() {
        System.out.print("Digite o nome: ");

        setNome(ss.nextLine());

        String sql = "INSERT INTO categoria (nome, id_funcionario) VALUES ( '"
                + getNome() + "',"
                + getIdFuncionario() + ")";

        Conexao.executar(sql);
        System.out.println("Categoria cadastrado.");
    }

    public void listarCategoria() {
        listaCategorias = Categoria.getCategoria();
        for (Categoria c : listaCategorias) {
            System.out.println("=======================");
            System.out.println("nome: " + c.getNome());
            System.out.println("Id: " + c.getId());
        }
    }

    public static ArrayList<Categoria> getCategoria() {
        ArrayList<Categoria> lista = new ArrayList<>();

        String sql = "SELECT id, nome, id_funcionario FROM categoria ORDER BY id";

        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {
            try {
                while (rs.next()) {
                    String nome = rs.getString(2);
                    int id_funcionario = rs.getInt(3);

                    Categoria categoria = new Categoria(nome, id_funcionario);
                    categoria.setId(rs.getInt(1));
                    lista.add(categoria);
                }
            } catch (Exception e) {
                System.out.println("==>" + e);
            }
        } 

        return lista;
    }

    public void editarNome() {
        int excecoes, idCategoria;

        categoria = new Categoria();
        categoria.listarCategoria();
        do {
            try {
                System.out.print("Escreva o id da categoria que você quer alterar o nome: ");
                idCategoria = sn.nextInt();
                if (idCategoria < 1) {
                    System.out.println("ID invalido.");
                    excecoes = 1;
                } else {
                    setId(idCategoria);
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

        System.out.print("Digite o novo nome da categoria:");
        setNome(ss.nextLine());

        String sql2 = "UPDATE categoria SET "
                + " nome = '" + getNome() + "' "
                + " WHERE id = " + getId();

        Conexao.executar(sql2);
        System.out.print("O nome da categoria foi alterado com sucesso.");
    }

}
