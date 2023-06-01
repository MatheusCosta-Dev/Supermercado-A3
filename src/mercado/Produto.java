
package mercado;
public class Produto {
  
    private String codigo, nome;
    private float preco;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public void consultar(){
        System.out.println(codigo);
        System.out.println(nome);
        System.out.println(preco);
        
    }
    
    public void cadastroProduto(String codigo, String nome, Float preco){
        setCodigo(codigo);
        setNome(nome);
        setPreco(preco);
    }
    
}



