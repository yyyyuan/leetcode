public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> seen = new HashSet<>(), repeated = new HashSet<>();
        List<String> result = new ArrayList<>();
        char[] map = new char[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        for (int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for (int j = i; j < i + 10; j++) {
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if (!seen.add(v) && repeated.add(v)) {
                result.add(s.substring(i, i + 10));
            }
        }
        return result;
    }
}
