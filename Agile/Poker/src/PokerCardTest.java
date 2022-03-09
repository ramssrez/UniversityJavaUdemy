import java.util.Set;

public class PokerCardTest {
    public static void main(String[] args) {
        Set<String> suiset = PokerCard.suitSet();
        for (String suit : suiset){
            System.out.println(suit);
        }
    }
}
