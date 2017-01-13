package org.kb141.dao;

import org.kb141.domain.BoardVO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BoardDAO extends PagingAndSortingRepository<BoardVO, Integer>  {

}
