
public class Space implements SpaceInterface {

    String name;
    boolean isPurchasable;
    int spaceCost;
    Player owner;
    int rent;
    boolean ismonopoly = false;



    public Space() {
        isPurchasable = true;
    }

    public boolean getIsPurchasable(){
        return isPurchasable;
    }

    public void addRentMoneyToOwnerOfSpace(){
        owner.money = owner.money + rent;
    }

    public String getOwnerName() {
        return owner.getName();
    }
    public void setOwner(Player player){
        owner = player;
    }

    public String getName() {
        return name;
    }
}
