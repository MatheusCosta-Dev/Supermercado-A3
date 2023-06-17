
package supermercado;

public class Cliente extends Pessoa {
    private String email, cpf;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cliente(String email, String cpf, String nome, String telefone, String rua, String bairro, String cidade, String cep) {
        super(nome, telefone, rua, bairro, cidade, cep);
        this.email = email;
        this.cpf = cpf;
    }
    
    public void cadastrar(){
        String sql = "INSERT INTO cliente (nome,email,cpf,telefone,rua,bairro,cidade,cep,senha) VALUES ( '" + getNome() + "','" + getEmail() + "','" + 
                getCpf() + "','" + getTelefone() + "','" + getRua() + 
                "','" + getBairro() + "','" + getCidade() + "','" + getCep() + "','" + getSenha()+ "')";
        
        Conexao.executar( sql );
    }
}
