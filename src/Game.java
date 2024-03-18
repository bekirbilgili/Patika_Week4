import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);


    public void start() {
        System.out.println("Macera oyununa hoşgeldiniz!");
        System.out.println("Lütfen bir isim giriniz: ");
        //String playerName = input.nextLine();
        Player player = new Player("bekir");
        System.out.println(player.getName() + " Hoşgeldiniz!!");
        System.out.println("Lütfen oyuna başlamak için bir karakter seçin...");
        player.selectChar();

        Location location = null;
        while (true) {
            System.out.println();
            System.out.println("##########Bölgeler##########");
            System.out.println();
            System.out.println("1-Güvenli Ev--->Burası sizin için güvenli, burada düşman yoktur.");
            System.out.println("2-Mağaza--->Silah veya zırh alabilirsiniz");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçin:");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);

            }

            if(!location.onLocation()){
                System.out.println("GAME OVER!!");
                break;
            }

        }


    }
}
