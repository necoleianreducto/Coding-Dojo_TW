import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PokerHandsTest {
    //AD,JD,2C,7H,3D Highcard to KD,TS,2C,6H,3D highcard Player 1 Wins
    @Test
    public void highCardToHighCard(){
        Hand playerOne = new Hand("KD","TS","2C","6H","3D");
        Hand playerTwo = new Hand("AD","JD","2C","7H","3D");

        assertEquals(playerOne.compareHand(playerTwo), "Lose");
    }

    // one pair > high cards - done 2H 2D 5S 9C KD 2C 3H 4S 8C AH Player 1 wins
    @Test
    public void pairToHighCard(){
        Hand playerOne = new Hand("2H","2D","5S","9C","KD");
        Hand playerTwo = new Hand("2C","3H","4S","8C","AH");

        assertEquals(playerOne.compareHand(playerTwo), "Win");
    }

    @Test
    public void pairToPairCard(){
        Hand playerOne = new Hand("2H","2D","5S","9C","KD");
        Hand playerTwo = new Hand("3C","3H","4S","8C","AH");

        assertEquals(playerOne.compareHand(playerTwo), "Lose");
    }
}



//    3.	one pair higer win - done 2H 2D 5S 9C KD 3C 3H 4S 8C AH Player 2 wins
//    4.	two pair > one pair - done 2H 2D 5S 9C KD 3C 3H 4S 4C AH Player 2 wins
//    5.	two pair highest win - done 2H 2D 9S 9C KD 3C 3H 4S 4C AH Player 1 wins
//    6.	two pair highest same, second higher win - done 2H 2D 9S 9C KD 3C 3H 9H 9D AH Player 2 wins
//    7.	two pair all same, high card win - done 3C 3D 9S 9C KD 3C 3H 9H 9D AH Player 2 wins
//    8.	three of kind > two pairs - done 3C 3D 3C 9C AD 4C 4H 9H 9D AH player 1 wins


//TODO AD,JD,2C,7H,3D Highcard to KD,TS,2C,6H,2D Pair Player 1 Wins
//TODO AD,JD,2C,7H,3D Highcard to KD,KS,2C,6H,2D Two Pairs Player 2 Wins
//TODO AD,JD,2C,7H,3D Highcards to KD,KS,KC,6H,2D Three of a Kind Player 2 Wins
//TODO AD,JD,2C,7H,3D Highcards to TD,JD,QC,KH,AD Straight Player 2 Wins
//TODO AD,JD,2C,7H,3D Highcards to 2D,JD,QD,KD,AD Flush Player 2 Wins
//TODO AD,JD,2C,7H,3D Highcards to 2D,2C,2H,KD,KH Full House
//TODO AD,JD,2C,7H,3D Highcards to Four of Kind
//TODO AD,JD,2C,7H,3D Highcards to Straight Flush