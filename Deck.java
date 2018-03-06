package PlayingCards;

public class Deck
{
  private Card[] deck = new Card[52];
  private static String[] suits = {"hearts", "diamonds", "clubs", "spades"};
  private static String[] names = {"Ace", "two", "three", "four", "five", "six", "seven", 
                                    "eight", "nine", "ten", "jack", "queen", "king"};
  private boolean aceHigh;
  private boolean jokers;
  private int size;
  public Deck(boolean aceHigh, boolean jokers) //constructor with high ace and joker params.
  {
    this.aceHigh = aceHigh; 
    this.jokers = jokers;
  
    if(jokers) //add jokers if jokers is true.
    {
      deck = new Card[54]; //initializes again with two more Cards
      deck[52] = new Card(-1, "joker", "wildCard"); //default value for joker is (-1)
      deck[53] = new Card(-1, "joker", "wildCard"); //"                             "
    }
    
    size = deck.length; //initialize size after jokers are placed or not.

    for(int i = 0; i < 52; i+=4) //really convoluted way of creating deck. Creates deck in order.
    {
      deck[i] = new Card(i/4 + 1, names[i/4], suits[0]);   //hearts
      deck[i+1] = new Card(i/4 + 1, names[i/4], suits[1]); //diamonds
      deck[i+2] = new Card(i/4 + 1, names[i/4], suits[2]); //clubs
      deck[i+3] = new Card(i/4 + 1, names[i/4], suits[3]); //spades
    }
    if (aceHigh) //changes values if ace high is true.
    {
      for(int i = 0; i < 4; i++)
      {
        deck[i].setValue(13); //aces are set to 13 one greater than king
      }
    }
  }
  
  public Card getValue(int index) //return card at given index. Needs work
  {
    return deck[index];
  }


  
  @Override
  public String toString() //overriding to String for correct print format
  {
    String outPut = "";
   for(Card current: deck)
    outPut += (current.toString() + "\n");
   return outPut;
  }


}
