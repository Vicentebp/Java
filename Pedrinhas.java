import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Pedrinhas {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int pedras = 21;
		int i;
		System.out.print("Nome do jogador 1: ");
		String jogador1 = reader.readLine();
		System.out.print("Nome do jogador 2: ");
		String jogador2 = reader.readLine();
		System.out.println("Escolha quantas pedras voce deseja retirar, tem que ser de 1 a 3");
		int vez = 1;
		while (pedras > 0) {
			try{
				if (vez == 1 ){
					System.out.println("Vez do " + jogador1);
				}
				else{
					System.out.println("Vez do " + jogador2);
				}
				i=Integer.parseInt(reader.readLine());
				if (i <= 3 && i >0 && pedras >= i){
					pedras -= i;
					System.out.println("Voce escolheu " + i + " Pedras");
					vez = (vez == 1) ? 2 : 1;
				}
				else{				
					System.out.println("Numero invalido, jogue novamente");
				}
				System.out.println(pedras);
				if (pedras <= 0){
					System.out.println("Voce perdeu");
				}
			}
			catch(Exception e){
				System.out.println("So vale numero de 1-3");
			}
		}	
	}
}