package com.rkatsuta.boardapp.domain.model;

public interface UserCommentRepository {
    void save(UserComment userComment);
    UserComments select();
}
