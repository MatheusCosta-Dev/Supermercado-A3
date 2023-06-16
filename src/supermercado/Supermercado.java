package supermercado;

import java.util.ArrayList;
import java.util.Scanner;

public class Supermercado {

    public static void main(String[] args) {

        // Scanners
        Scanner ss = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);

        // Variaveis
        int matriculaFuncionario = 0, idCliente = 0, codigo = 0, codigoProduto;
        String nome, cpf, cargo, senha;
        float salario, saldo, preco;
        boolean sairMenuPrincipal = true;

        // Array list
        ArrayList<Cliente> clientes = new ArrayList();
        ArrayList<Funcionario> funcionarios = new ArrayList();
        ArrayList<Produto> produtos = new ArrayList();

        do {

            // Menu principal
            sairMenuPrincipal = true;
            System.out.println("[1] - Cliente");
            System.out.println("[2] - Funcionario");
            System.out.println("[3] - Sair");
            int menu = sn.nextInt();
            switch (menu) {
                case 1:

                    // Direcionamento para login ou tela de registro
                    System.out.println("Você já tem cadastro?");
                    System.out.println("[1] - Sim");
                    System.out.println("[2] - Não");
                    int opcaocadastro = sn.nextInt();

                    if (opcaocadastro == 1) {
                        // Verificando se há clientes cadastrados
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
                            System.out.println("Informe o senha do cliente:");
                            senha = ss.nextLine();

                            for (Cliente x : clientes) {

                                // Verificando login do Cliente
                                if (nome.equals(x.getNome()) && senha.equals(x.getSenha())) {
                                    System.out.println("Painel de cliente aberto para: " + x.getNome());
                                    do {
                                        System.out.println("====== PAINEL CLIENTE ======");
                                        System.out.println("[1] - Mostrar dados");
                                        System.out.println("[2] - Depositar saldo");
                                        System.out.println("[3] - Comprar produtos");
                                        System.out.println("[4] - Fechar painel");
                                        int resp = sn.nextInt();

                                        switch (resp) {
                                            case 1:
                                                x.mostrarDados();
                                                break;
                                            case 2:
                                                x.depositarSaldo();
                                                break;
                                            case 3:
                                                boolean selecionarProduto = true;
                                                boolean sairPainelProduto = true;
                                                do {

                                                    // Painel de compra
                                                    System.out.println("====== PAINEL DE COMPRAS ======");
                                                    System.out.println("[1] - Lista de produtos");
                                                    System.out.println("[2] - Mostrar carrinho");
                                                    System.out.println("[3] - Fechar pedido");
                                                    System.out.println("[4] - Fechar Painel");
                                                    resp = sn.nextInt();

                                                    switch (resp) {
                                                        case 1:
                                                            // Verificano se há produtos cadastrados
                                                            if (produtos.isEmpty() == true) {
                                                                System.out.println("============================");
                                                                System.out.println("Nao há produtos cadastrados.");
                                                                System.out.println("============================");
                                                                break;
                                                            }

                                                            // Selecionar produtos
                                                            for (Produto i : produtos) {
                                                                i.mostrarProdutos();
                                                            }

                                                            for (Produto i : produtos) {
                                                                do {
                                                                    System.out.print(
                                                                            "Digite o nome do produto que quer adicionar ao carrinho: ");
                                                                    codigoProduto = sn.nextInt();

                                                                    // Verificando se o produto existe
                                                                    if (codigoProduto == i.getCodigo()) {

                                                                    } else {
                                                                        System.out.println(
                                                                                codigoProduto
                                                                                        + " nao esta na lista de produtos.");
                                                                        System.out.println(
                                                                                "Quer tentar novamente ? [1] - Sim / [2] - Nao");
                                                                        resp = sn.nextInt();
                                                                        switch (resp) {
                                                                            case 1:
                                                                                selecionarProduto = true;
                                                                                break;
                                                                            case 2:
                                                                                selecionarProduto = false;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Opçao invalida.");
                                                                                break;
                                                                        }
                                                                    }
                                                                } while (selecionarProduto == true);
                                                            }
                                                            break;
                                                        case 2:

                                                            break;
                                                        case 3:

                                                            break;
                                                        case 4:
                                                            sairPainelProduto = false;
                                                            break;
                                                        default:
                                                            break;
                                                    }
                                                } while (sairPainelProduto == true);

                                                break;
                                            case 4:
                                                sairPainelCliente = false;
                                                sairMenuCliente = false;
                                                break;
                                            default:
                                                break;
                                        }
                                    } while (sairPainelCliente == true);
                                    // Caso o cliente nao exista
                                } else {
                                    System.out.println("Usuario ou senha invalidos");
                                    System.out.println("Quer tentar novamente ? [1] - Sim / [2] - Nao");
                                    int respLogin = sn.nextInt();
                                    switch (respLogin) {
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
                    } else if (opcaocadastro == 2) {

                        // Cadastro de clientes
                        System.out.println("CADASTRAR CLIENTE");
                        idCliente = idCliente + 1;
                        System.out.print("Digite seu nome: ");
                        nome = ss.nextLine();
                        System.out.print("Digite seu CPF: ");
                        cpf = ss.nextLine();
                        System.out.print("Digite seu saldo: R$ ");
                        saldo = sn.nextFloat();
                        System.out.print("Digite uma senha: ");
                        senha = ss.nextLine();

                        // Criando objeto de cliente
                        Cliente cliente = new Cliente(idCliente, saldo, nome, cpf, senha);

                        // Adicionando ao arrayList de clientes
                        clientes.add(cliente);

                    } else {
                        System.out.println("Opção invalida, digite novamente uma opção valida.");
                    }

                    break;
                case 2:
                    // Direcionamento para login ou tela de registro
                    System.out.println("Você já tem cadastro?");
                    System.out.println("[1] - Sim");
                    System.out.println("[2] - Não");
                    opcaocadastro = sn.nextInt();

                    if (opcaocadastro == 2) {

                        // Cadastro de funcionarios
                        matriculaFuncionario = matriculaFuncionario + 1;
                        System.out.println("CADASTRAR FUNCIONARIO");
                        System.out.print("Digite o nome do funcionario: ");
                        nome = ss.nextLine();
                        System.out.print("Digite o CPF: ");
                        cpf = ss.nextLine();
                        System.out.print("Digite o cargo: ");
                        cargo = ss.nextLine();
                        System.out.print("Digite o salario do funcionario: R$");
                        salario = sn.nextInt();
                        System.out.print("Digite uma senha: ");
                        senha = ss.nextLine();

                        // Criando objeto de funcionario
                        Funcionario funcionario = new Funcionario(matriculaFuncionario, cargo, salario, nome, cpf,
                                senha);

                        // Adicionando ao arrayList de funcionarios
                        funcionarios.add(funcionario);

                    } else if (opcaocadastro == 1) {

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
                            System.out.println("Informe o senha do funcionario:");
                            senha = ss.nextLine();

                            for (Funcionario x : funcionarios) {

                                // Verificando se o funcionario existe
                                if (nome.equals(x.getNome()) && senha.equals(x.getSenha())) {
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
                                                codigo = codigo + 1;
                                                System.out.print("Digite o nome do produto: ");
                                                nome = ss.nextLine();
                                                System.out.print("Digite o preço do produto: R$");
                                                preco = sn.nextInt();

                                                // Criando objeto de produto
                                                Produto produto = new Produto(nome, codigo, preco);

                                                // Adicionando ao ArrayList de produtos
                                                produtos.add(produto);
                                                break;
                                            case 3:
                                                // Saindo para o menu pricipal
                                                sairPainelFuncionario = false;
                                                sairMenuFuncionario = false;
                                                break;
                                            default:
                                                System.out.println("Opçao invalida tente novamente.");
                                                break;
                                        }
                                        // Caso senha de funcionario seja invalido
                                    } while (sairPainelFuncionario == true);
                                } else {
                                    System.out.println("Usuario e senha invalidos ou inexistente");
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

                    } else {
                        System.out.println("Opçao invalida...");
                    }

                    break;
                case 3:
                    System.out.println("Fechando supermercado...");
                    sairMenuPrincipal = false;
                    break;
                default:
                    System.out.println("Opçao invalida...");
                    break;
            }
        } while (sairMenuPrincipal == true);
    }

}