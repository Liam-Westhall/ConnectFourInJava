// Liam Westhall CSE114 ID#111403927
import java.util.InputMismatchException;
import java.util.Scanner;
public class ConnectFour {
 public static String[][] makePattern() {
  String[][] p = new String[7][15];
  for (int x = 0; x < p.length; x++) {
   for (int y = 0; y < p[x].length; y++) {
    if (y % 2 == 0) {
     p[x][y] = "|";
    } else {
     p[x][y] = " ";
    }
    if (x == 6)
     p[x][y] = "-";
   }
  }
  return p;
 }
 public static void printPattern(String[][] p) {
  for (int x = 0; x < p.length; x++) {
   for (int y = 0; y < p[x].length; y++) {
    System.out.print(p[x][y]);
   }
   System.out.println();
  }
 }
 public static void Red(String[][] p) {
  System.out.print("Drop a Red disk at column (0-6): ");
  Scanner input = new Scanner(System.in);
  try {
  int z = 2 * input.nextInt() + 1;
  for (int x = 5; x >= 0; x--) {
   if (p[x][z] == " ") {
    p[x][z] = "R";
    break;
    }
    }
   }
  catch(InputMismatchException ex){
  	System.out.println("Wrong input type, try again");
  	printPattern(p);
  	Red(p);
  }
  catch(IndexOutOfBoundsException ex) {
	  System.out.println("Index out of bounds, try again");
	  printPattern(p);
	  Red(p);
  }
 }
 public static void Yellow(String[][] p) {
  System.out.print("Drop a yellow disk at column (0-6): ");
  Scanner input = new Scanner(System.in);
  try {
  int z = 2 * input.nextInt() + 1;
  for (int x = 5; x >= 0; x--) {
   if (p[x][z] == " ") {
    p[x][z] = "Y";
    break;
   }
  }
  }
  catch(InputMismatchException ex) {
	  System.out.println("Wrong input, try again");
	  printPattern(p);
	  Yellow(p);
  }
  catch(IndexOutOfBoundsException ex) {
		  System.out.println("Index out of bounds, try again");
		  printPattern(p);
		  Yellow(p);
	  }
  }
 public static String findWinner(String[][] p) {
  for (int x = 0; x < 6; x++) {
   for (int y = 0; y < 7; y += 2) {
    if ((p[x][y + 1] != " ") && (p[x][y + 3] != " ") && (p[x][y + 5] != " ") && (p[x][y + 7] != " ") && ((p[x][y + 1] == p[x][y + 3]) && (p[x][y + 3] == p[x][y + 5]) && (p[x][y + 5] == p[x][y + 7]))) 
     return p[x][y + 1];
   }
  }
  for (int x = 1; x < 15; x += 2) {
   for (int y = 0; y < 3; y++) {
	   if ((p[y][x] != " ") && (p[y + 1][x] != " ") && (p[y + 2][x] != " ") && (p[y + 3][x] != " ") && ((p[y][x] == p[y + 1][x]) && (p[y + 1][x] == p[y + 2][x]) && (p[y + 2][x] == p[y + 3][x])))
     return p[y][x];
   }
  }
  for (int x = 0; x < 3; x++) {
   for (int y = 1; y < 9; y += 2) {
    if ((p[x][y] != " ") && (p[x + 1][y + 2] != " ") && (p[x + 2][y + 4] != " ") && (p[x + 3][y + 6] != " ") && ((p[x][y] == p[x + 1][y + 2]) && (p[x + 1][y + 2] == p[x + 2][y + 4]) && (p[x + 2][y + 4] == p[x + 3][y + 6]))) 
     return p[x][y];
   }
  }
  for (int x = 0; x < 3; x++) {
   for (int y = 7; y < 15; y += 2) {
    if ((p[x][y] != " ") && (p[x + 1][y - 2] != " ") && (p[x + 2][y - 4] != " ") && (p[x + 3][y - 6] != " ") && ((p[x][y] == p[x + 1][y - 2]) && (p[x + 1][y - 2] == p[x + 2][y - 4]) && (p[x + 2][y - 4] == p[x + 3][y - 6]))) 
     return p[x][y];
   }
  }
  return null;
 }
 public static void main(String[] args) {
  String[][] p = makePattern();
  boolean loop = true;
  int count = 0;
  printPattern(p);
  while (loop) {
   if (count % 2 == 0)
    Red(p);
   else
    Yellow(p);
   count++;
   printPattern(p);
   if (findWinner(p) != null) {
    if (findWinner(p) == "R") {
     System.out.print("The winner is Red!");
    } else if (findWinner(p) == "Y") {
     System.out.println("The winner is Yellow!");
    }
    loop = false;
   }
  }
 }
}