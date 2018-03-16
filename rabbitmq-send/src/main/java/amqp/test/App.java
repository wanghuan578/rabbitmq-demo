package amqp.test;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.PropertyConfigurator;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * Hello world!
 *
 */
public class App 
{
	private final static String EXCHANGE_NAME = "wanghuan111";  
	
	static boolean isBreak =false;
	
    public static void main( String[] args ) throws IOException, TimeoutException, InterruptedException
    {
    	 ConnectionFactory factory = new ConnectionFactory();  

         factory.setUsername("spirit");  
         factory.setPassword("spirit");  
         factory.setVirtualHost("/");
         
         Address[] addrArr = new Address[]{ new Address("192.168.207.128", 5672), new Address("192.168.207.129", 5672), new Address("192.168.207.131", 5672)};
         
         Connection connection = factory.newConnection(addrArr);

 
         Channel channel = connection.createChannel();  
         
         channel.exchangeDeclare(EXCHANGE_NAME, "direct");  
   
         
         String message = "wanghuan black message test";  
         channel.basicPublish(EXCHANGE_NAME, "black", null, message.getBytes());  
         System.out.println(message);  
         String message2 = "red message";  
         channel.basicPublish(EXCHANGE_NAME, "red", null, message2.getBytes());  
         System.out.println(message2);  
         
         while(true) {
        	 System.gc();
         }
         channel.close();  
         connection.close();  
    }
    

}
