//savingsaccount package
package com.banking;

public class SavingsAccount extends Account {
   public SavingsAccount(int var1, String var2, double var3) {
      super(var1, var2, var3);
   }

   public void withdraw(double var1) throws BankingException {
      if (var1 <= 0.0) {
         throw new BankingException("Invalid withdrawal amount!");
      } else if (this.balance < var1) {
         throw new BankingException("Insufficient funds in Savings Account!");
      } else {
         this.balance -= var1;
         this.addTransaction("Withdrew: " + var1);
      }
   }
}
