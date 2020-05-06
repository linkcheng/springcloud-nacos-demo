package cn.hsb.component;

import cn.hsb.consumer.api.DataServiceApi;
import cn.hsb.dto.CommonResult;
import cn.hsb.dto.RegistryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class Registry {
    private DataServiceApi dsApi;

    @Autowired
    public void setApi(DataServiceApi api) {
        this.dsApi = api;
    }

    @PostConstruct
    private void register() {
        System.out.println("start to register");

        RegistryData data = new RegistryData();
        data.setApplicationName("springcloud-nacos-provider");
        data.setInterfaceName("/hello");

        ArrayList<String> elements = new ArrayList<>();
        elements.add("world");
        elements.add("java");
        elements.add("python");
        data.setSupportElements(elements);

        CommonResult ret = dsApi.register(data);
        System.out.println(ret);
        System.out.println("registered");
    }

}