
package supermercado;

import java.util.Scanner;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Cliente extends Pessoa implements MostrarDados {
    Scanner sn = new Scanner(System.in);
    Scanner ss = new Scanner(System.in);

    // Atributos
    private float saldo;
    private Cliente cliente;

    // Geters e Seters
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    // Construtor
    public Cliente() {

    }

    public Cliente(float saldo) {

        this.saldo = saldo;
    }

    public Cliente(String nome, String email, String senha, String cpf, String telefone, String rua, String bairro,
            String cidade, String cep, float saldo) {
        super(nome, email, senha, cpf, telefone, rua, bairro, cidade, cep);
        this.saldo = saldo;
    }

    // Cadastrando no banco de dados
    public void cadastrar() {
        String sql = "INSERT INTO cliente (nome, email, senha, cpf, telefone, rua, bairro, cidade, cep, saldo) VALUES ( '"
                + getNome() + "','"
                + getEmail() + "','"
                + getSenha() + "','"
                + getCpf() + "','"
                + getTelefone() + "','"
                + getRua() + "','"
                + getBairro() + "','"
                + getCidade() + "','"
                + getCep() + "',"
                + getSaldo() + ")";

        Conexao.executar(sql);
    }

    // Editando dados do cliente
    public void editar() {
        String sql = "UPDATE cliente SET"
                + " nome = '" + getNome() + "', "
                + " email = '" + getEmail() + "', "
                + " senha = '" + getSenha() + "', "
                + " cpf = '" + getCpf() + "', "
                + " telefone = '" + getTelefone() + "', "
                + " rua = '" + getRua() + "', "
                + " bairro = '" + getBairro() + "', "
                + " cidade = '" + getCidade() + "', "
                + " cep = '" + getCep() + " "
                + " WHERE id = '" + getId();

        Conexao.executar(sql);
    }

    public void editarNome() {
        String sql = "UPDATE cliente SET "
                + " nome = '" + getNome() + "' "
                + " WHERE id = " + getId();

        Conexao.executar(sql);
    }

    public void editarSenha() {
        String sql = "UPDATE cliente SET "
                + " senha = '" + getSenha() + "' "
                + " WHERE id = " + getId();

        Conexao.executar(sql);
    }

    public void editarTelefone() {
        String sql = "UPDATE cliente SET "
                + " telefone = '" + getTelefone() + "' "
                + " WHERE id = " + getId();

        Conexao.executar(sql);
    }

    public void editarEndereco() {
        String sql = "UPDATE cliente SET "
                + " rua = '" + getRua() + "', "
                + " bairro = '" + getBairro() + "', "
                + " cidade = '" + getCidade() + "', "
                + " cep = '" + getCep() + "' "
                + " WHERE id = " + getId();

        Conexao.executar(sql);
    }

    public void excluir(int idCliente) {
        String sql = "DELETE FROM cliente WHERE id = " + getId();
        Conexao.executar(sql);
    }

    public static ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> lista = new ArrayList<>();

        String sql = "SELECT id, nome, email, senha, cpf, telefone, rua, bairro, cidade, cep, saldo FROM cliente ORDER BY nome";

        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {
            try {
                while (rs.next()) {
                    String nome = rs.getString(2);
                    String email = rs.getString(3);
                    String senha = rs.getString(4);
                    String cpf = rs.getString(5);
                    String telefone = rs.getString(6);
                    String rua = rs.getString(7);
                    String bairro = rs.getString(8);
                    String cidade = rs.getString(9);
                    String cep = rs.getString(10);
                    Float saldo = rs.getFloat(11);

                    Cliente cliente = new Cliente(nome, email, senha, cpf, telefone, rua, bairro, cidade, cep, saldo);
                    cliente.setId(rs.getInt(1));
                    lista.add(cliente);
                }
            } catch (Exception e) {
                System.out.println("==>" + e);
            }
        }

        return lista;
    }

    @Override
    public void mostrarDados() {
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Cpf: " + getCpf());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Rua: " + getRua());
        System.out.println("Bairro: " + getBairro());
        System.out.println("Cidade: " + getCidade());
        System.out.println("Cep: " + getCep());
        System.out.println("Saldo: R$" + getSaldo());

    }

    public void depositar() {

        String sql = "UPDATE cliente SET "
                + " saldo = " + getSaldo() + " "
                + " WHERE id = " + getId();

        Conexao.executar(sql);
    }

    // Cadastro cliente
    public void cadastrarCliente() {
        int excecoes = 0;

        System.out.println("CADASTRO CLIENTE");
        System.out.print("Digite o seu nome: ");
        setNome(ss.nextLine());
        System.out.print("Digite sua senha: ");
        setSenha(ss.nextLine());
        System.out.print("Digite o Email: ");
        setEmail(ss.nextLine());
        System.out.print("Digite o cpf: ");
        setCpf(ss.nextLine());
        System.out.print("digite o telefone: ");
        setTelefone(ss.nextLine());
        System.out.print("Digite a rua: ");
        setRua(ss.nextLine());
        System.out.print("Digite o bairro: ");
        setBairro(ss.nextLine());
        System.out.print("DIgite a cidade:");
        setCidade(ss.nextLine());
        System.out.print("Digite o cep: ");
        setCep(ss.nextLine());

        do {
            try {
                System.out.print("Digite o saldo: ");
                setSaldo(sn.nextFloat());
                excecoes = 0;
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
        cliente = new Cliente(getNome(), getEmail(), getSenha(), getCpf(), getTelefone(), getRua(), getBairro(),
                getCidade(), getCep(), getSaldo());

        cliente.cadastrar();
        System.out.println("Cliente cadastrado.");

    }

}
