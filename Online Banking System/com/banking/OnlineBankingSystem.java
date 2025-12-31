// onlinebankingsystem package
package com.banking;

import java.util.Scanner;

public class OnlineBankingSystem {
   public OnlineBankingSystem() {
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      BankSystem var2 = new BankSystem();

      try {
         var2.loadData();
      } catch (Exception var25) {
         System.out.println("No previous data found.");
      }

      while(true) {
         System.out.println("\n--- Online Banking System ---");
         System.out.println("1. Create Account");
         System.out.println("2. Deposit");
         System.out.println("3. Withdraw");
         System.out.println("4. Transfer Funds");
         System.out.println("5. View Statement");
         System.out.println("6. Exit");
         System.out.print("Enter choice: ");
         int var3 = var1.nextInt();

         try {
            switch (var3) {
               case 1:
                  System.out.print("Enter name: ");
                  String var4 = var1.next();
                  System.out.print("Enter initial deposit: ");
                  double var5 = var1.nextDouble();
                  System.out.print("Type (Savings/Current): ");
                  String var7 = var1.next();
                  double var8 = 0.0;
                  if (var7.equalsIgnoreCase("Current")) {
                     System.out.print("Enter overdraft limit: ");
                     var8 = var1.nextDouble();
                  }

                  Account var10 = var2.createAccount(var7, var4, var5, var8);
                  System.out.println("Account created. A/C No: " + var10.getAccountNo());
                  break;
               case 2:
                  System.out.print("Enter A/C No: ");
                  int var11 = var1.nextInt();
                  System.out.print("Amount: ");
                  double var12 = var1.nextDouble();
                  var2.findAccount(var11).deposit(var12);
                  System.out.println("Deposit successful!");
                  break;
               case 3:
                  System.out.print("Enter A/C No: ");
                  int var14 = var1.nextInt();
                  System.out.print("Amount: ");
                  double var15 = var1.nextDouble();
                  var2.findAccount(var14).withdraw(var15);
                  System.out.println("Withdrawal successful!");
                  break;
               case 4:
                  System.out.print("From A/C: ");
                  int var17 = var1.nextInt();
                  System.out.print("To A/C: ");
                  int var18 = var1.nextInt();
                  System.out.print("Amount: ");
                  double var19 = var1.nextDouble();
                  var2.transfer(var17, var18, var19);
                  System.out.println("Transfer successful!");
                  break;
               case 5:
                  System.out.print("Enter A/C No: ");
                  int var21 = var1.nextInt();
                  Account var22 = var2.findAccount(var21);
                  if (var22 != null) {
                     var22.printStatement();
                  } else {
                     System.out.println("Account not found!");
                  }
                  break;
               case 6:
                  var2.saveData();
                  System.out.println("Data saved. Goodbye!");
                  System.exit(0);
            }
         } catch (BankingException var23) {
            System.out.println("Error: " + var23.getMessage());
         } catch (Exception var24) {
            System.out.println("Unexpected Error: " + String.valueOf(var24));
         }
      }
   }
}
