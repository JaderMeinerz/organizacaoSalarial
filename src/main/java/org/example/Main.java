package org.example;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static void calculaPorcentagem(int salario, int vA, int vB, int vC) {
        //Interage com o usuário mostrando o valor de para categoria
        System.out.println("O valor para gastos essenciais é de ");
        System.out.println(salario * vA / 100);
        System.out.println("O valor para gastos pessoais é de ");
        System.out.println(salario * vB / 100);
        System.out.println("O valor a ser guardado é de ");
        System.out.println(salario * vC / 100);
        menuRetorno();
    }
    private static void menuRetorno(){
        //Pergunta ao usuário se ele deseja fazer uma nova operação, caso sim, retorna ao menu inicial
        System.out.println("Deseja fazer uma nova operação?[S/N]");
        String res = sc.next();
        if (res.equals("S")){
            menu();
        }else {
            //caso não, se despede do usuário
            System.out.println("Obrigado por utilizar o sistema de organização salarial!");
        }
    }
    private static void menu(){
        //Interage com o usuário solicitando o Salario
        System.out.println("Olá, bem-vindo ao algoritmo de organização financeira");
        System.out.println("Vamos começar com o seu salaŕio:");
        int salario = Integer.parseInt(sc.next());
        //Interage com o usuário pedindo o percentual de cada categoria
        System.out.println("Para essa organização acontecer temos 3 opções");
        System.out.println("[1]Método 50-30-20");
        System.out.println("[2]Método 60-20-20");
        System.out.println("[3]Inserir manualmente os valores:");
        int res = Integer.parseInt(sc.next());
        //Imprime ao usuário o valor diponível para cada categoria
        switch (res){
            case 1:
                System.out.println("Com o método 50-30-20");
                calculaPorcentagem(salario, 50, 30, 20);
                break;
            case 2:
                System.out.println("Com o método 60-20-20");
                calculaPorcentagem(salario, 60, 20, 20);
                break;
            case 3:
                //No caso da opção 3, interage com o usuário para saber o valor de cada categoria
                int percentual = 100;
                System.out.println("Insira o percentual a ser usado com gastos essenciais" +
                        "(Percentual disponível " + percentual+"%)");
                int vA = Integer.parseInt(sc.next());
                percentual -= vA;
                System.out.println("Agora insira o percentual a ser usado para gastos pessoais" +
                        "(Percentual disponível " + percentual+"%)");
                int vB=Integer.parseInt(sc.next());
                percentual-=vB;
                System.out.println("Por fim, insira o percentual a ser guardado" +
                        "(Percentual disponível " + percentual+"%)");
                int vC=Integer.parseInt(sc.next());
                calculaPorcentagem(salario, vA, vB, vC);
                break;
        }
    }
    public static void main(String[] args) {
        menu();
    }
}