package Banco;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Conta {

    private long cpf;
    private double saldo = 0.00;
    Espaco espaco = new Espaco();
    List<String> extrato = new ArrayList<>();

    public Conta() {}
    public Conta(long cpf) {
        this.cpf = cpf;
    }

    public void opcao() throws InterruptedException {
        Scanner entrada = new Scanner(System.in);

        System.out.println();
        System.out.println("- Digite uma opção -");
        System.out.println("1) Depositar");
        System.out.println("2) Sacar");
        System.out.println("3) Informações");
        System.out.println("4) Extrato");
        System.out.println("9) Fechar aplicativo");
        System.out.print("Digite: ");

        try {
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
                    extrato.add("Deposito: R$+" + depositar);
                    Thread.sleep(1500);
                    opcao();
                }

                case 2 -> {
                    espaco.espacoBranco();
                    System.out.print("Digite a quantidade: ");
                    double sacar = entrada.nextDouble();
                    if (sacar <= saldo) {
                        saldo -= sacar;
                        System.out.printf("Saque realizado com sucesso, valor: R$%.2f\n", sacar);
                        System.out.printf("Saldo: R$%.2f\n", saldo);
                        extrato.add("Saque: R$-" + sacar);
                        Thread.sleep(1500);
                        opcao();
                    } else {
                        System.out.println("Você não tem o saldo suficiente para conseguir sacar!");
                        System.out.println("Você tem o saldo R$" + saldo + "!");
                        System.out.println("Só poderá sacar se o seu saldo final for maior ou igual a 0.0!");
                        Thread.sleep(2000);
                        opcao();
                    }
                }

                case 3 -> {
                    espaco.espacoBranco();
                    info();
                    Thread.sleep(3000);
                    opcao();
                }

                case 4 -> {
                    espaco.espacoBranco();
                    showEstrato();
                    Thread.sleep(3000);
                    opcao();
                }

                case 9 -> {
                    espaco.espacoBranco();
                    System.out.println("Obrigado por usar nosso aplicativo!");
                    System.out.println();
                    Thread.sleep(1000);
                    info();
                    System.out.println();
                    showEstrato();
                }

                default -> {
                    System.out.println();
                    System.out.println("- Número inválido! -");
                    System.out.println("Números válidos:");
                    System.out.println("1, 2, 3, 4 e 9.");
                    System.out.println("--------------------");
                    Thread.sleep(1000);
                    opcao();
                }
            }
            entrada.close();
        } catch (InputMismatchException e) {
            System.out.println("Digite apenas números!");
            opcao();
        }
    }

    public void info() {
        System.out.println("- Suas informações -");
        System.out.printf("CPF: %d\n", cpf);
        System.out.printf("Saldo: R$%.2f\n", saldo);
        System.out.println("--------------------");
    }

    public void showEstrato() {
        System.out.println("- NaBank Seu extrato -");
        if (!extrato.isEmpty()) {
            for (String lerLista: extrato) {
                System.out.println(lerLista);
            }
        } else {
            System.out.println("Faça um saque ou deposito!");
        }
        System.out.println("----------------------");
    }
}
