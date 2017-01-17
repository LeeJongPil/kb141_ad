package org.kb141.dao;

import java.util.List;

import org.kb141.domain.KmeansTestVO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface KMeansTestDAO extends PagingAndSortingRepository<KmeansTestVO, Integer> {

	public List<KmeansTestVO> findAll();
	
	public List<KmeansTestVO> findByGenderEquals(String gender);
	
}
