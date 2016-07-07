import java.awt.*;
import javax.swing.*;
import java.text.*;
/** BankWriter shkruan transaksionet e bankes */
public class BankWriter extends JPanel
{ private int WIDTH = 400; //Gjatesia dhe gjeresia e dritares
   private int DEPTH = 300;
   private BankAccount bank; 
   private String last_transaction = ""; // transaksioni i cili paraqitet ne dritare
   
   public BankWriter(String title, BankAccount b)
   { bank = b;
      JFrame my_frame = new JFrame();
      my_frame.getContentPane().add(this);
      my_frame.setTitle(title);
      my_frame.setSize(WIDTH, DEPTH);
      my_frame.setVisible(true);
   }
   public void paintComponent(Graphics g)
   { g.setColor(Color.white);
      g.fillRect(0, 0, WIDTH, DEPTH); // ngjyros prapavijen
      g.setColor(Color.black);
      int text_margin = 50;
      int text_baseline = 50;
      g.drawString(last_transaction, text_margin, text_baseline);
      g.drawString("Balanci = $" + unconvert(bank.getBalance()),
         text_margin, text_baseline + 20);
   }

   private String unconvert(int i)
   { double dollars_cents = i / 100.00;
      return new DecimalFormat("0.00").format(dollars_cents);
   }

   public void showTransaction(String message, int amount)
   { last_transaction = message + " " + unconvert(amount);
      this.repaint();
   }
   public void showTransaction(String message)
   { last_transaction = message;
      this.repaint();
   }
}