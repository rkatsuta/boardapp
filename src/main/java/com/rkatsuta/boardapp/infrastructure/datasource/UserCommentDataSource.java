package com.rkatsuta.boardapp.infrastructure.datasource;

import com.rkatsuta.boardapp.domain.model.UserComment;
import com.rkatsuta.boardapp.domain.model.UserCommentRepository;
import com.rkatsuta.boardapp.domain.model.UserComments;
import com.rkatsuta.boardapp.dto.UserCommentDto;
import com.rkatsuta.boardapp.dto.UserCommentReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class UserCommentDataSource implements UserCommentRepository {

    private final UserCommentMapper mapper;

    @Override
    public void save(UserComment userComment) {
        mapper.insert(UserCommentDto.from(userComment));
    }

    @Override
    public UserComments select() {
        List<UserCommentReadDto> dtos = mapper.select();
        return UserComments.from(
                dtos.stream().map( dto -> UserComments.UserComment.from(
                        dto.getId(),
                        dto.getName(),
                        dto.getMailAddress(),
                        dto.getComment(),
                        dto.getCreatedAt()
                )).collect(Collectors.toUnmodifiableList())
        );

    }
}
