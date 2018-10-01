
/*Nim Game*/

import java.util.Scanner;
import java.util.Random;

public class NimGame
{

   public static void main(String[] args)
   {
      Scanner read = new Scanner(System.in);
      Random random = new Random();
      int[] piles = new int[8];
      int index;
      int sticks;
      int totalSticks = 0;
      boolean turn = true;// true=player 1 false=player 2
      String currentPlayer;
      String p1 = "Player One";
      String p2 = "Player Two";
      int pileNumber = random.nextInt(5) + 2; // random number of piles
      // setting the sticks in piles
      for (index = 0; index < pileNumber; index++)
      {
         piles[index] = random.nextInt(8) + 1;
         totalSticks += piles[index];
      }
      // output
      for (index = 0; index < pileNumber; index++)
      {
         System.out.print("Line number " + (index + 1) + ": ");
         for (int j = 0; j < piles[index]; j++)
            System.out.print("| ");
         System.out.println();
      }
      System.out.println("-----------------------------");
      do
      {
         // switching the players
         if (turn)
         {
            currentPlayer = p1;
         }
         else
         {
            currentPlayer = p2;
         }
         turn = !turn;

         boolean ok = false;
         int currentPileIndex;
         //setting the pile
         do
         {          
            System.out.println(currentPlayer + " insert a correct pile:");
            currentPileIndex = read.nextInt() - 1;
            while (currentPileIndex < 0 || currentPileIndex > pileNumber)
            {
               System.out.println(currentPlayer + "Insert a correct pile:");
               currentPileIndex = read.nextInt() - 1;
            }
            if (piles[currentPileIndex] != 0)
               ok = true;
         }
         while (!ok);
         //setting the stick number
         ok = false;
         do
         {
            System.out.println("Insert a correct stick number:");
            sticks = read.nextInt();
            if (sticks <= piles[currentPileIndex] && sticks > 0)
            {
               ok = true;
            }
         }
         while (!ok);
         
         System.out.println("-----------------------------");
         piles[currentPileIndex] -= sticks; //deleting the selected number of sticks
         totalSticks -= sticks;
         //if a pile is 0 it should be deleted
         if (piles[currentPileIndex] == 0)
         {
            for (index = currentPileIndex; index < pileNumber; index++)
               piles[index] = piles[index + 1];
            pileNumber--;
         }
         //output
         for (index = 0; index < pileNumber; index++)
         {
            System.out.print("Line number " + (index + 1) + ": ");
            for (int j = 0; j < piles[index]; j++)
               System.out.print("| ");
            System.out.println();

         }
         System.out.println("-----------------------------");
         //if there remained just one stick it means that the game is over
         if (totalSticks == 1)
         {
            if (currentPlayer == p1)
               System.out.println(p1 + " HAS WON");
            else
               System.out.println(p2 + " HAS WON");
         }
      }
      while (totalSticks > 1);
      read.close();
   }
}
