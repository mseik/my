package com.morelinks.service.micro.product.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.product.api.model.DiscountInfo;
import com.morelinks.service.micro.product.mapper.DiscountInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class DiscountInfoService extends BaseServiceWithQueryPage<DiscountInfo,Integer,DiscountInfoMapper> {

	public List<DiscountInfo> getValidDiscounts(String discountKey,
	                                                         Integer discountType,
	                                                         Integer memberLevel
	) {
		List<DiscountInfo> lstInfo = new ArrayList<>();
		DiscountInfo query = new DiscountInfo();
		query.setDiscountKey(discountKey);
		query.setDiscountType(discountType);
		query.setDiscountStatus(2);
		List<DiscountInfo> lst =this.find(query,null);
		if(lst!=null)
		{
			for (DiscountInfo discount:lst
					) {
				if(discount.getValidStartTime()!=null
						&& discount.getValidStartTime().after(new Date()))
				{
					continue;
				}
				if(discount.getValidEndTime()!=null
						&& discount.getValidEndTime().before(new Date()))
				{
					discount.setDiscountStatus(3);
					discount.setUpdateTime(new Date());
					this.mapper.updateByPrimaryKeySelective(discount);
					continue;
				}
				lstInfo.add(discount);
			}
		}
		return lstInfo;
	}
}