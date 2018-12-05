package com.tss.consumer;

import com.tss.config.Channels;
import com.tss.News;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;
import org.springframework.stereotype.Component;
@Component
@EnableBinding(Channels.class)
@EnableSchemaRegistryClient
public class NewsConsumer {

  private final Log logger = LogFactory.getLog(getClass());

  @StreamListener(Channels.NEWS)
  public void receive(News news) {
    logger.info("Received News: "+news);
  }
}