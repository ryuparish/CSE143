import java.util.*;

public class ArrayListClient{
    
    public static class ArrayIntList{
        private int[] elementData;
        private int size;

        public ArrayIntList(){
            elementData = new int[10];
            size = 0;
        }

        public void add(int number){
            elementData[size++] = number;
        }

        // pre: 0 <= index < size()
        // post: returns the value at the given
        public int get(int index){
            if(index < 0 || index > this.size()){
                throw new IllegalArgumentException();
            }
            else{return elementData[index];}
        }

        public int size(){
            return size;
        }

        public void setSize(int size){
            this.size = size;
        }

        // Sets all values to zero and then sets the size to zero as well
		public void clear() {
            for (int i = 0; i < size; i++) {
                elementData[i] = 0;
            }
            size = 0;
        }

		public int indexOf(int value) {
	        for (int i = 0; i < size; i++) {
	            if (elementData[i] == value) {
	                return i;
	            }
	        }
	        return -1;
	    }

        public boolean contains(int value){
            int index = indexOf(value);
            return index >= 0;
        }

        // Called when system.out.println() is called on this object
        public String toString() {

	        // If the list is empty	
		    if (size == 0) {
		        return "[]";
		    } 

            // If the list is not empty
			else {
		        String result = "[" + elementData[0];
		        for (int i = 1; i < size; i++) {
		            result += ", " + elementData[i];
		        }
		        result += "]";
		        return result;
		    }
		} 
    }

    public static void main(String[] args){
        ArrayIntList list1 = new ArrayIntList();
        ArrayIntList list2 = new ArrayIntList();
        list1.add(1);
        list2.add(2);
        list1.add(3);
        System.out.println(list1);
        System.out.println(list2);
    }
}
