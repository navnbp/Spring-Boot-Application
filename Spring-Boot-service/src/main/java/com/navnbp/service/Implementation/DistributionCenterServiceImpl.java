package com.navnbp.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navnbp.entity.DistributionCenter;
import com.navnbp.repository.DistributionCenterRepository;
import com.navnbp.service.DistributionCenterService;

@Service
public class DistributionCenterServiceImpl implements DistributionCenterService {

	@Autowired
	private DistributionCenterRepository distributionCenterRepository;

	@Override
	public List<DistributionCenter> getAllDistributionCenters() {
		
		return distributionCenterRepository.findAll();
	}

	@Override
	public DistributionCenter addDistributionCenter(DistributionCenter distributionCenter) {
	 return	distributionCenterRepository.save(distributionCenter);
		
	}
}
