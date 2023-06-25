package supermercado;

import java.util.Scanner;

public class Pessoa {
    Scanner ss = new Scanner(System.in);

    // Atributos
    private int id;
    private String nome, email, senha, cpf, telefone, rua, bairro, cidade, cep;

    // Geters e Seters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    // Construtor
    public Pessoa(String nome, String email, String senha, String cpf, String telefone, String rua, String bairro,
            String cidade, String cep) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }

    public Pessoa() {
    }
/* 
    public void editarNome() {
        System.out.print("Digite o novo nome: ");
        setNome(ss.nextLine());
    }

    public void editarSenha() {
        System.out.print("Digite sua nova senha: ");
        setSenha(ss.nextLine());
    }

    public void editarTelefone() {
        System.out.print("Digite seu novo telefone: ");
        setTelefone(ss.nextLine());
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
    }
    */
}
