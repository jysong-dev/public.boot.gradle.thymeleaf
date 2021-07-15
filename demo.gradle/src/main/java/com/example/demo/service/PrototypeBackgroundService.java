package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.PrototypeBackgroundVO;
import com.example.demo.repository.PrototypeBackgroundRepository;

@Service
public class PrototypeBackgroundService {

	@Autowired
	public PrototypeBackgroundRepository prototypeBackgroundRepository;

	public PrototypeBackgroundVO findByPrototypeId(PrototypeBackgroundVO prototypeBackgroundVO) {
		return prototypeBackgroundRepository.findByPrototypeId(prototypeBackgroundVO.getPrototypeId())
											.orElse(null);
	}

	public void save(PrototypeBackgroundVO prototypeBackgroundVO) {
		prototypeBackgroundRepository.save(prototypeBackgroundVO);
	}

	public void updateByPrototypeId(PrototypeBackgroundVO prototypeBackgroundVO) {
		Optional<PrototypeBackgroundVO> e = prototypeBackgroundRepository.findByPrototypeId(prototypeBackgroundVO.getPrototypeId());

		if (e.isPresent()) {
			e.get().setPrototypeId(prototypeBackgroundVO.getPrototypeId());
			e.get().setBackgroundId(prototypeBackgroundVO.getBackgroundId());
			e.get().setFileMasterId(prototypeBackgroundVO.getFileMasterId());
			e.get().setRegistDatetime(prototypeBackgroundVO.getRegistDatetime());
			prototypeBackgroundRepository.save(prototypeBackgroundVO);
		}
	}
	
}
