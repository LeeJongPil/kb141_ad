package org.kb141.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.kb141.domain.LogVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface LogDAO extends PagingAndSortingRepository<LogVO, Integer> {

	public List<LogVO> findAll();
	
	public List<LogVO> findByAdno(Integer adno);
	
	public List<LogVO> findByGenderEquals(String gender);
	
}
