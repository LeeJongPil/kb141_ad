package org.kb141.dao;

import org.kb141.domain.ClientVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDAO extends JpaRepository<ClientVO, String> {

}
