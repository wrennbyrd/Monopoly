import java.util.ArrayList;
import java.util.HashMap;

public class Setup {


    HashMap<String, Player> setUpPlayers (){

        Player currentPlayer;
        Player nextPlayer;

        Player playerOne = new Player();
        Player playerTwo= new Player();

        playerOne.name = "Courtnee";
        playerTwo.name = "Mike";

        HashMap<String, Player> listOfPlayers = new HashMap<>();
        listOfPlayers.put("PlayerOne", playerOne);
        listOfPlayers.put("PlayerTwo", playerTwo);

        return listOfPlayers;
    }


    ArrayList<SpaceInterface> buildingSpacesOnBoard(){

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

    public void printOwnersOfSpaces(ArrayList<SpaceInterface> spaces) {

        for (SpaceInterface currentSpace: spaces) {
            System.out.println("This Space is called: " + currentSpace.getName());
        }

    }




}
