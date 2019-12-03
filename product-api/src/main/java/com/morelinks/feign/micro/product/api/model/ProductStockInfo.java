package com.morelinks.feign.micro.product.api.model;

import java.util.Date;

/**
 * 描述:product_stock_info表的实体类
 * @version
 */
public class ProductStockInfo {
    /**
     * 
     */
    private Integer id;

    /**
     * 产品Id
     */
    private Integer productId;

    /**
     * 库存数量 只有进出库的时候进行操作
     */
    private Integer remainQuantity;

    /**
     * 报警数量
     */
    private Integer alarmQuantity;

    /**
     * 正在进行中的设备数量，库存数量-操作数量 则为当前可下单的设备数量
     */
    private Integer operateQuantity;

    /**
     * 库存状态
     */
    private Integer stockStatus;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 更新时间戳 用于更新时判断冲突
     */
    private Date updateVersion;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 产品Id
     * @return product_id 产品Id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 产品Id
     * @param productId 产品Id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 库存数量 只有进出库的时候进行操作
     * @return remain_quantity 库存数量 只有进出库的时候进行操作
     */
    public Integer getRemainQuantity() {
        return remainQuantity;
    }

    /**
     * 库存数量 只有进出库的时候进行操作
     * @param remainQuantity 库存数量 只有进出库的时候进行操作
     */
    public void setRemainQuantity(Integer remainQuantity) {
        this.remainQuantity = remainQuantity;
    }

    /**
     * 报警数量
     * @return alarm_quantity 报警数量
     */
    public Integer getAlarmQuantity() {
        return alarmQuantity;
    }

    /**
     * 报警数量
     * @param alarmQuantity 报警数量
     */
    public void setAlarmQuantity(Integer alarmQuantity) {
        this.alarmQuantity = alarmQuantity;
    }

    /**
     * 正在进行中的设备数量，库存数量-操作数量 则为当前可下单的设备数量
     * @return operate_quantity 正在进行中的设备数量，库存数量-操作数量 则为当前可下单的设备数量
     */
    public Integer getOperateQuantity() {
        return operateQuantity;
    }

    /**
     * 正在进行中的设备数量，库存数量-操作数量 则为当前可下单的设备数量
     * @param operateQuantity 正在进行中的设备数量，库存数量-操作数量 则为当前可下单的设备数量
     */
    public void setOperateQuantity(Integer operateQuantity) {
        this.operateQuantity = operateQuantity;
    }

    /**
     * 库存状态
     * @return stock_status 库存状态
     */
    public Integer getStockStatus() {
        return stockStatus;
    }

    /**
     * 库存状态
     * @param stockStatus 库存状态
     */
    public void setStockStatus(Integer stockStatus) {
        this.stockStatus = stockStatus;
    }

    /**
     * 
     * @return create_time 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return update_time 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     * @param updateTime 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 更新时间戳 用于更新时判断冲突
     * @return update_version 更新时间戳 用于更新时判断冲突
     */
    public Date getUpdateVersion() {
        return updateVersion;
    }

    /**
     * 更新时间戳 用于更新时判断冲突
     * @param updateVersion 更新时间戳 用于更新时判断冲突
     */
    public void setUpdateVersion(Date updateVersion) {
        this.updateVersion = updateVersion;
    }
}