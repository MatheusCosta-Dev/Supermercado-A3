package mercado;

import java.util.ArrayList;
import java.util.Scanner;

public class Mercado {
    public static void main(String[] args) {
        ArrayList<Funcionario> trabalhadores = new ArrayList();  
        ArrayList<Cliente> consumidores = new ArrayList();
        ArrayList<Produto> estoque = new ArrayList();
        
        int cont=0;
        int escolha;
        Scanner ler = new Scanner(System.in);
        while(cont==0){
            System.out.println("=_=_=_=_=_=_=_=_=_=_= Menu =_=_=_=_=_=_=_=_=_=_=");
            System.out.println("1- Cadastrar funcionario");
            System.out.println("2- Cadastrar cliente");
            System.out.println("3- Cadastrar produto");
            System.out.println("4- Consultar funcionários");
            escolha = ler.nextInt();
             Funcionario f = new Funcionario();
               Cliente c = new Cliente();
               Produto p = new Produto();
             
            switch(escolha){
                case 1: 
                    String nomef, CPFf, matriculaf, cargof;
                    Float salariof;
                   
                    System.out.println("Digite o nome do funcionário");
                    ler.next();
                    nomef = ler.nextLine();
                    System.out.println("Digite o CPF do funcionário");
                    CPFf = ler.nextLine();
                    System.out.println("Digite matricula do funcionário");
                    matriculaf = ler.nextLine();
                    System.out.println("Digite o cargo do funcionário");
                    cargof = ler.nextLine();
                    System.out.println("Digite o salário do funcionário");
                    salariof = ler.nextFloat();
                    f.cadastroFuncionario(nomef, CPFf, matriculaf, cargof, salariof);
                    trabalhadores.add(f);
                break;
                case 2: 
                    String nomec, CPFc, idc;
                    Float saldoc;                  
                    System.out.println("Digite o nome do cliente");
                    ler.next();
                    nomec = ler.nextLine();
                    System.out.println("Digite o CPF do cliente");
                    CPFc = ler.nextLine();
                    System.out.println("Digite o id do cliente");
                    idc = ler.nextLine();
                    System.out.println("Digite o saldo do cliente");
                    saldoc = ler.nextFloat();
                    c.cadastroCliente(nomec, CPFc, idc, saldoc);
                    consumidores.add(c);
                break;
                case 3:
                    String codigop, nomep;
                    Float precop;
                   System.out.println("Digite o código do produto");
                   ler.next();
                   codigop = ler.nextLine();
                   System.out.println("Digite o nome do produto");
                   nomep = ler.nextLine();
                    System.out.println("Digite o preço do produto");
                    precop = ler.nextFloat();
                    p.cadastroProduto(codigop, nomep, precop);
                    estoque.add(p);
                break;
                case 4:
                    if(trabalhadores.isEmpty()) System.out.println("Nenhum funcionário cadastrado");
                    else{
                        for(Funcionario fx:trabalhadores){
                            f.consultarDados();
                        }
                            
                    }
            
            
            }



    }
    
}
}