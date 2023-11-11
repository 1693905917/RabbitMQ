package cn.itcast.mq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @BelongsProject: mq-demo
 * @BelongsPackage: cn.itcast.mq.spring
 * @Author: ASUS
 * @CreateTime: 2023-11-11  14:27
 * @Description: TODO
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSimpleQueue(){
        String queueName="simple.queue";
        String message="hello,spring amqp!";
        rabbitTemplate.convertAndSend(queueName,message);
    }


    @Test
    public void testWorkQueue() throws InterruptedException {
        String queueName="simple.queue";
        String message="hello,spring amqp!";
        for (int i = 1; i <= 50; i++) {
            rabbitTemplate.convertAndSend(queueName,message+i);
            Thread.sleep(20);
        }

    }

    @Test
    public void testFanoutExchange() throws InterruptedException {
        String exchangeName="itcast.fanout";
        String message="hello,everyone!";
        rabbitTemplate.convertAndSend(exchangeName,"",message);
    }

    @Test
    public void testDirectExchange() throws InterruptedException {
        String exchangeName="itcast.direct";
        String message="红色警报！日本乱排核废水，导致海洋生物变异，惊现哥斯拉！";
        rabbitTemplate.convertAndSend(exchangeName,"yellow",message);
    }

    @Test
    public void testTopicExchange() throws InterruptedException {
        String exchangeName="itcast.topic";
        String message="喜报！孙悟空大战哥斯拉，胜！";
        rabbitTemplate.convertAndSend(exchangeName,"news",message);
    }

}
