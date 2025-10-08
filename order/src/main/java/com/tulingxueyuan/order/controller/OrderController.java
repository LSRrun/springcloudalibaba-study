package com.tulingxueyuan.order.controller;

import com.tulingxueyuan.order.feignService.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StockFeignService stockFeignService;
    @Value("${author}")
    private String author;

    @RequestMapping("/add")
    public String add(){
        System.out.println("下单成功!");
//        String msg = restTemplate.getForObject("http://stock-server/stock/reduct", String.class);
        String msg = stockFeignService.reduct();
        return author+"Hello World"+msg;
    }
}
