// This is my solution to this question, I use string in that case, but it's apparently that using StringBuilder will improve the speed.

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        String result = "";
        boolean positive = true;
        
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);


        
        if (numerator < 0) {
            positive = false;
        }
        
        if (denominator < 0) {
            positive = positive == true ? false : true;
        }
        
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        long decimal = num / den;
        long remainder = num % den;
        result += decimal;
        
        
        if (remainder == 0) {
            if (decimal == 0) return result;
            return positive ? result : ("-" + result);    
        } 
        result += ".";
        
        String fractional = "";
        int index = 0;
        map.put(remainder, index);
        
        while (remainder != 0) {
            long digit = (remainder * 10) / den;
            remainder = (remainder * 10) % den;
            index++;
            if (!map.containsKey(remainder)) {
                map.put(remainder, index);
                fractional += digit;
            }
            else {
                fractional += digit;
                index = map.get(remainder);
                if (index == 0) {
                    result += "(" + fractional + ")";
                    return positive ? result : ("-" + result);
                }
                
                String repeated = fractional.substring(index);
                String nonRepeated = fractional.substring(0, index);
        
                result += nonRepeated;
                result += "(" + repeated + ")";
                return positive ? result : ("-" + result);               
            }
        }
        
        result += fractional;
        return positive ? result : ("-" + result);      
    }
}
