package cn.hsb.consumer.api;

import cn.hsb.dto.CommonResult;
import cn.hsb.dto.RegistryData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "${bi-model.consumer-server}")
public interface DataServiceApi {
    @PostMapping("/register")
    CommonResult register(@RequestBody RegistryData data);
}
