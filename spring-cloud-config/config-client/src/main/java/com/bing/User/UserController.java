package com.bing.User;

import com.bing.model.User;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by szt on 2016/11/18.
 */
@RestController
@RefreshScope
public class UserController {
  @Value("${bing.for.test}")
  private String testProperty;

  @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
  public User getUser(@PathVariable("id") String id) {
    User user=new User();
    user.setName(testProperty);
    user.setId(id);
    user.setCreatedTime(new Date());
    return user;
  }
}
