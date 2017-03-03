
public class Space implements SpaceInterface {

    String name;
    boolean isPurchasable;
    int spaceCost;
    String owner;
    int rent;

    public Space() {
        owner = "";
        isPurchasable = true;
    }

    public boolean getIsPurchasable(){
        return isPurchasable;
    }

}
