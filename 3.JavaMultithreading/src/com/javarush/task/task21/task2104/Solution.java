package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    String first, second;

    public Solution(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
        return second != null ? second.equals(solution.second) : solution.second == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    static class MySolution extends Solution {
        String third;

        public MySolution(String first, String second, String third) {
            super(first, second);
            this.third = third;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution("first", "second");
        MySolution myS = new MySolution("first", "second", "third");
        System.out.println(s.equals(myS));
    }
}