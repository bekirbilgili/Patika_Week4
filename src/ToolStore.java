public class ToolStore extends NormalLocation {

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("----------Mağazaya Hoşgeldiniz!!----------");
        System.out.println("1-Silahlar");
        System.out.println("2-Zırhlar");
        System.out.println("3-Çıkış Yap");
        System.out.print("Seçiminiz: ");
        int selectCase = Location.input.nextInt();
        while (selectCase < 1 || selectCase > 3) {
            System.out.println("Geçersiz değer, tekrar giriniz: ");
            selectCase = input.nextInt();
        }
        switch (selectCase) {
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmour();
                break;
            case 3:
                System.out.println("Bir Daha Bekleriz!!!");
                return true;
        }

        return true;
    }

    public void printWeapon() {
        System.out.println("-----------Silahlar----------");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + " :Para: " + w.getPrice() + " ,Hasar: " + w.getDamage());
        }
    }

    public void buyWeapon (){
        System.out.print("Bir silah seçin:");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Geçersiz değer, tekrar giriniz: ");
            selectWeaponID = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
        if(selectedWeapon!= null){
            if(selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                System.out.println("Yeterli Paranız bulunmamaktadır.");
            }else {
                System.out.println(selectedWeapon.getName() + "Silahını aldınız");
                int balance = this.getPlayer().getMoney()-selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız: "+ this.getPlayer().getMoney());
                System.out.println("Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Yeni silahınız: "+ this.getPlayer().getInventory().getWeapon().getName());
            }
        }

    }

    public void printArmour() {
        System.out.println("Zırhlar");
    }
}
