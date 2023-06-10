package supermercado;

import java.util.ArrayList;
import java.util.Scanner;

public class Supermercado {

    public static void main(String[] args) {

        // Scanners
        Scanner ss = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);

        // Variaveis
        int matricula, id;
        String nome, cpf, cargo;
        float salario, saldo;
        boolean sairMenuPrincipal = true;

        // Array list
        ArrayList<Cliente> clientes = new ArrayList();
        ArrayList<Funcionario> funcionarios = new ArrayList();
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
                    System.out.println("Digite seu nome: ");
                    nome = ss.nextLine();
                    System.out.println("Digite seu CPF: ");
                    cpf = ss.nextLine();
                    System.out.println("Digite seu saldo: ");
                    saldo = sn.nextFloat();
                    System.out.println("Digite seu ID: ");
                    id = sn.nextInt();

                    // Criando objeto de cliente
                    Cliente cliente = new Cliente(id, saldo, nome, cpf);

                    // Adicionando ao arrayList de clientes
                    clientes.add(cliente);
                    break;
                case 2:

                    // Cadastro de funcionarios
                    System.out.println("CADASTRAR FUNCIONARIO");
                    System.out.println("Digite o nome do funcionario:");
                    nome = ss.nextLine();
                    System.out.println("Digite o CPF: ");
                    cpf = ss.nextLine();
                    System.out.println("Digite a matricula: ");
                    matricula = sn.nextInt();
                    System.out.println("Digite o cargo: ");
                    cargo = ss.nextLine();
                    System.out.println("Digite o salario do funcionario: ");
                    salario = sn.nextInt();

                    // Criando objeto de funcionario
                    Funcionario funcionario = new Funcionario(matricula, cargo, salario, nome, cpf);

                    // Adicionando ao arrayList de funcionarios
                    funcionarios.add(funcionario);
                    break;
                case 3:

                    // Seleção de cliente
                    boolean sairMenuCliente = true;
                    do {
                        System.out.println("Informe o nome do cliente:");
                        nome = ss.nextLine();

                        for (Cliente x : clientes) {

                            // Verificando se o cliente existe
                            if (nome.equals(x.getNome())) {
                                System.out.println("Painel de cliente aberto para: " + x.getNome());
                            } else {
                                System.out.println("Este cliente não esta cadastrado.");
                                System.out.println("Quer tentar novamente ? [1] - Sim / [2] - Não");
                                int resp = sn.nextInt();
                                switch (resp) {
                                    case 1:
                                        sairMenuCliente = true;
                                        break;
                                    case 2:
                                        sairMenuCliente = false;
                                        break;
                                    default:
                                        System.out.println("Opção invalida.");
                                        break;
                                }
                            }
                        }
                    } while (sairMenuCliente == true);
                    break;
                case 4:
                    // Seleção de funcionario
                    boolean sairMenuFuncionario = true;
                    do {
                        System.out.println("Informe o nome do funcionario:");
                        nome = ss.nextLine();

                        for (Funcionario x : funcionarios) {

                            // Verificando se o funcionario existe
                            if (nome.equals(x.getNome())) {
                                System.out.println("Painel de funcionario aberto para: " + x.getNome());
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
                    System.out.println("Fechando menu...");
                    sairMenuPrincipal = false;
                    break;
                default:
                    break;
            }
        } while (sairMenuPrincipal == true);
    }

}