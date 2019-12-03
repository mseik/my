package com.morelinks.feign.micro.device.api.model;

/**
 * 描述:net_device_info表的实体类
 * @version
 * @author:  sgfily
 */
public class NetDeviceInfo {
    /**
     * 
     */
    private Integer deviceId;

    /**
     * 生成id类型 1:number 2:uuid
     */
    private Integer genType;

    /**
     * 当网关生成类型是1时 即数据型 则该字段为当前可生成的最大id
     */
    private Integer genMaxId;

    /**
     * 
     */
    private Long version;

    /**
     * 
     * @return device_id 
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * 
     * @param deviceId 
     */
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 生成id类型 1:number 2:uuid
     * @return gen_type 生成id类型 1:number 2:uuid
     */
    public Integer getGenType() {
        return genType;
    }

    /**
     * 生成id类型 1:number 2:uuid
     * @param genType 生成id类型 1:number 2:uuid
     */
    public void setGenType(Integer genType) {
        this.genType = genType;
    }

    /**
     * 当网关生成类型是1时 即数据型 则该字段为当前可生成的最大id
     * @return gen_max_id 当网关生成类型是1时 即数据型 则该字段为当前可生成的最大id
     */
    public Integer getGenMaxId() {
        return genMaxId;
    }

    /**
     * 当网关生成类型是1时 即数据型 则该字段为当前可生成的最大id
     * @param genMaxId 当网关生成类型是1时 即数据型 则该字段为当前可生成的最大id
     */
    public void setGenMaxId(Integer genMaxId) {
        this.genMaxId = genMaxId;
    }

    /**
     * 
     * @return version 
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 
     * @param version 
     */
    public void setVersion(Long version) {
        this.version = version;
    }
}