import java.util.InputMismatchException;
import java.util.Scanner;
import Banco.Account;

public class Banco {

    public static void main(String[] args) throws InterruptedException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("- Bem-vindo ao NaBank -");
        System.out.print("Digite seu CPF: ");

        try {
            var cpf = entrada.nextLong();
            Account conta = new Account(cpf);
            conta.opcao();
        } catch (InputMismatchException e) {
            System.out.println("Digite apenas números!");
        }

        entrada.close();
    }
}
