package amqp.test;

import java.io.IOException;

import com.rabbitmq.client.ConfirmListener;

public class publisherConfirmLister implements ConfirmListener{

	public void handleAck(long deliveryTag, boolean multiple) throws IOException {
		System.out.println("handleAck");
	}

	public void handleNack(long deliveryTag, boolean multiple) throws IOException {
		System.out.println("handleNack");
	}

}
