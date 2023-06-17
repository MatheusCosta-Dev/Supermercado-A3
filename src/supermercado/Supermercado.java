package supermercado;

public class Supermercado {

    public static void main(String[] args) {
        String nome,email,cpf,telefone,rua,bairro,cidade,cep,senha;
        
        Cliente cliente = new Cliente("aaa","bbbb","ccc","dddd","cccc","ggggg","jjjjjj","yyyyyy");
        cliente.cadastrar();
    }

}
