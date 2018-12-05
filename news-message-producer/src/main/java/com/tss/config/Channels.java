package com.tss.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

public interface Channels extends Sink, Source{

  String NEWS = "news";
  
  @Output(Channels.NEWS)
  MessageChannel newsProducer();
}
