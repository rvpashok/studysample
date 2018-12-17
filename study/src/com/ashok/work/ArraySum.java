package com.ashok.work;

import java.util.Scanner;

public class ArraySum {
  public ArraySum() {

  }

  @SuppressWarnings("resource")
  public void getMinimumValue() {

    Scanner scanner = new Scanner(System.in);

    int length = Integer.parseInt(scanner.nextLine());
    String[] elements = scanner.nextLine().split(" ");
    long sum = 0;
    for (int i = 0; i < length; i++) {
      sum = sum + Integer.parseInt(elements[i]);
    }
    int a = (int) (sum / length);

    System.out.println(a + 1);

  }
}
