//Required all Packages
package com.banking;

import java.io.*;
import java.util.*;

public class BankSystem {
   private ArrayList<Account> accounts = new ArrayList<Account>();
   private int nextAccountNo = 1001;

   public BankSystem() {
   }

   public Account createAccount(String var1, String var2, double var3, double var5) {
      Account var7;
      if (var1.equalsIgnoreCase("Savings")) {
         var7 = new SavingsAccount(this.nextAccountNo++, var2, var3);
      } else {
         var7 = new CurrentAccount(this.nextAccountNo++, var2, var3, var5);
      }

      this.accounts.add(var7);
      return (Account)var7;
   }

   public Account findAccount(int var1) {
      Iterator<Account> var2 = this.accounts.iterator();

      Account var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (Account)var2.next();
      } while(var3.getAccountNo() != var1);

      return var3;
   }

   public void transfer(int var1, int var2, double var3) throws BankingException {
      Account var5 = this.findAccount(var1);
      Account var6 = this.findAccount(var2);
      if (var5 != null && var6 != null) {
         var5.withdraw(var3);
         var6.deposit(var3);
      } else {
         throw new BankingException("Invalid account number!");
      }
   }

   public void saveData() throws IOException {
      ObjectOutputStream var1 = new ObjectOutputStream(new FileOutputStream("bankdata.dat"));
      var1.writeObject(this.accounts);
      var1.close();
   }

   public void loadData() throws Exception {
      File var1 = new File("bankdata.dat");
      if (var1.exists()) {
         ObjectInputStream var2 = new ObjectInputStream(new FileInputStream("bankdata.dat"));
         this.accounts = (ArrayList)var2.readObject();
         var2.close();
         this.nextAccountNo = this.accounts.stream().mapToInt(Account::getAccountNo).max().orElse(1000) + 1;
      }
   }
}
