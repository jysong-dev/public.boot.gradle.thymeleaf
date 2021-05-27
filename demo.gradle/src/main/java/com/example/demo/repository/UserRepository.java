package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.UserVO;

@Repository
public interface UserRepository extends JpaRepository<UserVO, BigDecimal> {
	
//	And => findByLastnameAndFirstname (EX. where x.lastname = ?1 and x.firstname = ?2)
//	Or => findByLastnameOrFirstname (EX. where x.lastname = ?1 or x.firstname = ?2)
//	Is, Equals => findByName,findByNameIs,findByNameEquals (EX. where x.name = 1?)
//	Between => findBySalBetween(EX. where x.sal between 1? and ?2)
	
	// findBy뒤에 컬럼명을 붙여주면 이를 이용한 검색이 가능
	public UserVO findByUserIdAndPassword(String userId, String password);

	public List<UserVO> findAll();
	
	//public List findByName(String name);
	//like검색도 가능
	//public List findByNameLike(String keyword);
}
