package supermercado;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente extends Pessoa implements MostrarDados {

    Scanner sn = new Scanner(System.in);
    Scanner ss = new Scanner(System.in);

    // Atributos
    private float saldo;
    private Cliente cliente;
    private Produto produto;
    private int codigo;

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
        int excecoes = 0;

        float saldoCliente;

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
                System.out.print("Digite o saldo: R$ ");
                saldoCliente = sn.nextFloat();
                if (saldoCliente < 0) {
                    System.out.println("Valor inserido é um valor negativo, ponha um valor valido {0, infinito}");
                    excecoes = 1;
                } else {
                    setSaldo(saldoCliente);
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
        cliente = new Cliente(getNome(), getEmail(), getSenha(), getCpf(), getTelefone(), getRua(), getBairro(),
                getCidade(), getCep(), getSaldo());

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
        System.out.println("Cliente cadastrado.");
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
        System.out.print("Digite o novo nome: ");
        setNome(ss.nextLine());

        String sql = "UPDATE cliente SET "
                + " nome = '" + getNome() + "' "
                + " WHERE id = " + getId();

        Conexao.executar(sql);

        System.out.println("Nome alterado com sucesso!");
    }

    public void editarSenha() {
        System.out.print("Digite sua nova senha: ");
        setSenha(ss.nextLine());

        String sql = "UPDATE cliente SET "
                + " senha = '" + getSenha() + "' "
                + " WHERE id = " + getId();

        Conexao.executar(sql);

        System.out.println("Senha alterada com sucesso, faça login novamente.");
    }

    public void editarTelefone() {
        System.out.print("Digite seu novo telefone: ");
        setTelefone(ss.nextLine());
        String sql = "UPDATE cliente SET "
                + " telefone = '" + getTelefone() + "' "
                + " WHERE id = " + getId();

        Conexao.executar(sql);

        System.out.println("Telefone alterado com sucesso!");
    }

    public void editarEndereco() {
        System.out.print("Digite a Rua: ");
        setRua(ss.nextLine());
        System.out.print("Digite o Bairro: ");
        setBairro(ss.nextLine());
        System.out.print("Digite a Cidade: ");
        setCidade(ss.nextLine());
        System.out.print("Digite o Cep: ");
        setCep(ss.nextLine());

        String sql = "UPDATE cliente SET "
                + " rua = '" + getRua() + "', "
                + " bairro = '" + getBairro() + "', "
                + " cidade = '" + getCidade() + "', "
                + " cep = '" + getCep() + "' "
                + " WHERE id = " + getId();

        Conexao.executar(sql);

        System.out.println("Endereço alterado com sucesso...");
    }

    public void excluir(int idCliente) {
        String sql = "DELETE FROM cliente WHERE id = " + getId();
        Conexao.executar(sql);

    }

    // Método para buscar dados do banco
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
        System.out.println("====== DADOS ======");
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Cpf: " + getCpf());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Rua: " + getRua());
        System.out.println("Bairro: " + getBairro());
        System.out.println("Cidade: " + getCidade());
        System.out.println("Cep: " + getCep());
        System.out.println("Saldo: R$" + getSaldo());
        System.out.println("===================");

    }

    public void depositar() {
        ArrayList<Cliente> listaClientes = new ArrayList();
        float saldoCliente, valorDeposito = 0;

        int excecoes = 0;
        do {
            try {
                System.out.print("Quanto você quer depositar? R$ ");
                valorDeposito = sn.nextFloat();
                if (valorDeposito < 0) {
                    System.out.println("Digite um valor valido!");
                    excecoes = 1;
                } else {
                    excecoes = 0;
                }

            } catch (InputMismatchException ae) {
                System.out.println("Letra em lugar de número! ");
                excecoes = 1;
                sn.nextLine();
            } catch (Throwable ime) {
                System.out.println("Algo errado, tente novamente!");
                excecoes = 1;
                sn.nextLine();
            }
        } while (excecoes != 0);
        listaClientes = Cliente.getClientes();
        for (Cliente c : listaClientes) {
            if (getId() == c.getId()) {
                saldoCliente = c.getSaldo();
                setSaldo(valorDeposito + saldoCliente);
            }

            String sql = "UPDATE cliente SET "
                    + " saldo = " + getSaldo() + " "
                    + " WHERE id = " + getId();

            Conexao.executar(sql);
        }

    }

    public void comprarProduto() {
        ArrayList<Produto> listaProdutos = new ArrayList();
        ArrayList<Cliente> listaClientes = new ArrayList();

        float precoProduto = 0, saldoCliente = 0;
        int excecoes = 0, idPedido = 0, qtdProdutos = 0, idProduto = 0;
        produto = new Produto();

        produto.listarProdutos();

        do {
            try {
                System.out.print("Qual o ID do pedido que você quer comprar?  ");
                idPedido = sn.nextInt();
                if (idPedido < 1) {
                    System.out.println("ID invalida.");
                    excecoes = 1;
                } else {
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

        listaClientes = Cliente.getClientes();
        for (Cliente c : listaClientes) {
            if (getId() == c.getId()) {
                saldoCliente = c.getSaldo();
            }
        }

        listaProdutos = Produto.getProdutos();
        for (Produto p : listaProdutos) {
            if (idPedido == p.getCodigo()) {
                idProduto = p.getCodigo();
                precoProduto = p.getPreco();
                qtdProdutos = p.getQuantidade_estoque();
            }
        }
        if (qtdProdutos > 0 && precoProduto < saldoCliente) {
            setSaldo(saldoCliente - precoProduto);
            qtdProdutos = qtdProdutos - 1;
            System.out.println(qtdProdutos);

            String sql = "UPDATE cliente SET "
                    + " saldo = " + getSaldo() + " "
                    + " WHERE id = " + getId();

            Conexao.executar(sql);

            String sql2 = "UPDATE produto SET "
                    + " quantidade_estoque = " + qtdProdutos + " "
                    + " WHERE id = " + idProduto;

            Conexao.executar(sql2);
            System.out.println("Pedido comprado.");

        } else if (precoProduto > saldoCliente) {
            System.out.println("Você não tem saldo suficiente!");
        } else {
            System.out.println("Produto sem estoque no momento.");
        }
    }
}
