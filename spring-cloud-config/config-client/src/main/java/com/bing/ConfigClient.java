
package com.bing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 全局配置服务器
 *
 */
@SpringBootApplication
public class ConfigClient {
  public static void main(String[] args) {
    SpringApplication.run(ConfigClient.class, args);
  }
}
