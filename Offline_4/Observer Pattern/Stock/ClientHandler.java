package Stock;

import Subscriber.Subscriber;
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler implements Runnable{

    private Socket client;
    private List<Stock> stockList;
    private BufferedReader in;
    private PrintWriter out;
    private ServerControl sc;
    private ObjectInputStream objectInput;
    private ObjectOutputStream objectOutput;
    private Subscriber tempSub;
    
    public ClientHandler(Socket soc, List<Stock> stockList, ServerControl sc) throws IOException
    {
        this.client = soc;
        this.stockList = stockList;
        
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));        // for receiving
        out = new PrintWriter(client.getOutputStream(), true);                          // for sending
        
        objectOutput = new ObjectOutputStream(client.getOutputStream());
        objectInput = new ObjectInputStream(client.getInputStream());
        
        tempSub = null;
        
        this.sc = sc;
        
//        keyboard = new Scanner(System.in);                                              // for keyboard input
        
    }
    
    @Override
    public void run(){
            try
            {
                objectOutput.writeObject(stockList);                                    // sending the package list
                sc.start();
                
                while(true)
                {                    
                    try
                    {
                        tempSub = (Subscriber) objectInput.readObject();
                        String clientResponse = in.readLine();
                        String command = in.readLine();
                        
                        int idx = Integer.parseInt(clientResponse);
                        
                        if(command.equals("add"))
                            stockList.get(idx).addSubscriber(tempSub);
                        else if(command.equals("remove"))
                            stockList.get(idx).removeSubscriber(tempSub);
                        
//                        System.out.println(stockList.get(idx).getSize());

                        for(int i=0; i<stockList.size(); i++)
                        {
                            System.out.println(stockList.get(i).getName() + ": " + stockList.get(i).getSize());
                        }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
               }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                out.close();
                try
                {
                    in.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
    }
}
