class Solution {
    public String predictPartyVictory(String senate) {
        StringBuilder str = new StringBuilder(senate);

        int r = 0;
        int d = 0;

        for (char c : senate.toCharArray()) {
            if (c == 'R') {
                r++;
            } else {
                d++;
            }
        }

        int count = 0;
        int i = 0;

        while (r > 0 && d > 0) {
            if (str.charAt(i) == 'R') {
                if (count >= 0) {
                    str.append('R');
                } else {
                    r--;
                }
                count++;
            } else {
                if (count <= 0) {
                    str.append('D');
                } else {
                    d--;
                }
                count--;
            }

            i++;
        }

        return r > 0 ? "Radiant" : "Dire";
    }
}

//  rrddd rddd  ddd   ddr  drr rr  rd d  r
//  rrddd rdddr dddrr ddrr drr rrd rd dr r
//  0     1     2     1    0   -1  0  1  0