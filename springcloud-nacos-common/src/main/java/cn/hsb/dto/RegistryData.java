package cn.hsb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistryData {
    // 服务名称
    private String applicationName;
    // 支持的因子列表
    private List<String> supportElements;
    // 接口名称，default: /elements
    private String interfaceName = "/elements";
}
