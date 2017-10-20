public class Solution {
    // The math shows that the result product is a product of 2 and 3, so I manipulate 3 as many times as possible and times the last n < 4 to get the result.
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int product = 1;
        while(n>4){
            product*=3;
            n-=3;
        }
        product*=n;
        
        return product;
    }
}
