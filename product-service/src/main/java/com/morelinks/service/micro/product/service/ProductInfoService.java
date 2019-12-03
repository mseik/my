package com.morelinks.service.micro.product.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.product.api.model.ProductInfo;
import com.morelinks.service.micro.product.mapper.ProductInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductInfoService extends BaseServiceWithQueryPage<ProductInfo,Integer,ProductInfoMapper> {

	public String getSerialNoById(Integer id,int len)
	{
		String serialNo ="";
		if(id==null || len<=0)
		{
			return "";
		}
		if(len<8)
		{
			return String.format("%08d",id);
		}
		String[] arr = new String[len];
		for(int i=0;i<len;i++)
		{
			arr[i]=getConvertNo(id%10)+"";
			id=id/10;
		}
		String swapStr ="";
		swapStr=arr[4];
        arr[4]=arr[0];
		arr[0]=swapStr;

		swapStr=arr[3];
		arr[3]=arr[1];
		arr[1]=swapStr;

		swapStr=arr[6];
		arr[6]=arr[2];
		arr[2]=swapStr;

		swapStr=arr[7];
		arr[7]=arr[5];
		arr[5]=swapStr;
		for(int i=0;i<len;i++)
		{
			serialNo+=arr[i];
		}
		return serialNo;
	}

	private int getConvertNo(int i)
	{
		if(i<0 || i>9)
		{
			return i;
		}
		int convertNo=0;
		switch (i)
		{
			case 0:convertNo=5;break;
			case 1:convertNo=2;break;
			case 2:convertNo=1;break;
			case 3:convertNo=7;break;
			case 4:convertNo=9;break;
			case 5:convertNo=0;break;
			case 6:convertNo=8;break;
			case 7:convertNo=3;break;
			case 8:convertNo=6;break;
			case 9:convertNo=4;break;
		}
		return convertNo;
	}



}