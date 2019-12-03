package com.morelinks.service.micro.order.service;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrder;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrderDetail;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrderExtraInfo;
import com.morelinks.service.micro.order.mapper.ConfigPrintOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ConfigPrintOrderService extends BaseServiceWithQueryPage<ConfigPrintOrder, String, ConfigPrintOrderMapper> {
	@Autowired
	ConfigPrintOrderDetailService detailService;
	@Autowired
	ConfigPrintOrderExtraInfoService extraInfoService;

	public Integer PrintingOrder(ConfigPrintOrder order,
	                             List<ConfigPrintOrderDetail> Listdetail,
	                             List<ConfigPrintOrderExtraInfo> ListextraInfo

	) {

		Integer fruit = this.insert(order);
		if (Listdetail.size() != 0) {
			for (ConfigPrintOrderDetail detail : Listdetail) {
				this.detailService.insert(detail);

			}
		}
		if (ListextraInfo.size() != 0) {
			for (ConfigPrintOrderExtraInfo extraInfo : ListextraInfo) {

				this.extraInfoService.insert(extraInfo);
			}

		}


		return fruit;
	}


}