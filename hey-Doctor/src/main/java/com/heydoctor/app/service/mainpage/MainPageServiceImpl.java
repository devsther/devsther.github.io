package com.heydoctor.app.service.mainpage;

import com.heydoctor.app.dao.MainDAO;
import com.heydoctor.app.domain.dto.MainDTO;
import com.heydoctor.app.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainPageServiceImpl implements MainPageService {
    private final MainDTO mainDTO;
    private final MainDAO mainDAO;

//    @Override
//    public List<MainDTO> selectReadCount() {
//        return mainDAO.findReadCount();
//    }

    @Override
    public List<MainDTO> selectQuestionReadCount() {
        return mainDAO.findQuestionReadCount();
    }

    @Override
    public List<MainDTO> selectAnswerAll() {
        return mainDAO.findAnswerAll();
    }

    @Override
    public List<MainDTO> selectAdopCount() {
        return mainDAO.findAdopCount();
    }
    @Override
    public List<MainDTO> selectVisitCount() {
        return mainDAO.findVisitCount();
    }

    @Override
    public Optional<UserVO> selectUserId(Long userId) {
        return mainDAO.getUserId();
    }

}
