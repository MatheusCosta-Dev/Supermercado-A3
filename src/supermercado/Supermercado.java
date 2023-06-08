package supermercado;

import java.util.Scanner;

public class Supermercado {
    public static void main(String[] args) {
        //Scanners
        Scanner ss = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);
        
        //arreylist


        //Variaveis
        int opcao=0;
        boolean sair=true;

        do{
            System.out.println("1-Cliente \n2-Funcionario");
            System.out.println("Escolha uma opção: ");
            opcao = sn.nextInt();
            switch(opcao){
                case 1:  
                    do {
                        System.out.println("1-Logar \n2-Registrar");
                        System.out.println("Escolha uma opção:");
                        opcao = sn.nextInt();

                        switch(opcao){
                            case 1: 
                            System.out.println("Qual seu nome:");
                            String nome = ss.nextLine();
                            System.out.println("Qual sua senha:");
                            String senha = sn.nextLine();

                            if(nome.equals(getNome())){
                                System.out.println("ta certo");
                            }else{System.out.println("ta errado");}
                            break;
                            case 2:
                            System.out.println("id:");
                            int id = sn.nextInt();
                            System.out.println("saldo:");
                            float saldo = sn.nextFloat();
                            System.out.println("nome:");
                            nome = ss.nextLine();
                            System.out.println("cpf:");
                            String cpf = ss.nextLine();
                            System.out.println("senha:");
                            senha = ss.nextLine();
                            

                            Cliente c = new Cliente(id, saldo, nome, cpf, senha);
                            break;
                        }
                    } while (sair==true);
                break;

                case 2:
                break;
            }
        }while(sair==true);
        





    }
}
