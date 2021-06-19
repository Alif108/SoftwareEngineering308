package Subscriber;

import Stock.Stock;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubscriberClient {
    
    private static Socket soc;
    private static List<Stock> stockList = null; 
    private static BufferedReader serverInput = null;
    private static String str;
    private static String[] arrOfStr;
    private static Subscriber sub;
    private static Object object;
    private static ObjectInputStream objectInput;
    private static ObjectOutputStream objectOutput;
    
    public static void showStockList()
    {
        try 
        {
            try {
                    object = objectInput.readObject();
                    stockList =  (ArrayList<Stock>) object;
                    
                    stockList.forEach((st)-> System.out.println(st.getName() + " " + st.getCount() + " " + st.getPrice()));
                } 
            catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
          
        Scanner scanner = new Scanner(System.in);
        String keyboardInput;
        Stock temp = null;
        
        soc = new Socket("localhost", 9806);
        System.out.println("Client Started");
        
        objectOutput = new ObjectOutputStream(soc.getOutputStream());        
        objectInput = new ObjectInputStream(soc.getInputStream());
        serverInput = new BufferedReader(new InputStreamReader(soc.getInputStream()));  
        PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
        
        sub = new Subscriber();

        ClientControl cc = new ClientControl(soc);
        
        showStockList();
        
        System.out.println("<----------Enter Your Choices------->");
        System.out.println("Press S for Subscribe\nPress U for Unsubscribe");
        
        cc.start();
        
        while(true)
        {
            System.out.print("> ");
            keyboardInput = scanner.nextLine();
            
            if(keyboardInput.equals("quit"))
                break;

            arrOfStr = keyboardInput.split(" ");
            
            if(arrOfStr[0].toLowerCase().equals("s"))                                                   // add subscription
            {
                for(int i=0; i<stockList.size(); i++)
                {
                    if(arrOfStr[1].toLowerCase().equals(stockList.get(i).getName().toLowerCase()))
                    {
//                        stockList.get(i).addSubscriber(sub);                                            // adding subscriber to the stock
//                        objectOutput.writeObject(stockList);
                        objectOutput.writeObject(sub);
                        out.println(i);
                        out.println("add");
                    }
                }
            }
            else if(arrOfStr[0].toLowerCase().equals("u"))
            {
                for(int i=0; i<stockList.size(); i++)
                {
                    if(arrOfStr[1].toLowerCase().equals(stockList.get(i).getName().toLowerCase()))
                    {
                        objectOutput.writeObject(sub);
                        out.println(i);
                        out.println("remove");
                    }  
                }
            }
            else
                System.out.println("Action not available");
        }
    }
}
