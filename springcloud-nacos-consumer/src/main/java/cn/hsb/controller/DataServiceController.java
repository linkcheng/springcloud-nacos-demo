package cn.hsb.controller;

import cn.hsb.dto.CommonResult;
import cn.hsb.dto.RegistryData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RestController
public class DataServiceController {
    private Map<String, String> conMap = new ConcurrentHashMap<>();
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/element")
    public String postElement(@RequestBody Map<String, String> data) {
        String name = data.get("key");
        String path = conMap.get(data.get("key"));
        if (path == null) {
            return name + " not configured";
        }
        return restTemplate.postForObject(path, name, String.class);
    }

    @GetMapping("/map")
    public Map<String, String> getMap() {
        return conMap;
    }

    /**
     * 服务注册
     */
    @PostMapping("/register")
    public CommonResult register(@RequestBody RegistryData data) {
        List<String> elements = data.getSupportElements();
        final String path = concatUrl(data.getApplicationName(), data.getInterfaceName());

        elements.forEach(e -> conMap.put(e, path));
        return new CommonResult(200, "SUCCESS");
    }

    private String concatUrl(String app, String name) {
        log.info("application name="+app);
        log.info("interface name="+name);
        if(name.startsWith("/")) {
            return "http://" + app + name;
        }
        else {
            return "http://" + app + "/" + name;
        }
    }
}
