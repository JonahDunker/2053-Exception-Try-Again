import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
//import java.util.*;
import java.util.InputMismatchException;

public class ExceptionTryAgain {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    Scanner fin = null;
    boolean exception = true;
    while(exception) {
      try {
        fin = new Scanner(new File(in.nextLine()));
        exception = false;
      } catch(FileNotFoundException e) {
        System.out.println("Please input an existing file name.");
      }
    }
    int length = Integer.parseInt(fin.nextLine());
    int lines = 0;
    int doubles = 0;
    int nonnumerics = 0;
    int sum = 0;
    ArrayList<Integer> arr = new ArrayList<>();
    while(fin.hasNextLine()) {
      String line = fin.nextLine();
      try {
        arr.add(Integer.parseInt(line));
      } catch(NumberFormatException e) {
        if(line.indexOf(".") != -1) {
          line = line.substring(0, line.indexOf("."));
          arr.add(Integer.parseInt(line));
          doubles++;
        } else {
          arr.add(line.length());
          nonnumerics++;
        }
      }
      lines++;
    }
    for(int i = 0; i < arr.size(); i++) {
      sum += arr.get(i);
    }
    if(lines != length) {
      System.out.println("The value in the file is not representative of the amount of data");
    }
    System.out.printf("Sum of values: %d\n"+
    "Number of doubles read in as ints: %d\n"+
    "Number of non-numeric values: %d",
    sum,doubles,nonnumerics);
  }
}