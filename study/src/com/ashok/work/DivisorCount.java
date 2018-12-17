package com.ashok.work;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DivisorCount {
  public DivisorCount() {

  }

  public void getDivisorCount() {
    Scanner s = new Scanner(System.in);
    String inputStr = s.nextLine();
    if (inputStr != null && !inputStr.isEmpty()) {
      String[] parsedInput = inputStr.split(" ");
      if (parsedInput.length > 0) {
        long firstNumber = Long.parseLong(parsedInput[0]);
        long secondNumber = Long.parseLong(parsedInput[1]);
        List<Long> resultList = new ArrayList<>();
        for (long divideNumber = 1; divideNumber < Math.pow(2, 3); divideNumber++) {
          if (firstNumber % divideNumber == 0 && secondNumber % divideNumber == 0) {
            resultList.add(divideNumber);
          }
        }
        System.out.println(resultList.size());
      }
    }
  }
}
