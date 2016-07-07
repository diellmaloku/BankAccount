
public class AccountController {
	private BankReader reader; // input-view
	   private BankWriter writer; // output-view
	   private BankAccount account; // model

	   public AccountController(BankReader r, BankWriter w, BankAccount a)
	   { reader = r;
	      account = a;
	      writer = w;
	   }
	/** processTransactions kontrollon komandat e dhena(D,T,Q) */
	   public void processTransactions()
	   { char command = reader.readCommand("Komanda (D,T,Q) dhe shuma:");
	      if ( command == 'Q' ) // quit(dil)
	      { } // nese shkruhet Q metoda nuk ben asgje
	      else { 
	         if ( command == 'D' ) // depozito
	         { int amount = reader.readAmount();
	            boolean ok = account.deposit(amount);
	            if ( ok )
	            { writer.showTransaction("Depozitimi i $", amount); }
	            else { writer.showTransaction("Shuma e depozitimit gabim ", amount); }
	         }
	         else if ( command == 'T' ) // terhiq
	         { int amount = reader.readAmount();
	            boolean ok = account.withdraw(amount);
	            if ( ok )
	            { writer.showTransaction("Terheqja e $", amount);}
	            else { writer.showTransaction("Shuma e terheqjes gabim ", amount); }
	         }
	         else { writer.showTransaction("Komanda gabim: " + command); }
	         this.processTransactions(); // i dergon vetes mesazh per tu perseritur
	      }
	   }

}
