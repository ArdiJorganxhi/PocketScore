package dev.ardijorganxhi.pocketscore.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaginationUtils {

    public static Pageable getPageable(Integer page, Integer size, Sort.Direction direction, String sortField) {
        return PageRequest.of(page - 1, size, direction, sortField);
    }
}
