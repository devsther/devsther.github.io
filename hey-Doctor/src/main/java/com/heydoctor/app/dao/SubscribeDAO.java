package com.heydoctor.app.dao;

import com.heydoctor.app.mapper.SubscribeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SubscribeDAO {
    private final SubscribeMapper subscribeMapper;
}
