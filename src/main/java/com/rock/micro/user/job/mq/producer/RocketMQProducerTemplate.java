package com.rock.micro.user.job.mq.producer;

import com.rock.micro.base.common.rocketmq.RocketMQConstant;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.annotation.ExtRocketMQTemplateConfiguration;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.List;

/**
 * 集成RocketMQTemplate,配置参数,封装生产者方法
 */
@ExtRocketMQTemplateConfiguration(group = RocketMQConstant.PRODUCER_GROUP_USER)
public class RocketMQProducerTemplate extends RocketMQTemplate {

    private static final Logger logger = LoggerFactory.getLogger(RocketMQProducerTemplate.class);

    /**
     * 构建一条消息对象
     *
     * @param key   消息key
     * @param value 消息body
     * @return
     */
    public Message<String> buildMessage(String key, String value) {
        //构建并返回
        return MessageBuilder.withPayload(value).setHeader(RocketMQHeaders.KEYS, key).build();
    }

    /**
     * 同步发送一条消息,等待结果
     *
     * @param tag   主题 + 标签
     * @param key   key
     * @param value 消息body
     * @return
     */
    public SendResult syncSend(String topic, String tag, String key, String value) {
        return super.syncSend(topic + ":" + tag, buildMessage(key, value));
    }

    /**
     * 批量发送多条消息,等待结果
     *
     * @param tag         主题 + 标签
     * @param messageList 消息列表
     * @return
     */
    public SendResult syncSend(String topic, String tag, List<Message<String>> messageList) {
        return super.syncSend(topic + ":" + tag, messageList);
    }

    /**
     * 同步发送一条消息,不等待结果
     *
     * @param tag   主题 + 标签
     * @param key   key
     * @param value 消息body
     * @return
     */
    public void sendOneWay(String topic, String tag, String key, String value) {
        super.sendOneWay(topic + ":" + tag, buildMessage(key, value));
    }

    /**
     * 异步发送一条消息
     *
     * @param tag   主题 + 标签
     * @param key   key
     * @param value 消息body
     * @return
     */
    public void asyncSend(String topic, String tag, String key, String value) {
        super.asyncSend(topic + ":" + tag, buildMessage(key, value), new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                logger.info("send asyncSend successful");
            }

            @Override
            public void onException(Throwable e) {
                logger.info("send asyncSend fail; {}", e.getMessage());
            }
        });
    }

}
