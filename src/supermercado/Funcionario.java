package supermercado;

public class Funcionario extends Pessoa {

    //Atributos
    private String cargo;
    private int matricula;
    private float salario;
    private Produto produto;

    //Geters e setters

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    //Construtor

    public Funcionario(int matricula, String cargo, float salario, String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        this.matricula = matricula;
        this.cargo = cargo;
        this.salario = salario;

    }

    // Método herança

    @Override
    public void mostrarDados() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Matricula: " + getMatricula());
        System.out.println("Cargo: " + getCargo());
        System.out.println("Salario: " + getSalario());
    }
}
