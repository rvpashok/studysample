package com.ashok.work;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MagicArray {

  public MagicArray() {

  }

  public void getOptimizedCount() throws Exception {
    BufferedReader bufferStr = new BufferedReader(new InputStreamReader(System.in));

    String[] bufferArr = bufferStr.readLine().split(" ");
    int nArrLength = Integer.parseInt(bufferArr[0]);
    int kArrLength = Integer.parseInt(bufferArr[1]);
    bufferArr = bufferStr.readLine().split(" ");
    int sourceArr[] = new int[nArrLength];
    int inputIdx = 0;
    for (String arr : bufferArr) {
      sourceArr[inputIdx] = Integer.parseInt(arr.trim());
      inputIdx++;
    }
    Arrays.sort(sourceArr);

    int optimizedResult = 0;
    Integer newProcessArr[] = new Integer[nArrLength];
    int nArrCount = 0;
    for (int idx = 0; idx < nArrLength; idx++) {
      int elem = sourceArr[idx];
      int divisorCount = 2;
      for (int divisor = 2; divisor < elem; divisor++) {
        if (elem % divisor == 0) {
          divisorCount++;
        }
        if (4 <= divisorCount) {
          break;
        }
      }
      if (divisorCount == 3) {
        sourceArr[idx] = -1;
        optimizedResult++;
      } else {
        newProcessArr[nArrCount] = sourceArr[idx];
        nArrCount++;
      }
    }
    int remainingCount = kArrLength - optimizedResult;
    if (remainingCount < 0 || (remainingCount == 0 && nArrLength != kArrLength)) {
      System.out.println(nArrLength - kArrLength);
    } else if (remainingCount == 0 && nArrLength == kArrLength) {
      System.out.println(0);
    } else if (remainingCount > 0) {
      int incrementType = 1;
      boolean loopContinue = true;
      optimizedResult = 0;
      while (loopContinue) {
        for (int j = 0; j < newProcessArr.length; j++) {
          if (newProcessArr[j] != null && newProcessArr[j] > 0) {
            int elem = newProcessArr[j] + incrementType;
            if (elem > 0) {
              int divisorCount = 2;
              for (int divisor = 2; divisor < elem; divisor++) {
                if (elem % divisor == 0) {
                  divisorCount++;
                }
                if (4 <= divisorCount) {
                  break;
                }
              }
              if (divisorCount == 3) {
                newProcessArr[j] = -1;
                if (incrementType < 0) {
                  optimizedResult = (-incrementType) + optimizedResult;
                } else {
                  optimizedResult = incrementType + optimizedResult;
                }
                remainingCount--;
              }
              if (remainingCount == 0) {
                loopContinue = false;
                break;
              }
            }
          }

        }
        if (incrementType > 0) {
          incrementType = -incrementType;
        } else {
          incrementType = (-incrementType) + 1;
        }
      }
      if (remainingCount == 0) {
        for (int k = 0; k < newProcessArr.length; k++) {
          if (newProcessArr[k] != null && newProcessArr[k] != -1) {
            optimizedResult++;
          }
        }
      }
      System.out.println(optimizedResult);
    }

  }
}
