package tests.set;

import org.junit.jupiter.api.Test;
import problems.set.PowerSet;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PowerSetTest {

    private PowerSet powerSet;

    @Test
    void general() {
        powerSet = new PowerSet();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        ArrayList<ArrayList<Integer>> res = powerSet.getSubsets(input, 0);
        System.out.println(res);
    }
}