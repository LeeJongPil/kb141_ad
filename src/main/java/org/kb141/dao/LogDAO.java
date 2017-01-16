package org.kb141.dao;

import org.kb141.domain.LogVO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LogDAO extends PagingAndSortingRepository<LogVO, Integer> {

}
