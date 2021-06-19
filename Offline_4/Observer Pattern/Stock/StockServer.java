package Stock;

import Subscriber.Subscriber;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class StockServer {
    
    private static String stockName;
    private static float stockPrice;
    private static int stockCount;
    private static Stock temp = null;
    private static List<Stock> stockList = new ArrayList<Stock>();
    
    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static final ExecutorService pool = Executors.newFixedThreadPool(4);
    
    private static Socket clientSocket = null;
    
    private static Object object;
    private static ObjectInputStream objectInput;
    private static ObjectOutputStream objectOutput;
    
    private static Subscriber tempSub = null;
    
    public static void readFile(FileInputStream fis)
    {
        Scanner sc = new Scanner(fis);                  //file to be scanned  
                                                        
            while(sc.hasNextLine())                     //returns true if there is another line to read  
            {
                String[] arrOfStr = sc.nextLine().split(" ");
                stockName = arrOfStr[0];
                stockCount = Integer.parseInt(arrOfStr[1]);
                stockPrice = Float.parseFloat(arrOfStr[2]);
                
                temp = new Stock(stockName, stockCount, stockPrice);
                stockList.add(temp);
            }
        sc.close();                                      //closes the scanner  
    }
    
    public static void main(String[] args) {
        
        try  
        {  
            //the file to be opened for reading  
            FileInputStream fis = new FileInputStream("input.txt"); 
            readFile(fis);

            ServerSocket ss = new ServerSocket(9806);
//            
//            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//            
//            ServerControl sc = new ServerControl(clientSocket, stockList, out);
//            
//            objectOutput = new ObjectOutputStream(clientSocket.getOutputStream());
//            objectInput = new ObjectInputStream(clientSocket.getInputStream());
//            
//            objectOutput.writeObject(stockList);                                    // sending the package list

//            sc.start();
            
            while(true)
            {
                System.out.println("Waiting for clients...");
            
                clientSocket = ss.accept();
                System.out.println("Client Connected");
                
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);            
                ServerControl sc = new ServerControl(clientSocket, stockList, out);
                
                ClientHandler clientThread = new ClientHandler(clientSocket, stockList, sc);
                clients.add(clientThread);
                
                pool.execute(clientThread);
            }
            
//            try
//            {
//                while(true)
//                {                    
//                    try
//                    {
//                        tempSub = (Subscriber) objectInput.readObject();
//                        String clientResponse = in.readLine();
//                        String command = in.readLine();
//                        
//                        int idx = Integer.parseInt(clientResponse);
//                        
//                        if(command.equals("add"))
//                            stockList.get(idx).addSubscriber(tempSub);
//                        else if(command.equals("remove"))
//                            stockList.get(idx).removeSubscriber(tempSub);
//                        
////                        System.out.println(stockList.get(idx).getSize());
//
////                        for(int i=0; i<stockList.size(); i++)
////                        {
////                            System.out.println(stockList.get(i).getName() + ": " + stockList.get(i).getSize());
////                        }
//                    }
//                    catch(Exception e)
//                    {
//                        e.printStackTrace();
//                    }
//               }
//            }
//            finally
//            {
//                out.close();
//                in.close();
//            }
            
//            while(true)
//            {
//                System.out.println("at the start of the while loop");
//                
//                clientSocket = ss.accept();
//                System.out.println("Connection established");
//                
//                ClientHandler clientThread = new ClientHandler(clientSocket, stockList);
//                clients.add(clientThread);
//                
//                pool.execute(clientThread);
//            }

//            Socket clientSocket = ss.accept();
//            System.out.println("Connection established");

//            ObjectOutputStream objectOutput = new ObjectOutputStream(clientSocket.getOutputStream());
//            objectOutput.writeObject(stockList); 
//            
//            clientSocket.close();
//            
//            for(Stock sub : stockList)
//                out.println(sub.getName());
        }  
        catch(Exception e)  
        {  
            e.printStackTrace();  
        }  
    }
}
