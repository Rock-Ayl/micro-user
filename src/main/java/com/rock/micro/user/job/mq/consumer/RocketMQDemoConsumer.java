package com.rock.micro.user.job.mq.consumer;

import com.alibaba.fastjson.JSONObject;
import com.rock.micro.base.common.rocketmq.RocketMQConstant;
import com.rock.micro.base.serivce.NormalLogDocService;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 消费者实现
 * -
 * {@link ConsumeMode}：消费模式
 * -[CONCURRENTLY=并发消费]:高性能,消息无顺序
 * -[ORDERLY=顺序消费]:同一队列中的消息,按发送顺序被消费(比如订单状态变更)
 * -
 * {@link MessageModel}：消息消费模式
 * -[BROADCASTING=广播模式]:一条消息被所有消费者处理
 * -[CLUSTERING=集群模式]:一条喜消息被一个消费者处理
 * -
 * 同一个 consumerGroup 组内所有实例必须订阅 相同的 Topic
 * -
 *
 * @Author ayl
 * @Date 2025-03-22
 */
@Service
@RocketMQMessageListener(
        //消费订阅主题
        topic = RocketMQConstant.TOPIC_NORMAL,
        //消费者分组
        consumerGroup = RocketMQConstant.CONSUMER_GROUP_USER_NORMAL,
        //过滤Tag,*表示全部
        selectorExpression = RocketMQConstant.TAG_TEST_1,
        //消费模式
        consumeMode = ConsumeMode.CONCURRENTLY,
        //集群模式
        messageModel = MessageModel.CLUSTERING
)
public class RocketMQDemoConsumer implements RocketMQListener<JSONObject> {

    @Autowired
    private NormalLogDocService normalLogDocService;

    @Override
    public void onMessage(JSONObject message) {
        //插入一条数据测试用
        normalLogDocService.createLog("MQ监听", "记录测试消息", message);
    }

}