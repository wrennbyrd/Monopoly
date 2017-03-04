import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Application {


    public static void main(String[] args) {

        Setup setUp= new Setup();


        ArrayList<SpaceInterface> spaces = setUp.buildingSpacesOnBoard();

        LuxuryTaxSpace luxuryTax = (LuxuryTaxSpace) spaces.get(6);

        int luxuryTaxBalance = luxuryTax.charge;

        FreeParkingSpace freeParkingSpace = (FreeParkingSpace) spaces.get(3);

        Space parkPlace = (Space) spaces.get(5);
        Space boardWalk = (Space) spaces.get(7);

        Player tempVar = null;
        HashMap<String, Player> list = setUp.setUpPlayers();
        Player currentPlayer = list.get("PlayerOne");
        Player nextPlayer = list.get("PlayerTwo");

        int turnIndex = 0;

        while(list.get("PlayerOne").money > 0 && list.get("PlayerTwo").money > 0 && turnIndex < 100) {
            System.out.println("\nIt's " + currentPlayer.name + " turn\n");

            roll(currentPlayer, luxuryTaxBalance, freeParkingSpace);

            SpaceInterface currentSpace = spaces.get(currentPlayer.currentSpaceIndex);

            //determine if the space is a regular purchaseable space
            if (currentSpace.getIsPurchasable()) {
                Space currentRegularSpace = (Space)currentSpace;
                takeActionOnRegularSpace(currentPlayer, currentRegularSpace, parkPlace, boardWalk);
            }

            turnIndex++;
            tempVar = currentPlayer;

            currentPlayer = nextPlayer;
            nextPlayer = tempVar;
        }

    }



    static void takeActionOnRegularSpace(Player player, Space currentSpace, Space parkPlace, Space boardWalk) {

        //check if the space has already been purchased
        if (currentSpace.owner == null){
            if (player.money > currentSpace.spaceCost) {
                purchaseASpace(player, currentSpace);
            }

            if (parkPlace.owner != null && boardWalk.owner != null) {
                if (parkPlace.owner.name == player.name && boardWalk.owner.name == player.name){
                    getAMonopoly(parkPlace, boardWalk);
                }
            }

        }  else {
            if (currentSpace.getOwnerName() != player.name){
               payRentToOwner(player, currentSpace);
            }
        }
    }

    static void payRentToOwner(Player player, Space currentSpace){
        player.money = player.money - currentSpace.rent;
        currentSpace.addRentMoneyToOwnerOfSpace();
        System.out.println(player.name + " is paying " + currentSpace.rent + " to " + currentSpace.getOwnerName());
    }

    static void getAMonopoly(Space parkPlace, Space boardWalk) {
        parkPlace.ismonopoly = true;
        boardWalk.ismonopoly = true;

        parkPlace.rent = 200;
        boardWalk.rent = 300;
    }

    static void purchaseASpace (Player player, Space currentSpace){

        player.money = player.money - currentSpace.spaceCost;

        currentSpace.setOwner(player);

        System.out.println(player.name + " bought " + currentSpace.name + " and has " + player.money + " left");

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

        if (newSpace == 3){

            currentPlayer.money = freeparking.balance + currentPlayer.money;

            freeparking.balance = 0;

            if (freeparking.balance != 0){
                System.out.println(currentPlayer.name + " Congrats you won the $ " + freeparking.balance + " from free parking");
            }


        }


        currentPlayer.currentSpaceIndex = newSpace;
    }



}
