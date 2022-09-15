package com.wj.admin.model.service.impl;

import com.wj.admin.vo.QuestionnaireAddVO;
import com.wj.admin.exception.MyException;
import com.wj.admin.model.entity.Questionnaire;
import com.wj.admin.model.dao.QuestionnaireMapper;
import com.wj.admin.model.service.QuestionnaireService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wj.admin.util.ResultCode;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yyyz
 * @since 2022-09-15
 */
@Transactional
@Service
public class QuestionnaireServiceImpl extends ServiceImpl<QuestionnaireMapper, Questionnaire> implements QuestionnaireService {

    @Override
    public void add(QuestionnaireAddVO questionnaireAddVO) {
        Questionnaire questionnaire = new Questionnaire();
        BeanUtils.copyProperties(questionnaireAddVO,questionnaire);
        int index = baseMapper.insert(questionnaire);
        if (index==0){
            throw new MyException(ResultCode.ERROR,"新建问卷失败");
        }
    }
}
