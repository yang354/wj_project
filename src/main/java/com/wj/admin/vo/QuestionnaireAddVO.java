package com.wj.admin.vo;

import lombok.Data;

@Data
public class QuestionnaireAddVO {
    /**
     * 内容
     */
    private String content;

    /**
     * 金额
     */
    private Integer money;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 连接
     */
    private String link;
}
