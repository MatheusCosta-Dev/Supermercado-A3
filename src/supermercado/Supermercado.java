package supermercado;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Supermercado {

    public static void main(String[] args) {
        //Scanners
        Scanner ss = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);
        
        //Varivais
        String nome, email, senha, cpf, telefone, rua, bairro, cidade, cep;
        float saldo = 0;
        int erro, cont = 0, opcaoMenu = 0;

        do { // Menu principal
            do {
                try {
                    System.out.println("[1] Cliente \n[2] Funcionario \n[3] Sair");
                    opcaoMenu = sn.nextInt();
                    erro = 0;
                } catch (InputMismatchException ae) {
                    System.out.println("Letra em lugar de numero! ");
                    erro = 1;
                    sn.nextLine();
                } catch (Throwable ime) {
                    System.out.println("Algo errado, tente novamente!");
                    erro = 1;
                    sn.nextLine();
                }
            } while (erro != 0);

            switch (opcaoMenu) {
                case 1: // Opção Cliente
                    // Menu Login ou Cadastro
                    do {
                        try {
                            System.out.println("[1] Logar \n[2] Registrar");
                            opcaoMenu = sn.nextInt();
                            erro = 0;
                        } catch (InputMismatchException ae) {
                            System.out.println("Letra em lugar de numero! ");
                            erro = 1;
                            sn.nextLine();
                        } catch (Throwable ime) {
                            System.out.println("Algo errado, tente novamente!");
                            erro = 1;
                            sn.nextLine();
                        }
                    } while (erro != 0);

                    do {
                        switch (opcaoMenu) {
                            case 1:// Logar Cliente
                            /*Ajuda para fazer login consultando o banco


                            */

                            do { // Ja estando logado| Menu Cliente Logado
                        try {
                            System.out.println("[1] Mostrar Dados \n[2] Depositar Saldo \n[3] Comprar Produtos \n[4] Fechar Painel");
                            opcaoMenu = sn.nextInt();
                            erro = 0;
                        } catch (InputMismatchException ae) {
                            System.out.println("Letra em lugar de numero! ");
                            erro = 1;
                            sn.nextLine();
                        } catch (Throwable ime) {
                            System.out.println("Algo errado, tente novamente!");
                            erro = 1;
                            sn.nextLine();
                        }
                    } while (erro != 0);



                            break;

                            case 2:// Registrar Cliente
                                System.out.println("CADASTRO CLIENTE");
                                System.out.print("Digite o seu Nome: ");
                                nome = ss.nextLine();
                                System.out.print("Digite sua senha: ");
                                senha = ss.nextLine();
                                System.out.print("Digite o Email: ");
                                email = ss.nextLine();
                                System.out.print("Digite o Cpf: ");
                                cpf = ss.nextLine();
                                System.out.print("Digite o Telefone: ");
                                telefone = ss.nextLine();
                                System.out.print("Digite a Rua: ");
                                rua = ss.nextLine();
                                System.out.print("Digite o Bairro: ");
                                bairro = ss.nextLine();
                                System.out.print("Digite a Cidade: ");
                                cidade = ss.nextLine();
                                System.out.print("Digite o Cep: ");
                                cep = ss.nextLine();
                                do {
                                    try {
                                        System.out.print("Digite o saldo: ");
                                        saldo = sn.nextFloat();
                                        erro = 0;
                                    } catch (InputMismatchException ae) {
                                        System.out.println("Letra em lugar de numero! ");
                                        erro = 1;
                                        sn.nextLine();
                                    } catch (Throwable ime) {
                                        System.out.println("Algo errado, tente novamente!");
                                        erro = 1;
                                        sn.nextLine();
                                    }
                                } while (erro != 0);
                                Cliente cliente = new Cliente(nome, email, senha, cpf, telefone, rua, bairro, cidade,
                                        cep, saldo);
                                cliente.cadastrar();

                            break;
                        }
                    } while (cont != 0);

                break;

                case 2:// Funcionario
                break;

                case 3: //Sair
                cont = 0;
                break;
            }
        } while (cont != 0);

    }

}
