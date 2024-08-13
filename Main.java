import java.util.Random;
import java.util.*;

public class Main {
  public static void display(int[] array) {
    int i;
    for (int p = 10; p >= 1; p--) {
      if (p % 2 != 0)
        for (i = ((p - 1) * 10) + 1; i <= 10 * p; i++) {
          if (array[i] == -1)
            System.out.print("A ");
          else if (array[i] == -2)
            System.out.print("B ");
          else if (array[i] == 0)
            System.out.print("X ");
          else
            System.out.print(array[i] + " ");
          if (p == 1)// for first 10 to add a space
            System.out.print(" ");

        }

      else
        for (i = p * 10; i > (p - 1) * 10; i--)
          if (array[i] == -1)
            System.out.print("A ");
          else if (array[i] == -2)
            System.out.print("B ");
          else if (array[i] == 0)
            System.out.print("X ");
          else
            System.out.print(array[i] + " ");
      System.out.print("\n");
    }

  }

  public static void ini(int[] array) {
    for (int i = 1; i <= 100; i++) {
      array[i] = i;
    }
  }

  public static void main(String[] args) {
    int u1 = 0, u2 = 0;// u1,u2 means which position we are in.
    int previous = 0;// while we get mismatch while hit on snake or ladder so when we change previous
                     // pos means mismatch so we here save it before hit snake or lader.
    int press = 0;
    int snake[] = { 17, 33, 46, 76, 88, 95 };
    int ladder[] = { 8, 23, 38, 57, 67, 71 };
    int array[] = new int[101];
    Random rand = new Random();

    Scanner s = new Scanner(System.in);
    System.out.print(
        "PROGRAM STARTS NOW\n positon of A is denoted as A\n positon of B is denoted as B\n both A and B in same position menas denoted as X\n");
    System.out.print("\n BOARD STRUCTURE\n");
    ini(array);// to initialize the board;
    display(array);// to show the board;
    for (int y = 0;; y++)// running untill get winner
    {
      if (y % 2 == 0)
        System.out.print("\nPlayer A Your turn:");
      else
        System.out.print("\nPlayer B Your turn:");
      press = s.nextInt();
      previous = u1;
      int m = rand.nextInt(6);// getting die value
      if (m == 0)
        m = 6;
      System.out.print("\nyour die value is: " + m + "\n");
      if (y % 2 == 0)// chance of A
      {
        if (u1 + m < 100)// chech value is less than 100
        {
          u1 = u1 + m;// moving position values
          if (u1 == snake[0] || u1 == snake[1] || u1 == snake[2] || u1 == snake[3] || u1 == snake[4] || u1 == snake[5])// land
                                                                                                                       // on
                                                                                                                       // snake
          {
            u1 = u1 - 10;
            System.out.print("\nOOPS YOU LANDED ON SNAKE🤔🤔\n");
          } else if (u1 == ladder[0] || u1 == ladder[1] || u1 == ladder[2] || u1 == ladder[3] || u1 == ladder[4]
              || u1 == ladder[5])// land on ladder
          {
            u1 = u1 + 10;
            System.out.print("\nWOW CAN GO UP WITH LADDER 😎😎\n");
          }
          if (u1 == u2)// check now both in same position
          {
            array[u2] = 0;// make that position as 0 bcz both a and b are in same position now

          } else
            array[u1] = -1;// new position
          if (u2 == previous && u2 != 0)// munadi rendum same place na
            array[u2] = -2;
          else
            array[previous] = previous;// changing the previous position to board number

        } else {
          if (u1 + m == 100) {
            System.out.print("win 1");
            break;
          }
        }
      } else // chance of B
      {
        previous = u2;
        if (u2 + m < 100)// chech value is less than 100
        {

          u2 = u2 + m;// moving position values
          if (u2 == snake[0] || u2 == snake[1] || u2 == snake[2] || u2 == snake[3] || u2 == snake[4] || u2 == snake[5])// land
                                                                                                                       // on
                                                                                                                       // snake
            u2 = u2 - 10;
          else if (u2 == ladder[0] || u2 == ladder[1] || u2 == ladder[2] || u2 == ladder[3] || u2 == ladder[4]
              || u2 == ladder[5])// land on ladder
            u2 = u2 + 10;
          if (u1 == u2)// check now both in same position
          {
            array[u1] = 0;// make that position as 0 bcz both a and b are in same position now

          } else
            array[u2] = -2;
          if (u1 == previous && u1 != 0)
            array[u1] = -1;
          else
            array[previous] = previous;

        } else {
          if (u2 + m == 100) {
            System.out.print("win 2");
            break;
          }
        }
      }

      display(array);

    }
  }

}
