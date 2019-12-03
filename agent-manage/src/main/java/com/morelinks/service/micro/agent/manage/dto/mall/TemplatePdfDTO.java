package com.morelinks.service.micro.agent.manage.dto.mall;

public class TemplatePdfDTO {
private String headerMessage;

/**
 *
 */
private String tipsMessage;

/**
 *
 */
private String footerMessage;

/**
 *
 */
private String watermarkMessage;

public String getHeaderMessage() {
    return headerMessage;
}

public void setHeaderMessage(String headerMessage) {
    this.headerMessage = headerMessage;
}

public String getTipsMessage() {
    return tipsMessage;
}

public void setTipsMessage(String tipsMessage) {
    this.tipsMessage = tipsMessage;
}

public String getFooterMessage() {
    return footerMessage;
}

public void setFooterMessage(String footerMessage) {
    this.footerMessage = footerMessage;
}

public String getWatermarkMessage() {
    return watermarkMessage;
}

public void setWatermarkMessage(String watermarkMessage) {
    this.watermarkMessage = watermarkMessage;
}

@Override
public String toString() {
    return "TemplatePdfDTO{" +
        "headerMessage='" + headerMessage + '\'' +
        ", tipsMessage='" + tipsMessage + '\'' +
        ", footerMessage='" + footerMessage + '\'' +
        ", watermarkMessage='" + watermarkMessage + '\'' +
        '}';
}
}
