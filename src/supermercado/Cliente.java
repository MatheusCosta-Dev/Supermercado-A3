
package supermercado;

import java.util.Scanner;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Cliente extends Pessoa implements MostrarDados {
    Scanner sn = new Scanner(System.in);
    Scanner ss = new Scanner(System.in);

    // Atributos
    private float saldo;

    // Geters e Seters
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    // Construtor
    public Cliente(String nome, String email, String senha, String cpf, String telefone, String rua, String bairro, String cidade, String cep, float saldo) {
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
    public void editar(){
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

    public static void excluir (int idCliente){
        String sql = "DELETE FROM cliente WHERE id = " + idCliente;
    }

    public static ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> lista = new ArrayList<>();

        String sql = "SELECT id, nome, email, senha, cpf, telefone, rua, bairro, cidade, cep, saldo FROM cliente ORDER BY nome";

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
                    Float saldo = rs. getFloat(11);

                    Cliente cliente = new Cliente (nome, email, senha, cpf, telefone, rua, bairro, cidade, cep, saldo);
                    cliente.setId( rs.getInt(1));
                    lista.add(cliente);
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
        System.out.println("Saldo: " + getSaldo());

    }

    public void depositar(){
        System.out.print("Quanto voce quer depositar? ");
        float vdeposito = sn.nextFloat();
        setSaldo(getSaldo() + vdeposito);

        String sql = "UPDATE cliente SET" 
        + " saldo = '" + getNome() + " "
        + " WHERE id = '" + getId();

        Conexao.executar(sql);
    }


}
