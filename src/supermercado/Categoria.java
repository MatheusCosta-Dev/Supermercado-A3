package supermercado;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Categoria {

    ArrayList<Categoria> listaCategorias = new ArrayList();

    Scanner ss = new Scanner(System.in);
    private String nome;
    private int id, idFuncionario;

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

}
