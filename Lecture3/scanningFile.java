public class Solution{
    public static int countUnique(Scanner input) {
        int count = 0;
        while (input.hasNext()){
            String word = input.next();
            count++;
        }
        return count;
    }
}
