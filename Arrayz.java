import java.util.Random;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Arrayz{
    

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";

    static void printarArray(int array[], int tamanho){
        System.out.print(PURPLE + "[");
        for(int i = 0; i < tamanho; i += 1){
            if(i < tamanho - 1){
                System.out.print(array[i] + ",");
            }
            else{
                System.out.print(array[i]);
            }
        }
        System.out.println(PURPLE + "]" + RESET);
    }
    static void printarNumeros(int array[], int numero){
        System.out.print(GREEN + "[");
        System.out.print(numero);
        System.out.println("]" + RESET);
    }
    public static void main(String[] args) throws IOException {
        Random rand = new Random(); 
        int i = 0;
        int tamanho = 10;
        int array[] = new int[tamanho];
        for(;i < tamanho;){
            array[i] = rand.nextInt(3);
            i += 1;
        }
        printarArray(array,tamanho);
        for (int indiceVerde = 0; indiceVerde < tamanho; indiceVerde += 1){
            int numReptido = 0;
            int num = array[indiceVerde];
            for(int indiceAzul = 0; indiceAzul < tamanho; indiceAzul += 1){
                if(num == array[indiceAzul]){
                    numReptido += 1;
                }
            }
            System.out.print(RED +"Numero; " + RESET);
            printarNumeros(array,num);
            System.out.print(RED + "Quantidade do numero; " + RESET);
            printarNumeros(array,numReptido);
        }
        System.out.println(CYAN_BACKGROUND + RED + "This text has a green background and red text!" + RESET);
    }
}
/*
Tarefa 1: Contar a quantidade de numeros repitidos.
Tarefa 2: Não repetir numero no preenchimento.
i = 10
tamanho = 10
array = [1,2,0,0,0,2,1,0,1,0]
indiceVerde = 3
numReptido = 0
num = 0
indiceAzul = 3
*/  