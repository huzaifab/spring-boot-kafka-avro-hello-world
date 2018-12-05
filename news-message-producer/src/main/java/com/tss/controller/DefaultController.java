package com.tss.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tss.News;
import com.tss.service.NewsProducer;

@RestController
public class DefaultController {

  private final Log logger = LogFactory.getLog(getClass());

  @Autowired
  private NewsProducer newsProducer;

  @RequestMapping(value = "produceNews", method = {GET}, produces = {APPLICATION_JSON_UTF8_VALUE})
  public String produceNews() {
    News news = new News();
    news.setId(2);
    news.setNewsTitle("News Title will go here.. Bla Bla");
    news.setNewsDescription("Some News description will go here... Bla Bla Bla...");
    news.setPublishedDate(new Date().getTime());
    news.setSource("News Taken From nytimes.com");
    news.setUrl("http://nytimes.com");
    
    logger.info("Prepared News: " + news);
    newsProducer.process(news);
    return "Produced News and Sent to News Channel";
  }
}
