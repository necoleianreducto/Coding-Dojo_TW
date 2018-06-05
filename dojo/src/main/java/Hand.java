import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hand {
  private List<String> cards = new ArrayList<String>();
  private Map<String, Integer> values = new HashMap<String, Integer>();

  public List<String> getCards() {
    return cards;
  }

  public Hand(String card1, String card2, String card3, String card4, String card5) {
    this.cards.add(card1);
    this.cards.add(card2);
    this.cards.add(card3);
    this.cards.add(card4);
    this.cards.add(card5);
    values.put("A", 14);
    values.put("K", 13);
    values.put("Q", 12);
    values.put("J", 11);
    values.put("T", 10);
  }

  public classifyHand(){

  }

  public String compareHand(Hand hand) {
    //int cardA = values.get(getHighCard(cards).substring(0, 1)) != null ? values.get(getHighCard(cards).substring(0, 1)) : Integer.parseInt(getHighCard(cards).substring(0, 1));
    //int cardB = values.get(getHighCard(hand.getCards()).substring(0, 1)) != null ? values.get(getHighCard(hand.getCards()).substring(0, 1)) : Integer.parseInt(getHighCard(hand.getCards()).substring(0, 1));

    int cardA = getCardValue(getHighCard(cards).substring(0, 1));
    int cardB = getCardValue(getHighCard(hand.getCards()).substring(0, 1));

    if (cardA < cardB) {
      return "Lose";
    }
    return "Wins";
  }

  public String getHighCard(List<String> cards) {
    String result = "";
    for (String card : cards) {
      if (result.equals("")) {
        result = card;
        } else {
        //int cardA = values.getCardValue(result.substring(0, 1)) != null ? values.get(result.substring(0, 1)) : Integer.parseInt(result.substring(0, 1));
        //int cardB = values.get(card.substring(0, 1)) != null ? values.get(card.substring(0, 1)) : Integer.parseInt(card.substring(0, 1));
        int cardA = getCardValue(result.substring(0, 1));
        int cardB = getCardValue(card.substring(0, 1));

        if (cardA < cardB) {
          result = card;
          }
      }
    }
    return result;
  }



  public int getCardValue(String cards) {
    int result;
    result = values.get(cards) != null ? values.get(cards) : Integer.parseInt(cards);
    return result;
  }
}
