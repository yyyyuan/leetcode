public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder result = new StringBuilder();
                
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        result.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");

        // Decimal part
        result.append(num / den);
        num %= den;
        
        if (num == 0) return result.toString();
        
        // Fractional part
        result.append(".");
        
//        int index = result.length();
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, result.length());
        
        while (num != 0) {
            num *= 10;
            result.append(num / den);
            num %= den;
//            index++;
            
            if (map.containsKey(num)) {
                int index = map.get(num);
                result.insert(index, "(");
                result.append(")");
                break;
            }
            else map.put(num, result.length());
        }    
        return result.toString();
    }
}
