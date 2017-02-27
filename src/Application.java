import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {

        Space go = new Space();
        go.name = "Go";
        go.spaceCost = 0;

        Space stCharlesPlace = new Space();
        stCharlesPlace.name = "St. Charles Place";
        stCharlesPlace.spaceCost = 250;
        stCharlesPlace.rent = 50;

        Space virginia = new Space();
        virginia.name = "Virgina";
        virginia.spaceCost = 250;
        virginia.rent = 50;

        Space maryland = new Space();
        maryland.name = "Maryland";
        maryland.spaceCost = 250;
        maryland.rent = 50;

        Space parkPlace = new Space();
        parkPlace.name = "Park place";
        parkPlace.spaceCost = 500;
        parkPlace.rent = 100;

        Space boardWalk = new Space ();
        boardWalk.name = "Boardwalk";
        boardWalk.spaceCost = 550;
        boardWalk.rent = 150;


        ArrayList<Space> spaces = new ArrayList();
        spaces.add(go);
        spaces.add(stCharlesPlace);
        spaces.add(virginia);
        spaces.add(maryland);
        spaces.add(parkPlace);
        spaces.add(boardWalk);

        Player playerOne= new Player();

        playerOne.name = "Courtnee";
        playerOne.currentSpace = 0;
        playerOne.money = 5000;

        while(playerOne.money > 0){

            playerOne.currentSpace = roll(playerOne.currentSpace);

            Space currentSpace = spaces.get(playerOne.currentSpace);

            buySpace(playerOne, currentSpace);
        }


    }

    //todo the player shouldn't be able to buy a space someone already owns
    static void buySpace(Player player, Space currentSpace) {
        player.money = player.money - currentSpace.spaceCost;

        currentSpace.owner = player;
        System.out.println(player.name + " bought " + currentSpace.name + " and has " + player.money + " left");
    }


    static int roll (int currentSpace){
        int rollValue = (int)(3.0 * Math.random()+ 1);

        int newSpace = currentSpace + rollValue;

        //wraping
        if (newSpace > 5) {
            newSpace = newSpace - 5;
        }

        return newSpace;
    }

}
