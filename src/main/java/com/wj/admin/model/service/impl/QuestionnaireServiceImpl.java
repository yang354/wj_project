package com.wj.admin.model.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wj.admin.vo.QuestionnaireAddVO;
import com.wj.admin.exception.MyException;
import com.wj.admin.model.entity.Questionnaire;
import com.wj.admin.model.dao.QuestionnaireMapper;
import com.wj.admin.model.service.QuestionnaireService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wj.admin.util.ResultCode;
import com.wj.admin.vo.QuestionnaireEditVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
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
        BeanUtils.copyProperties(questionnaireAddVO, questionnaire);
        int index = baseMapper.insert(questionnaire);
        if (index == 0) {
            throw new MyException(ResultCode.ERROR, "新建问卷失败");
        }
    }

    @Override
    public void edit(QuestionnaireEditVO questionnaireEditVO) {
        // TODO: 2022/9/16 需要编写编辑功能
        Questionnaire questionnaire = new Questionnaire();
        BeanUtils.copyProperties(questionnaireEditVO, questionnaire);
        int index = baseMapper.updateById(questionnaire);
        if (index == 0) {
            throw new MyException(ResultCode.ERROR, "编辑问卷失败");
        }
    }

    @Override
    public void del(Integer questionnaireId) {
        // TODO: 2022/9/16 需要编写删除功能
        int index = baseMapper.deleteById(questionnaireId);
        if (index == 0) {
            throw new MyException(ResultCode.ERROR, "删除问卷失败");
        }
    }

    @Override
    public Questionnaire search(Integer questionnaireId) {
        // TODO: 2022/9/16 需要编写查看一篇问卷功能
        Questionnaire questionnaire = baseMapper.selectById(questionnaireId);
        if (ObjectUtils.isEmpty(questionnaire)) {
            throw new MyException(ResultCode.ERROR, "查看问卷失败");
        }
        return questionnaire;
    }

    @Override
    public List<Questionnaire> searchAll() {
        // TODO: 2022/9/16 需要编写查看所有问卷功能
        QueryWrapper<Questionnaire> questionnaireQueryWrapper = new QueryWrapper<>();
        questionnaireQueryWrapper.lambda().orderByAsc(Questionnaire::getCreateTime);
        List<Questionnaire> questionnaires = baseMapper.selectList(questionnaireQueryWrapper);
        if (questionnaires == null || questionnaires.size() == 0 ) {
            throw new MyException(ResultCode.ERROR, "查看问卷失败");
        }
        return questionnaires;
    }
}
