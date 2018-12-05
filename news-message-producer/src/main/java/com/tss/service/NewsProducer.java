package com.tss.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import com.tss.config.Channels;
import com.tss.News;

@Component
@EnableBinding(Channels.class)
@EnableSchemaRegistryClient
public class NewsProducer {

  private final Channels channels;
  private final Log logger = LogFactory.getLog(getClass());

  public NewsProducer(Channels channels) {
    this.channels = channels;
  }

  public void process(News news) {
    logger.info("Process news to 'news' Topic: " + news);
    actioned(news);
  }

  public void actioned(final News news) {
    channels.newsProducer().send(MessageBuilder.withPayload(news).setHeader(KafkaHeaders.MESSAGE_KEY, null).build());
  }

}
