
public class FreeParkingSpace implements SpaceInterface {

    String name;
    int balance;
    boolean isPurchasable;


    public FreeParkingSpace() {
        isPurchasable = false;
        balance = 0;
    }

    public boolean getIsPurchasable(){
        return isPurchasable;
    }
}

