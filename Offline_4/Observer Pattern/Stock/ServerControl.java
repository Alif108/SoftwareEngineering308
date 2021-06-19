package Stock;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerControl extends Thread {
    
    private Socket client;
    Scanner keyboardInput;
    String temp;
    String[] arrOfStr;
    List<Stock> stockList;
    PrintWriter out;
    
    public ServerControl(Socket socket, List<Stock> stockList, PrintWriter out)
    {
        this.client = socket;
        keyboardInput = new Scanner(System.in);
        this.stockList = stockList;
        this.out = out;
    }
    
    @Override
    public synchronized void run()
    {
        while(true)
        {
            System.out.print("> ");
            temp = keyboardInput.nextLine();
            
            if(temp.equals("quit"))
                break;
            
            else
            {
                arrOfStr = temp.split(" ");
                
                if(arrOfStr[0].toLowerCase().equals("i"))
                {
                    for(int i=0; i<stockList.size(); i++)
                    {
                        if(arrOfStr[1].toLowerCase().equals(stockList.get(i).getName().toLowerCase()))      // if the package exists 
                        {
                            stockList.get(i).increaseStock(Float.parseFloat(arrOfStr[2]), out);
                        }
                    }
                }
                else if(arrOfStr[0].toLowerCase().equals("d"))
                {
                    for(int i=0; i<stockList.size(); i++)
                    {
                        if(arrOfStr[1].toLowerCase().equals(stockList.get(i).getName().toLowerCase()))      // if the package exists 
                        {
                            stockList.get(i).decreaseStock(Float.parseFloat(arrOfStr[2]), out);
                        }
                    }
                }
                else if(arrOfStr[0].toLowerCase().equals("c"))
                {
                    for(int i=0; i<stockList.size(); i++)
                    {
                        if(arrOfStr[1].toLowerCase().equals(stockList.get(i).getName().toLowerCase()))      // if the package exists 
                        {
                            stockList.get(i).changeCount(Integer.parseInt(arrOfStr[2]), out);
                        }
                    }
                }
                else
                    System.out.println("No Such Actions Available");
            }
        }
    }
}
