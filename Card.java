package PlayingCards;

public class Card
{
  private int value; //point value of card
  private String name; //card name ex: "king", "four"
  private String suit; //card suit ex: "hearts", "clubs"
  
  public Card(int value, String name, String suit)
  {
    this.value = value; //initializing variables
    this.name = name;
    this.suit = suit;
  }

  public boolean isFaceCard() //method for checking if card is face card (excludes ace)
  {
    if (value > 10 || value < 14)
      return true;
    return false;
  }

  public boolean isRed() // return true if card is red and false is card is black
  {
    if (suit.equals("diamonds") || suit.equals("hearts"))
      return true;
    return false;
  }
  
  //getters/setters
  public void setValue(int value) {this.value = value;}

  public int getValue() {return value;}

  public String getName() {return name;}

  public String getSuit() {return suit;}
    
  @Override
  public String toString() //overridden toString for formatting
  {
    return (name + " of " + suit + "\n");
  }
}  
