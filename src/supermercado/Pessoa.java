package supermercado;

public class Pessoa implements MostrarDados {

    //Atributos
    private String nome, cpf, senha;

    //Construtor
    public Pessoa(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    //Geters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //Puxando interface
    @Override
    public void mostrarDados() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
    }

}
