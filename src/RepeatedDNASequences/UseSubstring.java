public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String dna = s.substring(i, i + 10);
            if (!seen.add(dna)) repeated.add(dna);
        }
        return new ArrayList(repeated);
    }
}
