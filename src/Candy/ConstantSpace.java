public class Solution {
    public int candy(int[] ratings) {
        int candies  = 0;
        int oldScope = 0;
        int up = 0;
        int down = 0;
        
        for (int i = 1; i < ratings.length; i++) {
            int newScope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);
            
            if ((oldScope > 0 && newScope == 0) || (oldScope < 0 && newScope >= 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                down = 0;
                up = 0;
            }
            
            if (newScope > 0) up++;
            if (newScope < 0) down++;
            if (newScope == 0) candies++;
            
            oldScope = newScope;
        }
        
        return candies + count(up) + count(down) + Math.max(up, down) + 1;
        
    }
    
    private int count(int n) {
        return n * (n + 1) / 2;
    }
}
