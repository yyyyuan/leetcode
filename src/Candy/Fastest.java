public class Solution {
    public int candy(int[] ratings) {
        int size = ratings.length;
        if (size <= 1) return size;
        int count = 0;
        int[] array = new int[size];
        array[0] = 1;
        for (int i = 0; i < size - 1; i++) {
            array[i + 1] = 1;
            if (ratings[i + 1] > ratings[i]) array[i + 1] = array[i] + 1;
        }
        
        for (int i = size - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) array[i - 1] = Math.max(array[i - 1], array[i] + 1);
        }
        
        for (int i = 0; i < size; i++) count += array[i];
        return count;
    }
}
