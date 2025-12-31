//account package
package com.banking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public abstract class Account implements Serializable {
   protected int accountNo;
   protected String holderName;
   protected double balance;
   protected ArrayList<String> transactions = new ArrayList();

   public Account(int var1, String var2, double var3) {
      this.accountNo = var1;
      this.holderName = var2;
      this.balance = var3;
      this.addTransaction("Account created with balance: " + var3);
   }

   public int getAccountNo() {
      return this.accountNo;
   }

   public String getHolderName() {
      return this.holderName;
   }

   public double getBalance() {
      return this.balance;
   }

   public void deposit(double var1) throws BankingException {
      if (var1 <= 0.0) {
         throw new BankingException("Invalid deposit amount!");
      } else {
         this.balance += var1;
         this.addTransaction("Deposited: " + var1);
      }
   }

   public abstract void withdraw(double var1) throws BankingException;

   protected void addTransaction(String var1) {
      this.transactions.add(String.valueOf(new Date()) + " | " + var1 + " | Balance: " + this.balance);
   }

   public void printStatement() {
      System.out.println("\nStatement for " + this.holderName + " (A/C " + this.accountNo + ")");
      Iterator<String> var1 = this.transactions.iterator();

      while(var1.hasNext()) {
         String var2 = (String)var1.next();
         System.out.println(var2);
      }

      System.out.println("Final Balance: " + this.balance);
   }
}
