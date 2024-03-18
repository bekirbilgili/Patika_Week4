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
            player.printInfo();
            System.out.println();
            System.out.println("##########Bölgeler##########");
            System.out.println();
            System.out.println("1-Güvenli Ev--->Burası sizin için güvenli, burada düşman yoktur.");
            System.out.println("2-Mağaza--->Silah veya zırh alabilirsiniz");
            System.out.println("3-Mağara-->Ödül Yemek, Dikkatli ol zombi çıkabilir");
            System.out.println("4-Orman-->Ödül Odun, dikkatli ol vampir çıkabilir.");
            System.out.println("5-Nehir-->Ödül Su,dikkatli ol ayı çıkabilir.");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçin:");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    location = new SafeHouse(player);

            }

            if (!location.onLocation()) {
                System.out.println("GAME OVER!!");
                break;
            }

        }


    }
}
