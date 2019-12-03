package com.morelinks.service.micro.agent.manage.dto;

public class MeteringDTO {
    private  String name;
/**
 * 提供的所有
 */
private  Integer  possess;
/**
 * 提供-需要
 */
    private  Integer need;
/**
 * 需要的所有
 */
private  Integer needAll;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Integer getPossess() {
    return possess;
}

public void setPossess(Integer possess) {
    this.possess = possess;
}

public Integer getNeed() {

    return this.need=this.needAll-this.possess>=0 ?  this.needAll-this.possess : 0 ;
}

public void setNeed(Integer need) {
    this.need = need;
}

public Integer getNeedAll() {
    return needAll;
}

public void setNeedAll(Integer needAll) {
    this.needAll = needAll;
}

@Override
public String toString() {
    return "MeteringDTO{" +
        "name='" + name + '\'' +
        ", possess=" + possess +
        ", need=" + need +
        '}';
}
}
