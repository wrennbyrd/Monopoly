import java.lang.reflect.Array;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {

        int turnIndex = 0;

        ArrayList<Space> spaces = buildingSpacesOnBoard();


        Player playerOne= new Player();

        playerOne.name = "Courtnee";
        playerOne.currentSpaceIndex = 0;
        playerOne.money = 1000;

        while(playerOne.money > 0 && turnIndex < 50) {

            int nextSpaceToMoveTo = roll(playerOne.currentSpaceIndex, playerOne);
            playerOne.currentSpaceIndex = nextSpaceToMoveTo;


            Space currentSpace = spaces.get(playerOne.currentSpaceIndex);

            buySpace(playerOne, currentSpace);

            turnIndex++;
        }


    }

    static void buySpace(Player player, Space currentSpace) {

        if (currentSpace.owner == ""){

            if (player.money > currentSpace.spaceCost && currentSpace.isPurchasable) {
                player.money = player.money - currentSpace.spaceCost;
                currentSpace.owner = player.name;
                System.out.println(player.name + " bought " + currentSpace.name + " and has " + player.money + " left");
            }


        }  else {
            player.money = player.money - currentSpace.rent;

            System.out.println("Pay Rent " + currentSpace.rent);
        }

    }

        static ArrayList<Space> buildingSpacesOnBoard(){

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

            Space freeParking = new Space();
            freeParking.name = "Free Parking";
            freeParking.isPurchasable = false;


            Space maryland = new Space();
            maryland.name = "Maryland";
            maryland.spaceCost = 250;
            maryland.rent = 50;

            Space parkPlace = new Space();
            parkPlace.name = "Park place";
            parkPlace.spaceCost = 500;
            parkPlace.rent = 100;

            Space luxuryTax = new Space();
            luxuryTax.name = "LuxuryTax ";
            luxuryTax.isPurchasable = false;


            Space boardWalk = new Space ();
            boardWalk.name = "Boardwalk";
            boardWalk.spaceCost = 550;
            boardWalk.rent = 150;


            ArrayList<Space> spaces = new ArrayList();
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


    static int roll(int currentSpace, Player currentPlayer){



        int rollValue = (int)(3.0 * Math.random()+ 1);

        int newSpace = currentSpace + rollValue;

        //wraping
        if (newSpace > 7) {
            newSpace = newSpace - 5;
            //start on or before 0  and ended after 0
            if (currentSpace >= 5 && newSpace >= 0) {
                currentPlayer.money = currentPlayer.money + 200;

                System.out.println( currentPlayer.name + "passed Go. You get $200");

            }
        }

        return newSpace;
    }



}
