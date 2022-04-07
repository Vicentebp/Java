import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Fogao{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tempoPraCozinhar = 0;
        int tempoPraQueimar = 0;
        int tempo = 0;
        int tempoCrescente = 0;
        int lerTerminal;
        int produto = 0;
        int estado = 0;
        int i = 0;
        int finalizado = 1;
        String quantoTempoCozinhar = "Quanto tempo voce quer cozinhar o produto?";
        while (finalizado < 2){
            try{
                System.out.println("1 - Cozinhar Produto");
                System.out.println("2 - Sair");
                i=Integer.parseInt(reader.readLine());
                if (i == 1){
                    System.out.println("Escolha uma comida; Tempo de cozimento; Tempo para queimar");
                    System.out.println("1 - Pao;            100;                200; ");
                    System.out.println("2 - Carne;          10;                 300; ");
                    System.out.println("3 - Massa;          79;                 90; ");
                    System.out.println("4 - Maca;           20;                 40; ");
                    System.out.println("5 - Osso;           100;                300; ");
                    i=Integer.parseInt(reader.readLine());
                    produto = i;
                    switch(i){
                        case 1:
                            System.out.println(quantoTempoCozinhar);
                            i=Integer.parseInt(reader.readLine());
                            tempo = i;
                            tempoPraCozinhar = 100;
                            tempoPraQueimar = 200;
                            break;
                        case 2:
                            System.out.println(quantoTempoCozinhar);
                            i=Integer.parseInt(reader.readLine());
                            tempo = i;
                            tempoPraCozinhar = 10;
                            tempoPraQueimar = 300;
                            break;
                        case 3:
                            System.out.println(quantoTempoCozinhar);
                            i=Integer.parseInt(reader.readLine());
                            tempo = i; 
                            tempoPraCozinhar = 79;
                            tempoPraQueimar = 90;
                            break;
                        case 4:
                            System.out.println(quantoTempoCozinhar);
                            i=Integer.parseInt(reader.readLine());
                            tempo = i; 
                            tempoPraCozinhar = 20;
                            tempoPraQueimar = 40;
                            break;
                        case 5:
                            System.out.println(quantoTempoCozinhar);
                            i=Integer.parseInt(reader.readLine());
                            tempo = i; 
                            tempoPraCozinhar = 100;
                            tempoPraQueimar = 300;
                            break;
                    }
                }
                else if (i == 2)
                    break;
                if (produto > 0){
                    while (tempo >= 0){
                        if (tempoPraCozinhar > tempoCrescente){
                            
                            System.out.print(".");       
                        }
                        else if (tempoCrescente < tempoPraQueimar){
                            System.out.print("|");
                            
                        }
                        else {
                            System.out.print("'");
                            
                        }
                        System.out.println(tempoCrescente);
                        tempoCrescente += 1;
                        tempo -= 1;
                    }
                    System.out.println(""); 
                }
            tempoCrescente = 0;
            tempo = 0;
            }
            catch(Exception e){
				System.out.println("So pode por numeros");
			}
        }
    }
}