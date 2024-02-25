import models.Card;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CardTask {
    public static void main(String[] args) {
        List<Card> cardList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            LocalDate expiryDate = LocalDate.now().plusYears(i);
            Card card = new Card(String.valueOf(i), "fingerprint" + (i % 8 + 1), expiryDate);
            cardList.add(card);
        }

        System.out.println("Sample Card Data:");
        for (Card card : cardList) {
            System.out.println("ID: " + card.getId() + ", Fingerprint: " + card.getFingerPrint() + ", Expiry Date: " + card.getExpiryDate());
        }

        List<Card> filteredCardList = new ArrayList<>(cardList.stream()
                .collect(Collectors.groupingBy(Card::getFingerPrint,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Card::getExpiryDate)),
                                java.util.Optional::get)))
                .values());

        System.out.println("\nFiltered Card List:");
        for (Card card : filteredCardList) {
            System.out.println("ID: " + card.getId() + ", Fingerprint: " + card.getFingerPrint() + ", Expiry Date: " + card.getExpiryDate());
        }
    }
}
