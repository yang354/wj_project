package com.wj.admin.vo;

import lombok.Data;

@Data
public class QuestionnaireEditVO {
    private Integer id;
    /**
     * 内容
     */
    private String content;

    /**
     * 金额
     */
    private Integer money;
}
