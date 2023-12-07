package com.example.travelback.trans.service;

import com.example.travelback.trans.dto.TransLike;
import com.example.travelback.trans.mapper.TransLikeMapper;
import com.example.travelback.user.dto.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class TransLikeService {

    private final TransLikeMapper mapper;

    public void update(TransLike transLike) {
        int count = 0;
        // 처음 누르면 insert
        // 다시 누르면 delete
        // 우선 지웠을때 0으로 나오면 insert 를 실행 시키자
        if(mapper.delete(transLike) == 0) {
            count = mapper.insert(transLike);
        }
    }
}
