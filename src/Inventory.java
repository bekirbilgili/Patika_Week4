public class Inventory {
    private Weapon weapon;
    private Armour armour;

    public Inventory() {
    this.weapon = new Weapon("Yumruk",0,0,0);
    this.armour = new Armour(0,"Paçavra",0,0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }
}
