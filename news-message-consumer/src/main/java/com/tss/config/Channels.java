package com.tss.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

public interface Channels extends Sink {

  String NEWS = "news";

  @Input(Channels.NEWS)
  SubscribableChannel news();

}
