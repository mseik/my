package com.morelinks.service.micro.agent.manage.dto;

public class ExtraDiscountDTO {
    private  String  equipment;//默认设备安装
    private  String  debugging;//默认调试
    private  String  Taxation;//默认税率

public String getEquipment() {
    return equipment;
}

public void setEquipment(String equipment) {
    this.equipment = equipment;
}

public String getDebugging() {
    return debugging;
}

public void setDebugging(String debugging) {
    this.debugging = debugging;
}

public String getTaxation() {
    return Taxation;
}

public void setTaxation(String taxation) {
    Taxation = taxation;
}

@Override
public String toString() {
    return "ExtraDiscountDTO{" +
        "equipment='" + equipment + '\'' +
        ", debugging='" + debugging + '\'' +
        ", Taxation='" + Taxation + '\'' +
        '}';
}
}
