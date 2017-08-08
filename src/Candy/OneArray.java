public class Solution {
    public int candy(int[] ratings) {
        int[] array = new int[ratings.length];
        Arrays.fill(array, 1);
        
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) array[i] = array[i - 1] + 1;
        }
        
        int candies = array[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) array[i] = Math.max(array[i], array[i + 1] + 1);
            candies += array[i];
        }
        

        
        return candies;
        
    }
}
