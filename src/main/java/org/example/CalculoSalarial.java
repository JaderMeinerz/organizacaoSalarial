package org.example;

public class CalculoSalarial {
    private static int salario;
    private static int essenciais;
    private static int pessoais;
    private static int guardar;

    protected static void setSalario(int salario){
        CalculoSalarial.salario = salario;
    }
    public static void setEssenciais(int essenciais) {
        CalculoSalarial.essenciais = salario*essenciais/100;
    }
    public static void setGuardar(int guardar) {
        CalculoSalarial.guardar = salario*guardar/100;
    }
    public static void setPessoais(int pessoais) {
        CalculoSalarial.pessoais = salario*pessoais/100;
    }
    protected  static int getEssenciais(){
        return essenciais;
    }
    protected  static int getPessoais(){
        return pessoais;
    }
    protected  static int getGuardar(){
        return guardar;
    }
}
