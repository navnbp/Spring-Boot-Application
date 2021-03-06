package com.navnbp.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.navnbp.config.RestServiceCall;
import com.navnbp.entity.DistributionCenter;
import com.navnbp.service.DistributionCenterService;

@Service
public class DistributionCenterServiceImpl implements DistributionCenterService {

	@Autowired
	private RestServiceCall restServiceCall;

	@Override
	public DistributionCenter[] getAllDistributionCenters() {
		
		ResponseEntity<DistributionCenter[]> response = restServiceCall.execute("/distribution/get", HttpMethod.GET, null,
				DistributionCenter[].class);

		return response.getBody();
	}

	@Override
	public DistributionCenter addDistributionCenter(DistributionCenter distributionCenter) {
		ResponseEntity<DistributionCenter> result = restServiceCall.execute("/distribution/add", HttpMethod.POST,
				distributionCenter, DistributionCenter.class);
		return result.getBody();

	}
}
