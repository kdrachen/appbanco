package Banco;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RegistroCPF {

    public static void registrarCPF() {
        Scanner entrada = new Scanner(System.in);
        Espaco espaco = new Espaco();
        System.out.println("- Bem-vindo ao NaBank -");
        System.out.println("Seu CPF deve ser escrito sem traços e com no mínimo 11 dígitos");
        System.out.print("Digite seu CPF: ");

        try {
            Long cpf = entrada.nextLong();
            Integer convert = cpf.toString().length();

            if (convert == 11) {
                Account conta = new Account(cpf);
                System.out.println("Registrado com sucesso!");
                Thread.sleep(1500);
                conta.opcao();
            } else {
                espaco.espacoBranco();
                System.out.printf("O seu CPF tem %d dígitos!\n", convert);
                System.out.println("Deve ser escrito sem traço ou letra e com no mínimo 11 dígitos!");
                Thread.sleep(2000);
                espaco.espacoBranco();
                registrarCPF();
            }
        } catch (InputMismatchException e) {
            espaco.espacoBranco();
            System.out.println("Por favor, digite apenas números.");
            System.out.println("Seu CPF deve ser escrito sem traço ou letra e com no mínimo 11 dígitos!");
            registrarCPF();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
