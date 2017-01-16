package org.kb141.dao;

import org.kb141.domain.DeviceVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceDAO extends JpaRepository<DeviceVO, Integer> {

}
