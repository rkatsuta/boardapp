package com.rkatsuta.boardapp.domain.model;

import com.rkatsuta.boardapp.domain.type.Comment;
import com.rkatsuta.boardapp.domain.type.MailAddress;
import com.rkatsuta.boardapp.domain.type.Name;
import com.rkatsuta.boardapp.domain.type.PostTime;
import com.rkatsuta.boardapp.dto.UserCommentReadDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserComments {

    private final List<UserComment> values;

    public static UserComments from(List<UserComment> comments) {
        if (CollectionUtils.isEmpty(comments)) {
            return new UserComments(Collections.EMPTY_LIST);
        }
        return new UserComments(comments);
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class UserComment {
        private final int id;
        private final Name name;
        private final MailAddress mailAddress;
        private final Comment comment;
        private final PostTime postTime;

        public static UserComment from(
                int id,
                String name,
                String mailAddress,
                String comment,
                LocalDateTime postTime) {
            return new UserComment(
                    id,
                    Name.from(name),
                    MailAddress.from(mailAddress),
                    Comment.from(comment),
                    PostTime.from(postTime)
            );
        }
    }
}
