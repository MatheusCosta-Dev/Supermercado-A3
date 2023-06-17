package supermercado;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Supermercado {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);
        String nome, email, senha, cpf, telefone, rua, bairro, cidade, cep;
        float saldo;
        int erro;

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

    }

}
