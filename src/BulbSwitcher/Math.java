// The case where one bulb will be on is that the number of its location has odd number of facters, which means that it should be a square
// of a number.
class Solution {
    public int bulbSwitch(int n) {
        if (n == 0) return 0;
        int count = 1;
        for (; count * count <= n; count++) {};
        return count - 1;
    }
}
