package com.commandlinegirl.algorithms.interview;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

        public List<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
            List<Integer> result = new ArrayList<>();
            int m = a.size();
            int n = a.get(0).size();
            int t = 0;
            int r = n - 1;
            int l = 0;
            int b = m - 1;

            int dir = 0; // 0 - right, 1 - bottom, 2 - left, 3 - top
            while (t <= b && l <= r) {
                if (dir == 0) { // right
                    for (int i = l; i <= r; i++) {
                        result.add(a.get(t).get(i));
                        t++;
                        dir = 1;
                    }
                }
                else if (dir == 1) {
                    for (int i = t; i <= b; i++) {
                        result.add(a.get(i).get(r));
                        r--;
                        dir = 2;
                    }
                }
                else if (dir == 2) {
                    for (int i = r; i >= l; i--) {
                        result.add(a.get(b).get(i));
                        b--;
                        dir = 3;
                    }
                }
                else if (dir == 3) {
                    for (int i = b; i >= t; i--) {
                        result.add(a.get(i).get(l));
                        l++;
                        dir = 0;
                    }
                }
                dir = (dir + 1) % 4;
            }

            return result;
        }
}
