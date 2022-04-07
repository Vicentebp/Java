import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Joguinho {
	static void mostraVez (String vez){
		System.out.println("Eh a vez do " + vez);
	}
	static void vidaPersonagem (int hp,int vez2){
		if(vez2 == 1){
			System.out.println("Sua vida: " + hp);
		}
		else{
			System.out.println("O inimigo Tem " + hp + " Hp");
		}
	}
	static int calculoDano(int ataque,Boolean defesa){
		if (defesa == false){
			return ataque;
		}
		else{
			return ataque/2;
		}
	}	
	public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random rand = new Random(); 
        int hpHero = 100;
		int mpHero = 50;
		int potions = 1;
		int atkHero = 10;
        int hpMonster = 200;
		int atkMonster = 20; 
		int vez = 1;
		int dano = 0; 
		Boolean isDefendingHero = false;
		Boolean isDefendingMonster = false;
		int i = 0;
        int n = rand.nextInt(3);
		System.out.print("Escreva o nome do heroi: ");
		String nameHero = reader.readLine();
		System.out.print("Escreva o nome do monstro: ");
		String nameMonster = reader.readLine();
		while (hpHero > 0 && hpMonster > 0) {
			try{
				n = rand.nextInt(3);
				if (vez == 1 ){
					mostraVez(nameHero);
				}
				else{
					mostraVez(nameMonster);
				}
				while (vez == 1 ){
					vidaPersonagem(hpHero,vez);
					vidaPersonagem(hpMonster,2);
					System.out.println("Escolha uma habilidade");
					System.out.println("1 - Ataque normal");
					System.out.println("2 - Fireball");
					System.out.println("3 - Usar item de cura");
					System.out.println("4 - Defender");
					i=Integer.parseInt(reader.readLine());
					if (i == 1 ){
						System.out.println("Voce escolheu atacar o " + nameMonster);
						hpMonster -= calculoDano(atkHero,isDefendingMonster);
						vez = 2;
					}
					else if (i == 2 ){
						if (mpHero >= 25){
							System.out.println("Voce usou bola de fogo");
							hpMonster -= (atkHero * 2);
							mpHero -= 25;
							vez = 2;
						}
						else{
							System.out.println ("Voce não tem mana o suficiente");
						}
					}
					else if (i == 3){
						if (potions >= 1){
							System.out.println("Voce usou pocao de cura");
							hpHero = 100;
							potions = 0;
							vez = 2;
						}
						else{
							System.out.println("Voce nao tem pocoes sobrando");
						}
					}
					else if (i == 4){
						System.out.println("Voce esta defendendo");
						isDefendingHero = true;
						vez = 2;
					}
					else{				
						System.out.println("Opcao invalida, tente tente novamente");
					}
				}
				isDefendingMonster = false;
				if (hpMonster <=0){
					System.out.println (nameMonster + " Morreu");
					break;
				}
				n = rand.nextInt(3);
				if (n == 0){
					dano = calculoDano(atkMonster,isDefendingHero);
					hpHero -= dano;
					System.out.println("O " + nameMonster + " te atacou e tirou " + dano);
					vidaPersonagem(hpHero,1);
				}
				else if (n == 1){
					System.out.println("O " + nameMonster + " esta defendendo");
					isDefendingMonster = true;
				}
				else if (n == 2){
					System.out.println("O " + nameMonster + " escorregou e perdeu a vez");
				}
				vez = 1;
				if (hpHero <= 0){
					System.out.println("Voce morreu");
				}
				isDefendingHero = false;
			}
			catch(Exception e){
				System.out.println("So vale numero de 1-3");
			}
		}	
	}
}
/* 
Fazer valores aleatorio para os stats do heroi e o mostro
*/ 