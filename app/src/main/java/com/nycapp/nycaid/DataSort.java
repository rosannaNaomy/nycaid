package com.nycapp.nycaid;

import com.nycapp.nycaid.Model.FoodGrab;
import com.nycapp.nycaid.Model.TestSite;

import java.util.Collections;
import java.util.List;

public class DataSort {

    public static void sortGNGListAlphabetically(List<FoodGrab> foodGrabList) {
        Collections.sort(foodGrabList);
    }

    public static void sortTestListAlphabetically(List<TestSite> testList) {
        Collections.sort(testList);
    }
}
