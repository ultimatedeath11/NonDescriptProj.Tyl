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
  
  public Card getCard(int index) //return card at given index. Needs work
  {
    if (index < 0 || index >= getSize()) //handling for index out of bounds
    {
      System.out.println("ERROR - Invalid input: " + index);
      return null;
    }
    return deck[index];
  }

  public int getValueAt(int index)
  {
    return getCard(index).getValue();
  }

  public void shuffle() //shuffle method. Swaps cards and simulates deck cut
  {
    Card swap; //card holder
    int numSwaps = 300; //number of swaps. 300 is arbitrary - change if needed.
    Card[] temp = new Card[getSize()]; //deck holder
    int randIndx = 51; //sudoRandom number for index position
    for(int i = 0; i <= numSwaps; i++) //swaps amount in numSwaps. Cuts on last swap.
    {
      randIndx = (int) (Math.random()*getSize()); //sudoRandom number from 0 to deck size
      swap = deck[randIndx]; //temp card holds random indexed value
      deck[randIndx] = deck[i%getSize()]; //random index is given i mod deck size (so all cards will swap)
      deck[i%getSize()] = swap; //index of card swapped is set to temp card - swap is complete
      if(i == numSwaps) // cut done after last swap
      {
        for(int i2 = 0; i2 < getSize() - randIndx; i2++) //iters amount of cards to be moved to bottom of deck
        {
          temp[i2] = deck[randIndx + i2]; //places index to getSize() on bottom of deck
        }
        for(int i2 = 0; i2 < randIndx; i2++)
        {
          temp[getSize() - randIndx + i2] = deck[i2]; //places former bottom cards on top
        }
        for(int i2 = 0; i2 < getSize(); i2++)
          deck[i2] = temp[i2]; //setting deck to temp
      }
    }
  }

  public int getSize()
  {
    return size; //returns deck size
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
