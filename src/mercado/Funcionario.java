package mercado;
public class Funcionario extends Pessoa {
 private String matricula, cargo;
   private Float salario;
   Produto produto;
   
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    @Override
    public void consultarDados() {
        System.out.println(nome);
        System.out.println(CPF);
        System.out.println(matricula);
        System.out.println(salario);
    }

    public void cadastroFuncionario(String nome, String CPF, String matricula, String cargo, Float salario){
        setNome(nome);
        setCPF(CPF);
        setMatricula(matricula);
        setCargo(cargo);
        setSalario(salario);
    }

    
}
