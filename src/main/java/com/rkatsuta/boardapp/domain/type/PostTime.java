package com.rkatsuta.boardapp.domain.type;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.util.privilegedactions.LoadClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class PostTime {

    private final LocalDateTime value;
    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    public static PostTime from(LocalDateTime postTime) {
        return new PostTime(postTime);
    }

    @Override
    public String toString() {
        return value.format(formatter);
    }

}
