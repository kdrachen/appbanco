import java.util.Scanner;
import Banco.Account;

public class Banco {

    public static void main(String[] args) throws InterruptedException {
        Scanner entrada = new Scanner(System.in);

        System.out.println("- Bem-vindo ao NaBank -");
        System.out.print("Digite seu CPF: ");

        var cpf = entrada.nextLong();
        Account conta = new Account(cpf);
        conta.info();
        conta.opcao();

        entrada.close();
        //Thread.sleep(3000);
    }
}
