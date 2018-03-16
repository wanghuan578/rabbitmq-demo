package amqp.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.rabbitmq.client.ShutdownSignalException;

/**
 * Hello world!
 *
 */
public class App 
{
	private final static String EXCHANGE_NAME = "wanghuan111";   
	static boolean isBreak =false;
	
    public static void main( String[] args )
    {
    	while(true) {
	    	
    		String a = null;
    		
    		try {
	    		
	    		ConnectionFactory factory = new ConnectionFactory();  
	            
	            Address[] addrArr = new Address[]{ new Address("192.168.207.131", 5672) };
	            //Address[] addrArr = new Address[]{ new Address("192.168.207.128", 5672), new Address("192.168.207.129", 5672), new Address("192.168.207.131", 5672)};
	            
	            //factory.setHost("192.168.207.131");  
	            //factory.setPort(5672);  
	            factory.setUsername("spirit");  
	            factory.setPassword("spirit");  
	            factory.setVirtualHost("/");
	            Map<String,Object> props = new HashMap<String, Object>();
	            Map<String, Object> capabilities = new HashMap<String, Object>();
	            capabilities.put("publisher_confirms", true);
	            capabilities.put("exchange_exchange_bindings", true);
	            capabilities.put("basic.nack", true);
	            capabilities.put("consumer_cancel_notify", true);
	            
	            props.put("capabilities", capabilities);
	            
	            factory.setClientProperties(props);
	            Connection connection = factory.newConnection(addrArr);
	
	            //Connection connection = factory.newConnection();  
	            Channel channel = connection.createChannel();  
	      
	            channel.exchangeDeclare(EXCHANGE_NAME, "direct"); 
	            
	            String queueName = channel.queueDeclare().getQueue();  
	            System.out.println("queueName: " + queueName);  
	            channel.queueBind(queueName, EXCHANGE_NAME, "black");  
	      
	            Consumer consumer = new DefaultConsumer(channel) {  
	                @Override  
	                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {  
	                    String message = new String(body, "UTF-8");  
	                    System.out.println("receive message :" + message);  
	                    
	                    //isBreak = true;
	                }
	                
	                @Override
	                public void handleCancel(String consumerTag) throws IOException {
	                    // consumer has been cancelled unexpectedly
	                	
	                	System.out.println("handleCancel -------------- ");  
	                }
	                
	                @Override
	                public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
	                    // no work to do
	                	System.out.println("handleShutdownSignal -------------- ");  
	                }

	            };
	            
	            shutdownNotify notify = new shutdownNotify();
	            
	            channel.addShutdownListener(notify);
	            //channel.
	            channel.basicConsume(queueName, true, consumer);
	            
	            
	            channel.close();  
	            connection.close();  
	            List<String> list = new ArrayList<String>();
	            
	            while(!isBreak) {
	            	
	            	a = new String("11111111111111111111111111111111111111111111111111222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222221111111111111111111111111111111111111111111111111111111111111111222222222222222222222222222222111111111111111111111111111");
	            	list.add(a);
	            	
	            	System.out.println("wait ...");
	            	//System.gc();
	            	//Thread.sleep(3); 
	            }
	    	}
	    	catch (Exception e)
	    	{
	    		e.printStackTrace();  
	    	}
    		
    		System.out.println(a);
        
    	}
    	
        //System.out.println("exit");  
    }
    

}
