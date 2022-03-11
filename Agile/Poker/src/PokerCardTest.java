import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PokerCardTest {
    public static void main(String[] args) {
        Set<String> suiset = PokerCard.suitSet();
        for (String suit : suiset){
            System.out.println(suit);
        }

        PokerCard card1 = new PokerCard(PokerCard.SUIT_SPADES,1);
        PokerCard card2 = new PokerCard(PokerCard.SUIT_CLOVERS,13);
        PokerCard card3 = new PokerCard(PokerCard.SUIT_CLOVERS,12);
        PokerCard card4 = new PokerCard(PokerCard.SUIT_CLOVERS,11);
        PokerCard card5 = new PokerCard(PokerCard.SUIT_CLOVERS,1);
        Set<PokerCard> cardSet = new HashSet<>(Arrays.asList(card1,card2,card3,card4,card5));
        for (PokerCard car: cardSet){
            System.out.println(car);
        }

    }
}
