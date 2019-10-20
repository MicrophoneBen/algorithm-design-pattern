package com.kafka.test;

import com.support.KafkaSupportApplication;
import com.support.kafka.KafkaProducerSender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author zhangbingquan
 * @desc 单元测试类
 * @time 2019-10-21 3:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaSupportApplication.class)
public class KafkaSenderTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void whenQuerySuccess() throws Exception {
        String result = mockMvc.perform(
                get("/user").param("username", "jojo").param("age", "18").param("ageTo", "60").param("xxx", "yyy")
                        // .param("size", "15")    //MockMvcRequestBuilders
                        // .param("page", "3")
                        // .param("sort", "age,desc")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(3)) //MockMvcResultMatchers
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Autowired
    KafkaProducerSender sender;

    @Test
    public void kafkaTest(){
        Assert.notNull(sender);
        for (int i = 0; i < 3; i++) {
            //调用消息发送类中的消息发送方法
            sender.send();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
