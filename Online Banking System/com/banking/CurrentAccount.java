// currentaccount package
package com.banking;

public class CurrentAccount extends Account {
   private double overdraftLimit;

   public CurrentAccount(int var1, String var2, double var3, double var5) {
      super(var1, var2, var3);
      this.overdraftLimit = var5;
   }

   public void withdraw(double var1) throws BankingException {
      if (var1 <= 0.0) {
         throw new BankingException("Invalid withdrawal amount!");
      } else if (this.balance - var1 < -this.overdraftLimit) {
         throw new BankingException("Overdraft limit exceeded!");
      } else {
         this.balance -= var1;
         this.addTransaction("Withdrew: " + var1);
      }
   }
}
