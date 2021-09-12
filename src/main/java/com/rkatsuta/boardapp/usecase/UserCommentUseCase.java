package com.rkatsuta.boardapp.usecase;

import com.rkatsuta.boardapp.application.form.CommentForm;
import com.rkatsuta.boardapp.domain.model.UserComment;
import com.rkatsuta.boardapp.domain.model.UserCommentRepository;
import com.rkatsuta.boardapp.domain.model.UserComments;
import com.rkatsuta.boardapp.domain.type.Comment;
import com.rkatsuta.boardapp.domain.type.MailAddress;
import com.rkatsuta.boardapp.domain.type.Name;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserCommentUseCase {

    private final UserCommentRepository repository;

    public void write(CommentForm commentForm) {
        // フォームからドメインに変換
        UserComment userComment = UserComment.from(
                commentForm.getName(),
                commentForm.getMailAddress(),
                commentForm.getComment()
        );

        // DB登録
        repository.save(userComment);
    }

    public UserComments read() {
        return repository.select();
    }
}
