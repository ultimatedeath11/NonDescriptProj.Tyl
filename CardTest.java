package PlayingCards;

public class CardTest
{

  public static void main(String[] args)
  {
   Card card = new Card(11, "Jack", "diamonds");
   System.out.println(card.isRed());
   System.out.println(card.isFaceCard());
   System.out.println(card.getValue());
   System.out.println(card.getName());
   System.out.println(card.getSuit());
   card.setValue(5);
   System.out.println(card.getValue());
   System.out.println(card);
   Deck deck = new Deck(false, false);
   System.out.println(deck);
   System.out.println(deck.getValue(5));
  }
}
