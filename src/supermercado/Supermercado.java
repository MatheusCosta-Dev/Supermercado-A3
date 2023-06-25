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
        ArrayList<Funcionario> listaFuncionarios = new ArrayList();
        String nome, email, senha, cpf, telefone, rua, bairro, cidade, cep;
        float saldo = 0, saldoCliente = 0, salario = 0;
        int cont = 0, opcaoMenu = 0, idCliente = 0, idFuncionario = 0, excecoes = 0, menuCliente = 0,
                menuFuncionario = 0, menuPrincipal = 0,
                opcaoMenuCliente = 0, painelPrincipal = 1, editCliente = 0, editFuncionario = 0, painelFuncionario = 0,
                opcaoMenuFuncionario = 0;
        Cliente cliente;
        Funcionario funcionario;
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
            while (painelPrincipal != 0) {
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
                                                System.out.println("[4] Editar Perfil");
                                                System.out.println("[5] Fechar Painel");
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
                                                    cliente = new Cliente();
                                                    cliente.setSaldo(valorDeposito);
                                                    cliente.setId(idCliente);
                                                    cliente.depositar();
                                                    System.out.println("Deposito realizado com sucesso!");
                                                    System.out.println("Você possui R$" + cliente.getSaldo());
                                                    menuCliente = 1;
                                                    break;
                                                case 3:
                                                    break;
                                                case 4:

                                                    System.out.println("====== Editando Perfil ======");
                                                    System.out.println("[1] Editar Nome");
                                                    System.out.println("[2] Editar Senha");
                                                    System.out.println("[3] Editar Telefone");
                                                    System.out.println("[4] Editar Endereço");
                                                    System.out.println("[5] Excluir");
                                                    do {
                                                        try {
                                                            editCliente = sn.nextInt();
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
                                                    switch (editCliente) {
                                                        case 1:
                                                            cliente = new Cliente();
                                                            cliente.setId(idCliente);
                                                            cliente.editarNome();
                                                            break;
                                                        case 2:
                                                            cliente = new Cliente();
                                                            cliente.setId(idCliente);
                                                            cliente.editarSenha();
                                                            menuCliente = 0;
                                                            menuPrincipal = 0;
                                                            painelPrincipal = 0;
                                                            break;
                                                        case 3:
                                                            cliente = new Cliente();
                                                            cliente.setId(idCliente);
                                                            cliente.editarTelefone();
                                                            break;
                                                        case 4:
                                                            cliente = new Cliente();
                                                            cliente.setId(idCliente);
                                                            cliente.editarEndereco();
                                                            break;
                                                        case 5:
                                                            cliente = new Cliente();
                                                            cliente.setId(idCliente);
                                                            do {
                                                                System.out.println(
                                                                        "Tem certeza que você quer excluir o perfil? S/N");
                                                                String opcaoExcluir = ss.nextLine();
                                                                if (opcaoExcluir.equalsIgnoreCase("S")) {
                                                                    cliente.excluir(idCliente);
                                                                    System.out.println("Excluído com sucesso!");
                                                                    menuCliente = 0;
                                                                    menuPrincipal = 0;
                                                                    painelPrincipal = 0;
                                                                    break; // Sai do loop após exclusão bem-sucedida
                                                                } else if (opcaoExcluir.equalsIgnoreCase("N")) {
                                                                    System.out.println(
                                                                            "Fique tranquilo, não foi excluído!");
                                                                    menuPrincipal = 0;
                                                                } else {
                                                                    System.out.println(
                                                                            "Opção inválida. Por favor, digite S ou N.");
                                                                }
                                                            } while (menuPrincipal != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Opçao invalida.");
                                                            break;
                                                    }

                                                    break;
                                                case 5:
                                                    menuCliente = 0;
                                                    menuPrincipal = 0;
                                                    painelPrincipal = 0;
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
                                    cliente = new Cliente();
                                    cliente.cadastrar();

                                    break;
                            }

                        } while (cont != 0);

                        break;

                    case 2:// Funcionario
                        do {
                            try {
                                System.out.println("[1] Logar \n[2] Registrar");
                                opcaoMenuFuncionario = sn.nextInt();
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
                            switch (opcaoMenuFuncionario) {
                                case 1:// Logar Funcionario

                                    System.out.print("Digite seu email: ");
                                    String veriEmail = ss.nextLine();
                                    System.out.print("Digite sua senha: ");
                                    String veriSenha = ss.nextLine();

                                    listaFuncionarios = Funcionario.getFuncionarios();
                                    for (Funcionario f : listaFuncionarios) {
                                        if (veriEmail.equals(f.getEmail()) && veriSenha.equals(f.getSenha())) {
                                            idFuncionario = f.getId();
                                            loginSucesso = true;
                                        } else {
                                            menuFuncionario = 1;
                                        }

                                    }
                                    if (loginSucesso == true) {
                                        do { // Ja estando logado| Menu Funcionario Logado

                                            try {
                                                System.out.println("\n\n====== MENU FUNCIONARIO ======");
                                                System.out.println("[1] Mostrar Dados");
                                                System.out.println("[2] Cadastrar Produto");
                                                System.out.println("[3] Mostrar Produtos");
                                                System.out.println("[4] Editar Perfil");
                                                System.out.println("[5] Criar categoria de produtos");
                                                System.out.println("[6] Fechar Painel");
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
                                                    listaFuncionarios = Funcionario.getFuncionarios();
                                                    for (Funcionario f : listaFuncionarios) {
                                                        if (idFuncionario == f.getId()) {
                                                            f.mostrarDados();
                                                        }
                                                    }
                                                    menuFuncionario = 1;
                                                    break;
                                                // vai toma no cu
                                                case 2:
                                                    System.out.println("");
                                                    break;
                                                case 3:
                                                    break;
                                                case 4:

                                                    System.out.println("====== Editando Perfil ======");
                                                    System.out.println("[1] Editar Nome");
                                                    System.out.println("[2] Editar Senha");
                                                    System.out.println("[3] Editar Telefone");
                                                    System.out.println("[4] Editar Endereço");
                                                    System.out.println("[5] Excluir");
                                                    do {
                                                        try {
                                                            editFuncionario = sn.nextInt();
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
                                                    switch (editFuncionario) {
                                                        case 1:
                                                            System.out.print("Digite o novo nome: ");
                                                            nome = ss.nextLine();
                                                            funcionario = new Funcionario();
                                                            funcionario.setNome(nome);
                                                            funcionario.setId(idFuncionario);
                                                            funcionario.editarNome();

                                                            break;
                                                        case 2:
                                                            System.out.print("Digite sua nova senha: ");
                                                            senha = ss.nextLine();
                                                            funcionario = new Funcionario();
                                                            funcionario.setSenha(senha);
                                                            funcionario.setId(idFuncionario);
                                                            funcionario.editarSenha();
                                                            break;
                                                        case 3:
                                                            System.out.print("Digite seu novo telefone: ");
                                                            telefone = ss.nextLine();
                                                            funcionario = new Funcionario();
                                                            funcionario.setTelefone(telefone);
                                                            funcionario.setId(idFuncionario);
                                                            funcionario.editarTelefone();
                                                            break;
                                                        case 4:
                                                            System.out.print("Digite a Rua: ");
                                                            rua = ss.nextLine();
                                                            System.out.print("Digite o Bairro: ");
                                                            bairro = ss.nextLine();
                                                            System.out.print("Digite a Cidade: ");
                                                            cidade = ss.nextLine();
                                                            System.out.print("Digite o Cep: ");
                                                            cep = ss.nextLine();

                                                            funcionario = new Funcionario();
                                                            funcionario.setRua(rua);
                                                            funcionario.setBairro(bairro);
                                                            funcionario.setCidade(cidade);
                                                            funcionario.setCep(cep);
                                                            funcionario.setId(idFuncionario);
                                                            funcionario.editarEndereco();
                                                            break;
                                                        case 5:
                                                            funcionario = new Funcionario();
                                                            funcionario.setId(idFuncionario);
                                                            do {
                                                                System.out.println(
                                                                        "Tem certeza que você quer excluir o perfil? S/N");
                                                                String opcaoExcluir = ss.nextLine();
                                                                if (opcaoExcluir.equalsIgnoreCase("S")) {
                                                                    funcionario.excluir(idFuncionario);
                                                                    System.out.println("Excluído com sucesso!");
                                                                    menuFuncionario = 0;
                                                                    menuPrincipal = 0;
                                                                    painelPrincipal = 0;
                                                                    break; // Sai do loop após exclusão bem-sucedida
                                                                } else if (opcaoExcluir.equalsIgnoreCase("N")) {
                                                                    System.out.println(
                                                                            "Fique tranquilo, não foi excluído!");
                                                                    menuPrincipal = 0;
                                                                } else {
                                                                    System.out.println(
                                                                            "Opção inválida. Por favor, digite S ou N.");
                                                                }
                                                            } while (menuPrincipal != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Opçao invalida.");
                                                            break;
                                                    }

                                                    break;
                                                case 5:
                                                    menuFuncionario = 0;
                                                    menuPrincipal = 0;
                                                    painelFuncionario = 0;
                                                    break;
                                                default:
                                                    break;
                                            }
                                        } while (menuFuncionario != 0);
                                        break;
                                    } else {
                                        System.out.println("Email ou senha incorretos. Tente novamente.");
                                    }
                                    break;

                                case 2:// Registrar Funcionario
                                    System.out.println("CADASTRO FUNCIONARIO");
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
                                            System.out.print("Digite o salario: ");
                                            salario = sn.nextFloat();
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
                                    funcionario = new Funcionario(nome, email, senha, cpf, telefone, rua, bairro,
                                            cidade, cep,
                                            salario);
                                    funcionario.cadastrar();
                                    System.out.println("Funcionario cadastrado.");
                                    painelFuncionario = 1;
                                    break;
                            }

                        } while (cont != 0);
                        break;

                    case 3: // Sair
                        menuPrincipal = 0;
                        painelPrincipal = 0;
                        break;

                }

            }

        } while (menuPrincipal != 0);

    }

}
