package supermercado;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Supermercado {

    public static void main(String[] args) {
        // Scanner
        Scanner ss = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);

        // Arrays List
        ArrayList<Cliente> listaClientes = new ArrayList();
        String nome, email, senha, cpf, telefone, rua, bairro, cidade, cep;
        float saldo = 0, saldoCliente = 0;
        int cont = 0, opcaoMenu = 0, idCliente = 0, excecoes = 0, menuCliente = 0, menuPrincipal = 0, opcaoMenuCliente = 0, painelCliente = 1;
        Cliente cliente;
        boolean loginSucesso = false;

        do { // Menu principal
            do {
                try {
                    System.out.println("[1] Cliente \n[2] Funcionario \n[3] Sair");
                    opcaoMenu = sn.nextInt();
                    excecoes = 0;
                } catch (InputMismatchException ae) {
                    System.out.println("Letra em lugar de numero! ");
                    excecoes = 1;
                    sn.nextLine();
                } catch (Throwable ime) {
                    System.out.println("Algo errado, tente novamente!");
                    excecoes = 1;
                    sn.nextLine();
                }
                if (opcaoMenu == 1 || opcaoMenu == 2 || opcaoMenu == 3) {
                    excecoes = 0;
                } else {
                    System.out.println("Opçao invalida!");
                    excecoes = 1;
                }
                
            } while (excecoes != 0);
            while (painelCliente != 0) {
                switch (opcaoMenu) {
                    case 1: // Opção Cliente
                        // Menu Login ou Cadastro
                        do {
                            try {
                                System.out.println("[1] Logar \n[2] Registrar");
                                opcaoMenuCliente = sn.nextInt();
                                excecoes = 0;
                            } catch (InputMismatchException ae) {
                                System.out.println("Letra em lugar de numero! ");
                                excecoes = 1;
                                sn.nextLine();
                            } catch (Throwable ime) {
                                System.out.println("Algo errado, tente novamente!");
                                excecoes = 1;
                                sn.nextLine();
                            }
                            if (opcaoMenu == 1 || opcaoMenu == 2) {
                                excecoes = 0;
                            } else {
                                excecoes = 1;
                            }
                        } while (excecoes != 0);

                        do {
                            switch (opcaoMenuCliente) {
                                case 1:// Logar Cliente

                                    System.out.print("Digite seu email: ");
                                    String veriEmail = ss.nextLine();
                                    System.out.print("Digite sua senha: ");
                                    String veriSenha = ss.nextLine();

                                    listaClientes = Cliente.getClientes();
                                    for (Cliente c : listaClientes) {
                                        if (veriEmail.equals(c.getEmail()) && veriSenha.equals(c.getSenha())) {
                                            idCliente = c.getId();
                                            saldoCliente = c.getSaldo();
                                            loginSucesso = true;
                                        } else {
                                            menuCliente = 1;
                                        }

                                    }
                                    if (loginSucesso == true) {
                                        do { // Ja estando logado| Menu Cliente Logado

                                            try {
                                                System.out.println("\n\n====== MENU CLIENTE ======");
                                                System.out.println("[1] Mostrar Dados");
                                                System.out.println("[2] Depositar Saldo");
                                                System.out.println("[3] Comprar Produtos");
                                                System.out.println("[4] Fechar Painel");
                                                opcaoMenu = sn.nextInt();
                                                excecoes = 0;
                                            } catch (InputMismatchException ae) {
                                                System.out.println("Letra em lugar de numero! ");
                                                excecoes = 1;
                                                sn.nextLine();
                                            } catch (Throwable ime) {
                                                System.out.println("Algo errado, tente novamente!");
                                                excecoes = 1;
                                                sn.nextLine();
                                            }

                                            switch (opcaoMenu) {
                                                case 1:
                                                    listaClientes = Cliente.getClientes();
                                                    for (Cliente c : listaClientes) {
                                                        if (idCliente == c.getId()) {
                                                            c.mostrarDados();
                                                        }
                                                    }
                                                    menuCliente = 1;
                                                    break;
                                                case 2:
                                                    float valorDeposito = 0;
                                                    do {
                                                        try {
                                                            System.out.print("Quanto voce quer depositar? R$ ");
                                                            valorDeposito = sn.nextFloat();
                                                            excecoes = 0;
                                                        } catch (InputMismatchException ae) {
                                                            System.out.println("Letra em lugar de numero! ");
                                                            excecoes = 1;
                                                            sn.nextLine();
                                                        } catch (Throwable ime) {
                                                            System.out.println("Algo errado, tente novamente!");
                                                            excecoes = 1;
                                                            sn.nextLine();
                                                        }
                                                    } while (excecoes != 0);
                                                    valorDeposito += saldoCliente;
                                                    cliente = new Cliente(valorDeposito);
                                                    cliente.setId(idCliente);
                                                    cliente.depositar();
                                                    menuCliente = 1;
                                                    break;
                                                case 3:
                                                    break;
                                                case 4:
                                                    menuCliente = 0;
                                                    menuPrincipal = 0;
                                                    painelCliente = 0;
                                                    break;
                                                default:
                                                    break;
                                            }
                                        } while (menuCliente != 0);
                                        break;
                                    } else {
                                        System.out.println("Email ou senha incorretos. Tente novamente.");
                                    }
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
                                            excecoes = 0;
                                        } catch (InputMismatchException ae) {
                                            System.out.println("Letra em lugar de numero! ");
                                            excecoes = 1;
                                            sn.nextLine();
                                        } catch (Throwable ime) {
                                            System.out.println("Algo errado, tente novamente!");
                                            excecoes = 1;
                                            sn.nextLine();
                                        }
                                    } while (excecoes != 0);
                                    cliente = new Cliente(nome, email, senha, cpf, telefone, rua, bairro, cidade, cep,
                                            saldo);
                                    cliente.cadastrar();
                                    System.out.println("Cliente cadastrado.");
                                    painelCliente = 1;
                                    break;
                            }

                        } while (cont != 0);

                        break;

                    case 2:// Funcionario
                        break;

                    case 3: // Sair
                        menuPrincipal = 0;
                        painelCliente = 0;
                        break;

                }

            }

        } while (menuPrincipal != 0);

    }

}
