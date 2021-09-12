package com.rkatsuta.boardapp.infrastructure.datasource;

import com.rkatsuta.boardapp.dto.UserCommentDto;
import com.rkatsuta.boardapp.dto.UserCommentReadDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserCommentMapper {
    @Insert("sql/insertUserComment.sql")
    void insert(@Param("dto")UserCommentDto dto);

    @Select("sql/selectUserComment.sql")
    List<UserCommentReadDto> select();
}
