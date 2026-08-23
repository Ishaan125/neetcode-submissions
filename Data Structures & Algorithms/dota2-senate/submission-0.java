class Solution {
    public String predictPartyVictory(String senate) {
        StringBuilder str = new StringBuilder(senate);
        int count = 0;
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == 'R') {
                if (count < 0) {
                    str.append("D");
                }
                count++;
            }
            else {
                if (count > 0) {
                    str.append("R");
                }
                count--;
            }
            i++;
        }
        return count > 0 ? "Radiant" : "Dire";
    }
}

//  rrddd rddd  ddd   ddr  drr rr  rd d  r
//  rrddd rdddr dddrr ddrr drr rrd rd dr r
//  0     1     2     1    0   -1  0  1  0