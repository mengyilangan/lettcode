package com.lettcode.mylg.compition.weekly375;

public class Solution100143 {
    public int countTestedDevices(int[] batteryPercentages) {
        //减值
        int declime = 0;
        //设备为0
        int device = 0;

        for (int battery : batteryPercentages) {
            if (battery <= declime) {
                continue;
            }
            device += 1;
            declime += 1;
        }
        return device;
    }
}
