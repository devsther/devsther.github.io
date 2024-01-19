package com.heydoctor.app.dao;

import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.enums.DepartmentType;
import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class QuestionDAO {
    private final QuestionMapper questionMapper;

    public List<QuestionListDTO> findAll(Integer page) {
        return questionMapper.selectList(page, DepartmentType.ALL.name());
    }

    public List<QuestionListDTO> findAll(Integer page, String type) {
        return questionMapper.selectList(page, type);
    }

    public Optional<QuestionDTO> findById(Long questionId) {
        return Optional.ofNullable(questionMapper.selectOne(questionId));
    }

    public void setQuestionVO(QuestionVO questionVO) {
        questionMapper.insert(questionVO);
    }


    //    커뮤니티 좋아요 순 정렬
    public List<QuestionVO> findReadDescAll() {
           return questionMapper.selectReadDESCAll();
    }


    public void addCount(Long questionId) {
        questionMapper.updateReadCount(questionId);
    }

}
