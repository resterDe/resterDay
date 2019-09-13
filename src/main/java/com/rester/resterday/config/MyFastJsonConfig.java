package com.rester.resterday.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;

/**
 * 不同于Gson，fastjson继承完成后需要提供相应的httpMessageConverter才能使用
 * @author ResterDay
 * @version 1.0
 * @date 2019/9/11 10:11
 * 配置fastjson的HttpMessageConverter
 * 配置完需要设置一下响应编码，否则返回json中文会乱码-->application.properties
 */
@Configuration
public class MyFastJsonConfig {
    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
        FastJsonHttpMessageConverter converter=new FastJsonHttpMessageConverter();
        FastJsonConfig config=new FastJsonConfig();
        //JSON的解析过程，设置日期格式
        config.setDateFormat("yyyy-MM-dd");
        //数据编码
        config.setCharset(Charset.forName("UTF-8"));
        config.setSerializerFeatures(
                //是否在生成json时输出类名
                SerializerFeature.WriteClassName,
                //是否输出value为null的数据
                SerializerFeature.WriteMapNullValue,
                //生成的json格式化
                SerializerFeature.PrettyFormat,
                //空集合输出[]而不是null
                SerializerFeature.WriteNullListAsEmpty,
                //空字符串输出""，而不是null
                SerializerFeature.WriteNullStringAsEmpty
        );
        converter.setFastJsonConfig(config);
        return converter;
    }
}
