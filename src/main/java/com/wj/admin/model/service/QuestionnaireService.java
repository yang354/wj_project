package com.wj.admin.model.service;

import com.wj.admin.vo.QuestionnaireAddVO;
import com.wj.admin.model.entity.Questionnaire;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wj.admin.vo.QuestionnaireEditVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yyyz
 * @since 2022-09-15
 */
public interface QuestionnaireService extends IService<Questionnaire> {

    void add(QuestionnaireAddVO questionnaireAddVO);

    void edit(QuestionnaireEditVO questionnaireEditVO);

    void del(Integer questionnaireId);

    Questionnaire search(Integer questionnaireId);

    List<Questionnaire> searchAll();
}
