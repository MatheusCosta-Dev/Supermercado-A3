package supermercado;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Funcionario extends Pessoa implements MostrarDados{
    Scanner sn = new Scanner(System.in);
    Scanner ss = new Scanner(System.in);

    // Atributos
    private float salario;
    private Funcionario funcionario;

    // Geters e Seters
    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    // Construtor
    public Funcionario(String nome, String email, String senha, String cpf, String telefone, String rua, String bairro, String cidade, String cep, float salario) {
        super(nome, email, senha, cpf, telefone, rua, bairro, cidade, cep);
        this.salario = salario;
    }

    public Funcionario() {
    }

    

    // Cadastrando no banco de dados
    public void cadastrar() {
        int excecoes = 0;

        System.out.println("CADASTRO FUNCIONARIO");
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
                setSalario(sn.nextFloat());
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
        funcionario = new Funcionario(getNome(), getEmail(), getSenha(), getCpf(), getTelefone(), getRua(), getBairro(),
                getCidade(), getCep(), getSalario());

        String sql = "INSERT INTO funcionario (nome, email, senha, cpf, telefone, rua, bairro, cidade, cep, salario) VALUES ( '" 
        + getNome() + "','" 
        + getEmail() + "','" 
        + getSenha() + "','" 
        + getCpf() + "','" 
        + getTelefone() + "','" 
        + getRua() + "','" 
        + getBairro() + "','" 
        + getCidade() + "','" 
        + getCep() + "'," 
        + getSalario() + ")";

        Conexao.executar(sql);

        System.out.println("Funcionario cadastrado!");
    }

    // Editando dados do funcionario
    public void editar(){
        String sql = "UPDATE funcionario SET" 
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

        String sql = "UPDATE funcionario SET "
                + " nome = '" + getNome() + "' "
                + " WHERE id = " + getId();

        Conexao.executar(sql);

        System.out.println("Nome alterado com sucesso!");
    }

    public void editarTelefone() {
        System.out.print("Digite seu novo telefone: ");
        setTelefone(ss.nextLine());
        String sql = "UPDATE funcionario SET "
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

        String sql = "UPDATE funcionario SET "
                + " rua = '" + getRua() + "', "
                + " bairro = '" + getBairro() + "', "
                + " cidade = '" + getCidade() + "', "
                + " cep = '" + getCep() + "' "
                + " WHERE id = " + getId();

        Conexao.executar(sql);

        System.out.println("Endereço alterado com sucesso...");
    }

    public void editarSenha() {
        System.out.print("Digite sua nova senha: ");
        setSenha(ss.nextLine());

        String sql = "UPDATE funcionario SET "
                + " senha = '" + getSenha() + "' "
                + " WHERE id = " + getId();

        Conexao.executar(sql);

        System.out.println("Senha alterada com sucesso, faça login novamente.");
    }

    public void excluir (int idFuncionario){
        String sql = "DELETE FROM funcionario WHERE id = " + getId();
        Conexao.executar(sql);
    }

    public static ArrayList<Funcionario> getFuncionarios(){
        ArrayList<Funcionario> lista = new ArrayList<>();

        String sql = "SELECT id, nome, email, senha, cpf, telefone, rua, bairro, cidade, cep, salario FROM funcionario ORDER BY nome";

        ResultSet rs = Conexao.consultar( sql );

        if (rs != null){
            try{
                while ( rs.next()){
                    String nome = rs. getString(2);
                    String email = rs. getString(3);
                    String senha = rs. getString(4);
                    String cpf = rs. getString(5);
                    String telefone = rs. getString(6);
                    String rua = rs. getString(7);
                    String bairro = rs. getString(8);
                    String cidade = rs. getString(9);
                    String cep = rs. getString(10);
                    Float salario = rs. getFloat(11);

                    Funcionario funcionario = new Funcionario (nome, email, senha, cpf, telefone, rua, bairro, cidade, cep, salario);
                    funcionario.setId( rs.getInt(1));
                    lista.add(funcionario);
                }
            }catch ( Exception e) {
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
        System.out.println("Salario: R$" + getSalario());

    }

}
