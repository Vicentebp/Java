import java.util.Random;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Quadrado{

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

    static void printTabela(int altura, int largura, Tabela tabelota){
        System.out.println("Essa eh a sua tabela: " + GREEN);
        for(int indiceVerde = 0; indiceVerde < altura ; indiceVerde += 1){
            for(int indiceVermelho = 0; indiceVermelho < largura; indiceVermelho += 1){
                System.out.print(tabelota.quadradoArray[indiceVerde][indiceVermelho] + "\t");      
            }   
            System.out.println();
        }
        System.out.print(RESET);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random rand = new Random(); 
        int altura;
        int largura;
        System.out.println("Escolha a altura do seu quadrado: ");
        altura = Integer.parseInt(reader.readLine());
        System.out.println("Escolha a largura do seu quadrado: ");
        largura = Integer.parseInt(reader.readLine());
        System.out.print(RESET);
        Tabela tabelinha = new Tabela(altura,largura);
        tabelinha.fill();
        printTabela(tabelinha.altura,tabelinha.largura,tabelinha);
    }
}
class Tabela{
    int altura;
    int largura;
    String quadradoArray[][];
    String listaNomes[] = {"FigoFaps","Mingosmangos", "Churusbangos","Marango Nango","Rararaucaria", "Machucho", "BumboRango", "Mango Jango","Scarafinfo","Strombelhete"};
    public Tabela(int altura,int largura){
        this.altura = altura;
        this.largura = largura;
        this.quadradoArray = new String[altura][largura];
    }
    void fill(){
        Random rand = new Random(); 
        for(int indiceVerde = 0; indiceVerde < altura ; indiceVerde += 1){
            for(int indiceVermelho = 0; indiceVermelho < largura; indiceVermelho += 1){
                quadradoArray[indiceVerde][indiceVermelho] = listaNomes[rand.nextInt(listaNomes.length)];
            }
        }
    }
}