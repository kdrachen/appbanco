package Banco;

import java.util.Scanner;

public class Account {

    long cpf;
    double saldo = 0.0;
    OtherMethods espaco = new OtherMethods();

    public Account(long cpf) {
        this.cpf = cpf;
    }

    public void opcao() throws InterruptedException {
        Scanner entrada = new Scanner(System.in);

        System.out.println();
        System.out.println("- Digite uma opção -");
        System.out.println("1) Depositar");
        System.out.println("2) Sacar");
        System.out.println("3) Informações");
        System.out.println("9) Fechar aplicativo");
        System.out.print("Digite: ");
        int lerOpcao = entrada.nextInt();

        System.out.println("--------------------");

        switch (lerOpcao) {
            case 1 -> {
                espaco.espacoBranco();
                System.out.print("Digite a quantidade: ");
                double depositar = entrada.nextDouble();
                saldo += depositar;
                System.out.printf("Deposito realizado com sucesso, valor: R$%.2f \n", depositar);
                System.out.printf("Saldo: R$%.2f\n", saldo);
                System.out.println();
                Thread.sleep(1500);
                opcao();
            }

            case 2 -> {
                espaco.espacoBranco();
                System.out.print("Digite a quantidade: ");
                double sacar = entrada.nextDouble();
                saldo -= sacar;
                System.out.printf("Saque realizado com sucesso, valor: R$%.2f\n", sacar);
                System.out.printf("Saldo: R$%.2f\n", saldo);
                System.out.println();
                Thread.sleep(1500);
                opcao();
            }

            case 3 -> {
                info();
                Thread.sleep(3000);
                opcao();
            }

            case 9 -> {
                espaco.espacoBranco();
                System.out.println("Obrigado por usar nosso aplicativo!");
                System.out.println("Até mais!");
            }

            default -> {
                System.out.println("- Número inválido! -");
                opcao();
            }
        }

        entrada.close();
    }

    public void info() {
        espaco.espacoBranco();
        System.out.println("- Suas informações -");
        System.out.printf("CPF: %d\n", cpf);
        System.out.printf("Saldo: R$%.2f\n", saldo);
        System.out.println("--------------------");
    }
}
