package supermercado;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Pessoa implements MostrarDados{
    Scanner sn = new Scanner(System.in);
    Scanner ss = new Scanner(System.in);

    // Atributos
    private float salario;

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
        String sql = "UPDATE funcionario SET "
                + " nome = '" + getNome() + "' "
                + " WHERE id = " + getId();

        Conexao.executar(sql);
    }

    public void editarTelefone() {
        String sql = "UPDATE funcionario SET "
                + " telefone = '" + getTelefone() + "' "
                + " WHERE id = " + getId();

        Conexao.executar(sql);
    }

    public void editarEndereco() {
        String sql = "UPDATE funcionario SET "
                + " rua = '" + getRua() + "', "
                + " bairro = '" + getBairro() + "', "
                + " cidade = '" + getCidade() + "', "
                + " cep = '" + getCep() + "' "
                + " WHERE id = " + getId();

        Conexao.executar(sql);
    }

    public void editarSenha() {
        String sql = "UPDATE funcionario SET "
                + " senha = '" + getSenha() + "' "
                + " WHERE id = " + getId();

        Conexao.executar(sql);
    }

    public void excluir (int idFuncionario){
        String sql = "DELETE FROM funcionario WHERE id = " + getId();
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
