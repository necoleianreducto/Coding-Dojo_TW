import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Hand {
    private List<String> cards = new ArrayList<>();
    private Map<String, Integer> values = new HashMap<String, Integer>();
    private Map<String, Integer> handValues = new HashMap<String, Integer>();
    private String handType;

    public String getHandType() {
        return handType;
    }

    public List<String> getCards() {
        return cards;
    }

    public Hand(String card1, String card2, String card3, String card4, String card5) {
        this.cards.add(card1);
        this.cards.add(card2);
        this.cards.add(card3);
        this.cards.add(card4);
        this.cards.add(card5);
        this.values.put("A", 14);
        this.values.put("K", 13);
        this.values.put("Q", 12);
        this.values.put("J", 11);
        this.values.put("T", 10);
        this.handValues.put("High Card", 1);
        this.handValues.put("Pair", 2);
        this.handType = classifyHand();
    }

    public String classifyHand() {
        String handType = "";

        List<String> tempList = new ArrayList<>();
        Map<String, Integer> pair = new HashMap<>();
        getSameCardMap(tempList, pair);
        if (pair.values().stream().filter(s -> s.equals(2)).count() == 1) {
            handType = "Pair";
        } else {
            handType = "High Card";
        }

        return handType;
    }

    private void getSameCardMap(List<String> tempList, Map<String, Integer> pair) {
        cards.stream().forEach(value -> tempList.add(value.substring(0, 1)));
        tempList.stream().forEach(getSameCardConsumer(pair));
    }

    public String compareHand(Hand hand) {
        if (getHandValue(hand.getHandType()) == getHandValue(handType)) {
            if (handType.equals("High Card")) {
                int cardA = getCardValue(getHighCard(cards).substring(0, 1));
                int cardB = getCardValue(getHighCard(hand.getCards()).substring(0, 1));
                if (cardA > cardB) {
                    return "Win";
                }
            } else if (handType.equals("Pair")) {
                List<String> pairList = new ArrayList<>();
                Map<String, Integer> pair = new HashMap<>();
                getSameCardMap(pairList, pair);
                int cardA = getCardValue(pair.entrySet().stream().filter(p -> p.getValue() == 2).findFirst().get().getValue().toString());
                int cardB = 

            }
        } else if (getHandValue(hand.getHandType()) < getHandValue(handType)) {
            return "Win";
        }
        return "Lose";
    }

    private Consumer<String> getSameCardConsumer(Map<String, Integer> pair) {
        return t -> {
            Integer i = pair.get(t);
            if (i == null) {
                i = 0;
            }
            pair.put(t, i + 1);
        };
    }

    public String getHighCard(List<String> cards) {
        String result = "";
        for (String card : cards) {
            if (result.equals("")) {
                result = card;
            } else {

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

    public int getHandValue(String hand) {
        int result;
        result = handValues.get(hand) != null ? handValues.get(hand) : Integer.parseInt(hand);
        return result;
    }
}
