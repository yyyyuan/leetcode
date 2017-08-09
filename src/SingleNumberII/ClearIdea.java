public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        int Third = 0;
        
        for (int n : nums) {
            twos = twos | (ones & n);   // If ones has that number, we add it intot the twos.
            
            /* If ones has that number, we remove it from ones, note that we are not able to check if this is the third time,
              which means that if this is the third time, we still need to add it into the ones now, but we could remove it 
              in the next step.
            */
            ones = ones ^ n;   
            
            /* In the third number check, we know that both onesand twos have the number which appears third time, so we know
                that the "AND" between ones and twos will still keep this number, then we could use that number to remove itself
                from both ones and twos.
            */
            Third = (ones & twos);
            
            // Here we remove this appeared-third-times number from both ones and twos.
            ones = ones & (~Third);
            twos = twos & (~Third);
        }   
        
        return ones;
    }
}
