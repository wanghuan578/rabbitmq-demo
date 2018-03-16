package amqp.test;

import com.rabbitmq.client.ShutdownListener;
import com.rabbitmq.client.ShutdownSignalException;

public class shutdownNotify implements ShutdownListener {

	public void shutdownCompleted(ShutdownSignalException cause) {
		// TODO Auto-generated method stub
		System.out.println("shutdownCompleted");
	}

}
