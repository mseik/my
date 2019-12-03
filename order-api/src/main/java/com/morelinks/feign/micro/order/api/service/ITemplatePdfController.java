package com.morelinks.feign.micro.order.api.service;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.TemplatePdf;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@RequestMapping("/templatePdfController")
public interface ITemplatePdfController {
@RequestMapping(value = "/insert", method = {RequestMethod.POST})
ReturnValue<Integer> insert(@RequestBody TemplatePdf obj);

@RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<TemplatePdf> getByPrimaryKey(@RequestParam(name = "id") Integer id);

@RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

@RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
ReturnValue<Integer> updateByPrimaryKey(@RequestBody TemplatePdf obj);

@RequestMapping(value = "/find", method = {RequestMethod.POST})
ReturnValue<List<TemplatePdf>> find(@RequestBody QueryPageParam<TemplatePdf> query);

@RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
ReturnValue<QueryResult<TemplatePdf>> getQueryResult(@RequestBody QueryPageParam<TemplatePdf> query) ;

@RequestMapping(value = "/getTop1", method = {RequestMethod.POST})
ReturnValue<TemplatePdf>   getTop1(@RequestBody TemplatePdf obj);
}
