import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
public class Rpg {
    public static void drawLine(String name){
        int tamanho = name.length();
        System.out.println("O-------");
    }
    public static void repoCursor(int x, int y){
        char escCode = 0x1B;
        System.out.print(String.format("%c[%d;%df",escCode,y,x));
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void desenharQuadrado(int altura, int largura, int x,int y){
        repoCursor(x,y);
        System.out.print('O');
        String border1 = "-".repeat(largura);
        System.out.print(border1);
        System.out.print('O');
        for(int i = 0;i < altura ;i += 1){
            repoCursor(x,y+i+1);
            System.out.print('|');
            repoCursor(x+largura+1,y+i+1);
            System.out.print('|');
        }
        repoCursor(x,y+altura+1);
        System.out.print('O');
        System.out.print(border1);
        System.out.print('O');
    }
    public static int desenharHudStatus(Champ champ,int x ,int y){
        int lengthName = champ.name.length();
        String textoHp = "Seu hp eh " + RED + champ.hp + RESET + "/" + RED + champ.hpMax + RESET;
        String textoMp = "Seu mp eh " + CYAN + champ.mp + RESET + "/" + CYAN + champ.mpMax + RESET;
        int lengthHp = textoHp.length() - 18;
        int lengthMp = textoMp.length() - 18;
        int largura = Math.max(lengthName, Math.max(lengthHp, lengthMp)) + 2;
        desenharQuadrado(3, largura, x, y);
        repoCursor(x + 2, y + 1);
        System.out.print( GREEN + champ.name + RESET);
        repoCursor(x + 2, y + 2);
        System.out.print(textoHp);
        repoCursor(x + 2, y + 3);
        System.out.print(textoMp);
        return largura + 2;
    }
    public static void desenharMenu(int x1 ,int x2,int y){
        String menuText = RED + "E a sua vez escolha sua assao:" + RESET ;
        int lengthMenuMaior = menuText.length() - 9;
        int largura = lengthMenuMaior + 2;
        int posCaixa = largura/2;
        int centroExato = (x1 + x2)/2;
        int inicioCaixa = centroExato - posCaixa;
        desenharQuadrado(5,largura,inicioCaixa,y);
        repoCursor(inicioCaixa + 2, y + 1);
        System.out.println(PURPLE + "Eh a sua vez escolha sua assao:" + RESET);
        repoCursor(inicioCaixa + 2, y + 2);
        System.out.println(RED + "1" + RESET + " Ataque normal");
        repoCursor(inicioCaixa + 2, y + 3);
        System.out.println(RED + "2" + RESET + " Magia");
        repoCursor(inicioCaixa + 2, y + 4);
        System.out.println(RED + "3" +  RESET + " Defender");
        repoCursor(inicioCaixa + 2, y + 5);
        System.out.println(RED + "4" +  RESET + " Usar item de cura");
        repoCursor(1, y + 7);
    }

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

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random rand = new Random();
        System.out.print("Escreva o nome do heroi: ");
        String namePlayer = reader.readLine();
        Player player = new Player(namePlayer);
        Enemy enemy = new Enemy("Golobin o Gorobin");
        int vez = 1;
        int i;
        int originDisplayX = 1;
        int originDisplayY = 1;
        int pots = 3;
        player.target = enemy;
        enemy.target = player;
        while (player.hp > 0 && enemy.hp> 0){
            clearScreen();
            int valorOffset1 = desenharHudStatus(player, originDisplayX, originDisplayY) + 2;
            int valorOffset2 = desenharHudStatus(enemy, originDisplayX + valorOffset1, originDisplayY);
            repoCursor(originDisplayX, originDisplayY + 5);
            desenharMenu(valorOffset1,valorOffset2,originDisplayY + 5);
			try{
                while(vez == 1){
                    String j = reader.readLine();
                    repoCursor(1,13);
                    System.out.print("                                                                                           ");
                    repoCursor(1,13);
                    i = Integer.parseInt(j);
                    switch (i){
                        case 1:
                            System.out.println("Voce atacou o inimigo" + RESET);
                            player.attack();
                            vez = 2;
                            break;
                        case 2:
                            if (player.magic()){
                                System.out.println("Voce usou uma bola de fogo para atacar " + enemy.name);
                                vez = 2;
                            }
                            break;
                        case 3:
                            System.out.println("Voce esta defendendo ate o proximo turno" + RESET);
                            player.isDefending = true;
                            vez = 2;
                            break;
                        case 4:
                            if (pots > 0){
                                System.out.println("Voce usou uma pocao e se curou" + RESET);
                                player.hp = player.hpMax;
                                vez = 2;
                            }
                            else{
                                System.out.println("Ta sem pot otario");
                            }
                            break;
                    }
                    reader.readLine();
                }
                if (vez==2){
                    System.out.println("Eh a vez do " + enemy.name + RESET);
                    i = rand.nextInt(3);
                    switch (i){
                        case 0:
                            System.out.println(enemy.name + " atacou o " + player.name + " com um pau Brasil" + RESET);
                            enemy.attack();
                            break;
                        case 1:
                            System.out.println(enemy.name + " usou uma bola de cocos para atacar o " + player.name + RESET);
                            enemy.magic();
                            break;
                        case 2:
                            System.out.println(enemy.name + " esta defendendo ate o proximo turno" + RESET);
                            enemy.isDefending = true;
                            break;
                    }
                    vez = 1;
                    reader.readLine();
                }
            }
            catch(NumberFormatException e){
				System.out.println("So rola numero filhao");
                reader.readLine();
			}
            catch(NullPointerException e){
				System.out.println(RED + "ERRO: " +  RESET + "Lendo uma variavel de um nulo");
                reader.readLine();
			}
        }
    }
}
class Champ{
    String name;

    int hp;
    int hpMax;
    int mp;
    int mpMax;
    int atk;
    int def;
    Boolean isDefending; 
    int critChance;
    int critMultiplier;
    int evasionChance;
    Random rand;
    Champ target;

    public Champ(String name,int hpMax,int mpMax,int atk,int critChance,int critMultiplier,int def){
        this.name = name;
        this.hp = hpMax;
        this.hpMax = hpMax;
        this.mp = mpMax;
        this.mpMax = mpMax;
        this.atk = atk;
        this.def = def;
        this.isDefending = false; 
        this.critChance = critChance;
        this.critMultiplier = critMultiplier;
        this.evasionChance = evasionChance;
        this.target = null;
        this.rand = new Random();
        
    }
    void attack(){
        int critDmg = (this.critChance >= rand.nextInt(100)) ? (this.atk*this.critMultiplier) : this.atk;
        if(this.target.evasionChance >= rand.nextInt(100)){
            System.out.println(this.target.name + " desviou do ataque");
        }
        else if (this.isDefending == true){
            this.target.hp -= (critDmg-this.target.def)/2;
        }
        else{
            this.target.hp -= critDmg-this.target.def;
        }
    }
    boolean magic(){
        if(this.mp >= 10){
            int critDmg = (this.critChance >= rand.nextInt(100)) ? (this.atk*this.critMultiplier) : this.atk;
            if(this.target.evasionChance - 10 >= rand.nextInt(100)){
                System.out.println(this.target.name + " desviou do ataque");
            }
            else{
                this.target.hp -= critDmg*2;
            }
            this.mp -= 10;
            return true;
        }
        else{
            System.out.println("Se fudeu ta sem mana");
            return false;
        }
    }
}
class Player extends Champ{
    Item inventory[];
    int gold;
    int level;
    int xp;
    int slot;

    public Player(String name){
        super(name,150,100,10,7,2,5);
        this.gold = 0;
        this.level = 1;
        this.xp = 0;
        this.slot = 0;
        
    }
    void level(){
        if (this.xp >= 100){
            this.xp -= 100;
            this.level += 1;
        }
    }
}
class Enemy extends Champ{
    Item loot[];
    int gold;
    int xp;

    public Enemy(String name){
        super(name,200,100,10,7,2,10);
        this.gold = 10 + rand.nextInt(100);
        this.xp = 10;
    }
}
class Item {
    String name;
    String description;
    Icon icon;

    int price;

    public Item(String name, String description, Icon icon, int price){
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.price = price;
    }
}
class Icon{
    String color;
    char icon;
    
    public Icon(String color, char icon){
        this.color = color;
        this.icon = icon;
    }
    void draw(){
        System.out.println(color + icon + Rpg.RESET);
    }
}