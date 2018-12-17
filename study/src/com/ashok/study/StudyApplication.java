package com.ashok.study;

import com.ashok.work.ArraySum;
import com.ashok.work.DivisorCount;
import com.ashok.work.MagicArray;

public class StudyApplication {

  public static void main(String[] args) throws Exception {

    MagicArray magicArray = new MagicArray();
    magicArray.getOptimizedCount();

    ArraySum aArraySum = new ArraySum();
    aArraySum.getMinimumValue();

    DivisorCount dDivisorCount = new DivisorCount();
    dDivisorCount.getDivisorCount();

  }
}
