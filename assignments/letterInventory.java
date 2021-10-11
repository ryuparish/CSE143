public class LetterInventory{
    private int[] letterCount;
    private int totalLetters;
    public static final int ALPHABET_SIZE = 26; 

    // Creates Empty LetterInventory object
    public LetterInventory(){
        this("");
    }

    // Adds the number of each character in the given String data to the letterCount array
    public LetterInventory(String data) {
        data = data.toLowerCase();
        letterCount = new int[ALPHABET_SIZE];
        totalLetters = 0;
        for (int i = 0; i < data.length(); ++i) {
            char currentChar = data.charAt(i);
            if (Character.isAlphabetic(currentChar)) {
                letterCount[currentChar - 'a']++;
                totalLetters++;
            }
        }
    }

    // Getting the letter count of a specified letter
    // If the letter given is not alphabetic, an exception is thrown.
    public int get(char letter) {
        letter = Character.toLowerCase(letter);
        if (!Character.isAlphabetic(letter)) {
            throw new IllegalArgumentException("Retrieving a non-alphabetic character");
        }

        return letterCount[letter - 'a'];
    }

    // Setting the letter given to a given count
    // If character is not alphabetic we throw an exception
    public void set(char letter, int value) {
        letter = Character.toLowerCase(letter);

        if (!Character.isAlphabetic(letter)) {
            throw new IllegalArgumentException("Retrieving a non-alphabetic character");
        }
        totalLetters -= letterCount[letter - 'a'];
        totalLetters += value;
        letterCount[letter - 'a'] = value;
    }

    // Returns int totalLetters accumulated
    public int size() {
        return this.totalLetters;
    }

    // If there are 0 total letters, we return false.
    public boolean isEmpty() {
        return this.totalLetters == 0;
    }

    // We return a string of letters that shows the inventory of total letters.
    public String toString(){
        String inventory = new String("[");

        for (int i = 0; i < letterCount.length; ++i) {
            int currentLetterCount = letterCount[i];

            for (int j = 0; j < currentLetterCount; ++j) {
                inventory += (char) ('a' + i);
            }
        }

        return inventory + "]";
    }

    /*
       We add the counts of given LetterInventory
       object, other, to a duplicate of this LetterInventory object
       Returns a combined LetterInventory object
    */
    public LetterInventory add(LetterInventory other) {
        LetterInventory sumInventory = new LetterInventory(this.toString());
        
        for (int i = 0; i < ALPHABET_SIZE; ++i) {
            char currentChar = (char) ('a' + i);
            sumInventory.set(currentChar, other.get(currentChar) +
                sumInventory.get(currentChar));
        }

        return sumInventory;
    }
    
    /*
       We subtract the counts of a given LetterInventory object, other, to a 
       duplicate of this LetterInventory object. Return a combined 
       LetterInventory object, or null if a negative count occurs
    */
    public LetterInventory subtract(LetterInventory other) {
        LetterInventory differenceInventory = new LetterInventory(this.toString());
        
        for (int i = 0; i < ALPHABET_SIZE; ++i) {
            char currentChar = (char) ('a' + i);
            int countDifference = differenceInventory.get(currentChar) -
                other.get(currentChar);

            if (countDifference < 0) {
                return null;
            }

            differenceInventory.set(currentChar, countDifference);
        }

        return differenceInventory;

    }

}
