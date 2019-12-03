package com.morelinks.service.micro.agent.manage.dto;

public class CategoryDTO {
    private String  Label ;
    private  Integer value;

public String getLabel() {
    return Label;
}

public void setLabel(String label) {
    Label = label;
}

public Integer getValue() {
    return value;
}

public void setValue(Integer value) {
    this.value = value;
}

@Override
public String toString() {
    return "CategoryDTO{" +
        "Label='" + Label + '\'' +
        ", value=" + value +
        '}';
}
}
