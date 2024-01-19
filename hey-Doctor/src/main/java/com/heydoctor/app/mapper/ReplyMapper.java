package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.dto.ReplyDTO;
import com.heydoctor.app.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    public void insert(ReplyVO replyVO);

    public Integer count(Long answerId);

    public ReplyDTO select(Long replyId);

    public List<ReplyDTO> selectAllReplyDTO(List<Long> answerIds);
    //    댓글 삭제
    public void delete(Long replyId);

    //    게시글의 댓글 전체 삭제
    public void deleteAll(Long answerId);

    public List<ReplyVO> selectAllAnswerReply();
}
