package cn.itcast.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * @BelongsProject: mq-demo
 * @BelongsPackage: cn.itcast.mq.listener
 * @Author: ASUS
 * @CreateTime: 2023-11-11  14:40
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class SpringRabbitListener {

//    @RabbitListener(queues = "simple.queue")
//    public void listenSimpleQueueMessage(String msg){
//        System.out.println("spring消费者接收到消息：【"+msg+"】");
//    }

    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueue1(String msg) throws InterruptedException {
        System.out.println("spring消费者1接收到消息：【"+msg+"】"+ LocalTime.now());
        Thread.sleep(20);
    }

    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueue2(String msg) throws InterruptedException {
        System.out.println("spring消费者2>>>>>>接收到消息：【"+msg+"】"+ LocalTime.now());
        Thread.sleep(200);
    }

    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(String msg) throws InterruptedException {
        System.out.println("spring消费1>>>>>>接收到Fanout消息：【"+msg+"】");
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String msg) throws InterruptedException {
        System.out.println("spring消费2>>>>>>接收到Fanout消息：【"+msg+"】");
    }



}
