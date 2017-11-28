package com.navnbp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navnbp.entity.DistributionCenter;

@Service
public interface DistributionCenterService {

	DistributionCenter[] getAllDistributionCenters();

	DistributionCenter addDistributionCenter(DistributionCenter distributionCenter);

}
