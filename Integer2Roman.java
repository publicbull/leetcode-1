public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[] huns = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuffer buf =new StringBuffer();
        while(num>=1000) {
            buf.append("M");
            num-=1000;
        }
        buf.append(huns[num/100]);
        num%=100;
        buf.append(tens[num/10]);
        num%=10;
        buf.append(ones[num]);
        return buf.toString();        
    }
}
