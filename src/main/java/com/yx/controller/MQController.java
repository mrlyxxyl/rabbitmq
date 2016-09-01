package com.yx.controller;

import com.yx.service.MQProducer;
import com.yx.utils.GenResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping(value = "mq")
public class MQController {

    @Resource
    private MQProducer mqProducer;

    @RequestMapping(value = "test")
    @ResponseBody
    public Map<String, Object> test() {
        mqProducer.sendDataToQueue("queue_one", "queue_one_value");
        return GenResult.SUCCESS.genResult();
    }
}
