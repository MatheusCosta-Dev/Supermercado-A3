package supermercado;

import java.util.ArrayList;
import java.util.Scanner;

public class Supermercado {

    public static void main(String[] args) {

        // Scanners
        Scanner ss = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);

        // Variaveis
        int matricula, id, codigo;
        String nome, cpf, cargo;
        float salario, saldo, preco;
        boolean sairMenuPrincipal = true;

        // Array list
        ArrayList<Cliente> clientes = new ArrayList();
        ArrayList<Funcionario> funcionarios = new ArrayList();
        ArrayList<Produto> produtos = new ArrayList();

        do {

            // Menu principal
            sairMenuPrincipal = true;
            System.out.println("[1] - Cadastrar cliente");
            System.out.println("[2] - Cadastrar funcionario");
            System.out.println("[3] - Selecionar cliente");
            System.out.println("[4] - Selecionar funcionario");
            System.out.println("[5] - Sair");
            int menu = sn.nextInt();
            switch (menu) {
                case 1:

                    // Cadastro de clientes
                    System.out.println("CADASTRAR CLIENTE");
                    System.out.print("Digite seu nome: ");
                    nome = ss.nextLine();
                    System.out.print("Digite seu CPF: ");
                    cpf = ss.nextLine();
                    System.out.print("Digite seu saldo: R$ ");
                    saldo = sn.nextFloat();
                    System.out.print("Digite seu ID: ");
                    id = sn.nextInt();

                    // Criando objeto de cliente
                    Cliente cliente = new Cliente(id, saldo, nome, cpf);

                    // Adicionando ao arrayList de clientes
                    clientes.add(cliente);
                    break;
                case 2:

                    // Cadastro de funcionarios
                    System.out.println("CADASTRAR FUNCIONARIO");
                    System.out.print("Digite o nome do funcionario: ");
                    nome = ss.nextLine();
                    System.out.print("Digite o CPF: ");
                    cpf = ss.nextLine();
                    System.out.print("Digite a matricula: ");
                    matricula = sn.nextInt();
                    System.out.print("Digite o cargo: ");
                    cargo = ss.nextLine();
                    System.out.print("Digite o salario do funcionario: R$");
                    salario = sn.nextInt();

                    // Criando objeto de funcionario
                    Funcionario funcionario = new Funcionario(matricula, cargo, salario, nome, cpf);

                    // Adicionando ao arrayList de funcionarios
                    funcionarios.add(funcionario);
                    break;
                case 3:
                    // Verificano se há clientes cadastrados
                    if (clientes.isEmpty() == true) {
                        System.out.println("============================");
                        System.out.println("Nao há clientes cadastrados.");
                        System.out.println("============================");
                        break;
                    }

                    // Seleção de cliente
                    boolean sairMenuCliente = true;
                    boolean sairPainelCliente = true;
                    do {
                        System.out.println("Informe o nome do cliente:");
                        nome = ss.nextLine();

                        for (Cliente x : clientes) {

                            // Verificando se o cliente existe
                            if (nome.equals(x.getNome())) {
                                System.out.println("Painel de cliente aberto para: " + x.getNome());
                                do {
                                    System.out.println("====== PAINEL CLIENTE ======");
                                    System.out.println("[1] - Mostrar dados");
                                    System.out.println("[2] - Listar produtos");
                                    System.out.println("[3] - Depositar saldo");
                                    System.out.println("[4] - Fechar painel");
                                    int resp = sn.nextInt();

                                    switch (resp) {
                                        case 1:
                                            x.mostrarDados();
                                            break;
                                        case 2:
                                            for (Produto i : produtos) {
                                                i.mostrarProdutos();
                                            }
                                            break;
                                        case 3:
                                            x.depositarSaldo();
                                            break;
                                        case 4:
                                            sairPainelCliente = false;
                                            sairMenuCliente = false;
                                            break;
                                        default:
                                            break;
                                    }
                                } while (sairPainelCliente == true);
                            } else {
                                System.out.println(nome + " nao esta cadastrado como cliente.");
                                System.out.println("Quer tentar novamente ? [1] - Sim / [2] - Nao");
                                int resp = sn.nextInt();
                                switch (resp) {
                                    case 1:
                                        sairMenuCliente = true;
                                        break;
                                    case 2:
                                        sairMenuCliente = false;
                                        break;
                                    default:
                                        System.out.println("Opçao invalida.");
                                        break;
                                }
                            }
                        }
                    } while (sairMenuCliente == true);
                    break;
                case 4:
                    // Verificano se há funcionarios cadastrados
                    if (funcionarios.isEmpty() == true) {
                        System.out.println("================================");
                        System.out.println("Nao há funcionarios cadastrados.");
                        System.out.println("================================");
                        break;
                    }

                    // Seleção de funcionario
                    boolean sairPainelFuncionario = true;
                    boolean sairMenuFuncionario = true;
                    do {
                        System.out.println("Informe o nome do funcionario:");
                        nome = ss.nextLine();

                        for (Funcionario x : funcionarios) {

                            // Verificando se o funcionario existe
                            if (nome.equals(x.getNome())) {
                                System.out.println("Painel de funcionario aberto para: " + x.getNome());
                                do {
                                    System.out.println("====== PAINEL FUNCIONARIO ======");
                                    System.out.println("[1] - Mostrar dados");
                                    System.out.println("[2] - Cadastrar produtos");
                                    System.out.println("[3] - Fechar painel");
                                    int resp = sn.nextInt();
                                    switch (resp) {
                                        case 1:
                                            x.mostrarDados();
                                            break;
                                        case 2:
                                            // Cadastro de produtos
                                            System.out.print("Digite o nome do produto: ");
                                            nome = ss.nextLine();
                                            System.out.print("Digite o código do produto: ");
                                            codigo = sn.nextInt();
                                            System.out.print("Digite o preço do produto: R$");
                                            preco = sn.nextInt();

                                            // Criando objeto de produto
                                            Produto produto = new Produto(nome, codigo, preco);

                                            // Adicionando ao ArrayList de produtos
                                            produtos.add(produto);
                                            break;
                                        case 3:
                                            sairPainelFuncionario = false;
                                            sairMenuFuncionario = false;
                                            break;
                                        default:
                                            System.out.println("Opçao invalida tente novamente.");
                                            break;
                                    }

                                } while (sairPainelFuncionario == true);
                            } else {
                                System.out.println("Este funcionario não esta cadastrado.");
                                System.out.println("Quer tentar novamente ? [1] - Sim / [2] - Não");
                                int resp = sn.nextInt();
                                switch (resp) {
                                    case 1:
                                        sairMenuFuncionario = true;
                                        break;
                                    case 2:
                                        sairMenuFuncionario = false;
                                        break;
                                    default:
                                        System.out.println("Opção invalida.");
                                        break;
                                }
                            }
                        }
                    } while (sairMenuFuncionario == true);
                    break;
                case 5:
                    System.out.println("Fechando supermercado...");
                    sairMenuPrincipal = false;
                    break;
                default:
                    break;
            }
        } while (sairMenuPrincipal == true);
    }

}