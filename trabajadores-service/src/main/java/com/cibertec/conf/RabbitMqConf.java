package com.cibertec.conf;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConf {

	@Value("${app.queue.log}")
	private String queueLog;

	@Bean

	public Queue logQueue() {

		return new Queue(queueLog, true, false, false);

	}

	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connecitonFactory) {
		RabbitAdmin admin = new RabbitAdmin(connecitonFactory);
		admin.declareQueue(logQueue());
		return admin;
	}

	@Bean

	public CommandLineRunner enviarMensajeDePrueba(RabbitTemplate rabbitTemplate) {

		return args -> {

			String mensaje = "Hola Mundo";

			rabbitTemplate.convertAndSend(queueLog, mensaje);

			System.out.println(">>> MENSAJE DE PRUEBA ENVIADO A: " + queueLog);

		};

	}
}
