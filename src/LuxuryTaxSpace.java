
public class LuxuryTaxSpace implements SpaceInterface {

    String name;
    int charge;
    boolean isPurchasable;

    public LuxuryTaxSpace() {
        isPurchasable = false;
    }

    public boolean getIsPurchasable(){
        return isPurchasable;
    }

    public String getName() {
        return name;
    }

}
