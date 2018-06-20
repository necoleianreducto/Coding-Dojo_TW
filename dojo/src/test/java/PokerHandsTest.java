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
        Hand playerOne = new Hand("4H","4D","5S","9C","KD");
        Hand playerTwo = new Hand("3C","3H","4S","8C","AH");

        assertEquals(playerOne.compareHand(playerTwo), "Lose");
    }

    @Test
    public void twoPairToOnePair(){
        Hand playerOne = new Hand("2H","2D","9S","9C","KD");
        Hand playerTwo = new Hand("3C","3H","4S","8C","AH");

        assertEquals(playerOne.compareHand(playerTwo), "Win");
    }

    @Test
    public void twoPairToTwoPair(){
        Hand playerOne = new Hand("2H","2D","9S","9C","KD");
        Hand playerTwo = new Hand("3C","3H","4S","4C","AH");

        assertEquals(playerOne.compareHand(playerTwo), "Win");
    }

    @Test
    public void twoPairToTwoPairSameOnePair(){
        Hand playerOne = new Hand("2H","2D","9S","9C","KD");
        Hand playerTwo = new Hand("2C","2H","4S","4C","AH");

        assertEquals(playerOne.compareHand(playerTwo), "Win");
    }

    @Test
    public void twoPairToTwoPairHighCard(){
        Hand playerOne = new Hand("2H","2D","9S","9C","KD");
        Hand playerTwo = new Hand("2C","2H","9D","9H","AH");

        assertEquals(playerOne.compareHand(playerTwo), "Lose");
    }

    @Test
    public void ThreeOfKindsToTwoPair(){
        Hand playerOne = new Hand("2H","2D","2S","9C","KD");
        Hand playerTwo = new Hand("3C","3H","9D","9H","AH");

        assertEquals(playerOne.compareHand(playerTwo), "Win");
    }
}

//TODO AD,JD,2C,7H,3D Highcard to KD,TS,2C,6H,2D Pair Player 1 Wins
//TODO AD,JD,2C,7H,3D Highcard to KD,KS,2C,6H,2D Two Pairs Player 2 Wins
//TODO AD,JD,2C,7H,3D Highcards to KD,KS,KC,6H,2D Three of a Kind Player 2 Wins
//TODO AD,JD,2C,7H,3D Highcards to TD,JD,QC,KH,AD Straight Player 2 Wins
//TODO AD,JD,2C,7H,3D Highcards to 2D,JD,QD,KD,AD Flush Player 2 Wins
//TODO AD,JD,2C,7H,3D Highcards to 2D,2C,2H,KD,KH Full House
//TODO AD,JD,2C,7H,3D Highcards to Four of Kind
//TODO AD,JD,2C,7H,3D Highcards to Straight Flush