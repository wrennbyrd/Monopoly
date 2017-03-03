import java.lang.reflect.Array;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {

        int turnIndex = 0;

        ArrayList<SpaceInterface> spaces = buildingSpacesOnBoard();
        LuxuryTaxSpace luxuryTax = (LuxuryTaxSpace) spaces.get(6);
        int luxuryTaxBalance = luxuryTax.charge;

        Player playerOne= new Player();

        playerOne.name = "Courtnee";

        FreeParkingSpace freeParkingSpace = (FreeParkingSpace) spaces.get(3);


        while(playerOne.money > 0 && turnIndex < 100) {


            roll(playerOne, luxuryTaxBalance, freeParkingSpace);

            SpaceInterface currentSpace = spaces.get(playerOne.currentSpaceIndex);

            //determine if the space is a regular purchaseable space
            if (currentSpace.getIsPurchasable()) {
                Space currentRegularSpace = (Space)currentSpace;
                buySpace(playerOne, currentRegularSpace);
            }

            turnIndex++;
        }

    }

    static void buySpace(Player player, Space currentSpace) {

        //check if the space has already been purchased
        if (currentSpace.owner == ""){

            //purchasing the space
            if (player.money > currentSpace.spaceCost) {
                player.money = player.money - currentSpace.spaceCost;
                currentSpace.owner = player.name;
                System.out.println(player.name + " bought " + currentSpace.name + " and has " + player.money + " left");
            }

        //paying rent to the owner
            //todo pay rent to another player not self
        }  else {
            player.money = player.money - currentSpace.rent;

            System.out.println("Pay Rent " + currentSpace.rent);
        }

    }

        static ArrayList<SpaceInterface> buildingSpacesOnBoard(){

            Space go = new Space();
            go.name = "Go";
            go.isPurchasable = false;

            Space stCharlesPlace = new Space();
            stCharlesPlace.name = "St. Charles Place";
            stCharlesPlace.spaceCost = 250;
            stCharlesPlace.rent = 50;

            Space virginia = new Space();
            virginia.name = "Virgina";
            virginia.spaceCost = 250;
            virginia.rent = 50;

            FreeParkingSpace freeParking = new FreeParkingSpace();
            freeParking.name = "Free Parking";


            Space maryland = new Space();
            maryland.name = "Maryland";
            maryland.spaceCost = 250;
            maryland.rent = 50;

            Space parkPlace = new Space();
            parkPlace.name = "Park place";
            parkPlace.spaceCost = 500;
            parkPlace.rent = 100;

            LuxuryTaxSpace luxuryTax = new LuxuryTaxSpace();
            luxuryTax.name = "LuxuryTax ";
            luxuryTax.charge = 50;


            Space boardWalk = new Space ();
            boardWalk.name = "Boardwalk";
            boardWalk.spaceCost = 550;
            boardWalk.rent = 150;


            ArrayList<SpaceInterface> spaces = new ArrayList();
            spaces.add(go);
            spaces.add(stCharlesPlace);
            spaces.add(virginia);
            spaces.add(freeParking);
            spaces.add(maryland);
            spaces.add(parkPlace);
            spaces.add(luxuryTax);
            spaces.add(boardWalk);

            return spaces;

        }

    //todo add a check that the player landed on free parking and earned the amount in the balance
    static void roll(Player currentPlayer, int balance, FreeParkingSpace freeparking){

        int rollValue = (int)(3.0 * Math.random()+ 1);

        int newSpace = currentPlayer.currentSpaceIndex + rollValue;

        if (newSpace > 7) {
            newSpace = newSpace - 7;

            if (currentPlayer.currentSpaceIndex >= 5 && newSpace >= 0) {
                currentPlayer.money = currentPlayer.money + 200;

                System.out.println( currentPlayer.name + " passed Go. You get $200");

            }
        }
        if (newSpace == 6){

            currentPlayer.money = currentPlayer.money - balance;
            freeparking.balance = freeparking.balance + balance;
            System.out.println(currentPlayer.name + " landed on luxury tax and paid $" + balance);
        }

        currentPlayer.currentSpaceIndex = newSpace;
    }



}
