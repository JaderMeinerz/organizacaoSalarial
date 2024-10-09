package org.example;

import java.util.Scanner;

public class Menu {
    final private static Scanner sc = new Scanner(System.in);

    public static void menuPrincipal(){
        System.out.println("Olá, bem-vindo ao algoritmo de organização financeira");
        recebeSalario();
        menuCategorias();
    }
    protected static void menuRetorno(){
        //Pergunta ao usuário se ele deseja fazer uma nova operação, caso sim, retorna ao menu inicial
        System.out.println("Deseja fazer uma nova operação?[S/N]");
        String res = sc.next();
        if (res.equals("S")){
            System.out.println("Deseja utilizar o mesmo salário?[S/N]");
            res = sc.next();
            if (res.equals("S")){
                menuCategorias();
            }else{
                menuPrincipal();
            }
        }else {
            //caso não, se despede do usuário
            System.out.println("Obrigado por utilizar o sistema de organização salarial!");
        }
    }
    protected static void imprimeMetodo(int essenciais, int pessoais, int guardar){
        CalculoSalarial.setEssenciais(essenciais);
        CalculoSalarial.setPessoais(pessoais);
        CalculoSalarial.setGuardar(guardar);
        System.out.println("Com o método "+essenciais+"-"+pessoais+"-"+guardar);
        System.out.println("O valor a ser usado para gastos essenciais é de ");
        System.out.println(CalculoSalarial.getEssenciais());
        System.out.println("O valor a ser usado para gastos pessoais é de ");
        System.out.println(CalculoSalarial.getPessoais());
        System.out.println("E o valor a ser guardado é de ");
        System.out.println(CalculoSalarial.getGuardar());
        menuRetorno();

    }
    protected static void recebeSalario(){
        System.out.println("Vamos começar com o seu salaŕio:");
        CalculoSalarial.setSalario(Integer.parseInt(sc.next()));
    }
    protected static void menuCategorias(){
        //Interage com o usuário pedindo que selecione uma categoria
        System.out.println("Selecione uma das 3 opções abaixo");
        System.out.println("[1]Método 50-30-20");
        System.out.println("[2]Método 60-20-20");
        System.out.println("[3]Inserir manualmente os valores:");
        int res = Integer.parseInt(sc.next());
        //Imprime ao usuário o valor diponível para cada categoria
        switch (res){
            case 1:
                imprimeMetodo(50, 30, 20);
                break;
            case 2:
                imprimeMetodo(60, 20, 20);
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
                imprimeMetodo(vA, vB, vC);
                break;
        }
    }
}
