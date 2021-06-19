package Subscriber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientControl extends Thread{
    
    private Socket socket;
    private BufferedReader in;
    String serverResponse;
    
    public ClientControl(Socket socket)
    {
        this.socket = socket;
        
        try
        {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public synchronized void run()
    {
        try
            {
            while(true)
            {
                serverResponse = in.readLine();
                System.out.println(serverResponse);
               }
            }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
