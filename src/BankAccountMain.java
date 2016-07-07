// Program bankar per 3 shfrutezues(PersoniA,PersoniB dhe BankieriBT)
import javax.swing.*;
public class BankAccountMain {
   public static void main(String[]args)  {
   	// Zgjedhja e shkrytezuesit
      Object[] selectionValues = { "PersoniA", "PersoniB" ,"BankieriBT"};
      String initialSelection = "BankieriBT";
      Object selection = JOptionPane.showInputDialog(null, "Zgjedhe shfrytezuesin!",
          "Zgjedh", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
       
      if (selection=="BankieriBT")
      {    Object[] selectionValues1 = { "PersoniA", "PersoniB"};
         String initialSelection1 = "PersiniA";
         Object selection1 = JOptionPane.showInputDialog(null, "Zgjedhe llogarine e personit me te cilen deshironi te punoni",
            "Zgjedh", JOptionPane.QUESTION_MESSAGE, null, selectionValues1, initialSelection1);  
            
         if (selection1=="PersoniA")
         {       BankReader reader = new BankReader();
            BankAccount account = new BankAccount(0);
            BankWriter writer = new BankWriter("Llogaria e PersonitA", account);
            AccountController controller =
               new AccountController(reader, writer, account);
            controller.processTransactions();}
            
         else if (selection1=="PersoniB")
         {       BankReader reader = new BankReader();
            BankAccount account = new BankAccount(0);
            BankWriter writer = new BankWriter("Llogaria e personitB", account);
            AccountController controller =
               new AccountController(reader, writer, account);
         
            controller.processTransactions();}
            
      }
      else if (selection=="PersoniA")
      {       BankReader reader = new BankReader();
         BankAccount account = new BankAccount(0);
         BankWriter writer = new BankWriter("Llogaria e PersonitA", account);
         AccountController controller =
            new AccountController(reader, writer, account);
         controller.processTransactions();}
      
      else if (selection=="PersoniB")
      {       BankReader reader = new BankReader();
         BankAccount account = new BankAccount(0);
         BankWriter writer = new BankWriter("Llogaria e PersonitB", account);
         AccountController controller =
            new AccountController(reader, writer, account);
         controller.processTransactions();}
   	
   	
   }

}
