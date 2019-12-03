package com.morelinks.service.micro.order.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.TemplatePdf;
import com.morelinks.feign.micro.order.api.service.ITemplatePdfController;
import com.morelinks.service.micro.order.service.TemplatePdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class TemplatePdfController implements ITemplatePdfController {
@Autowired
TemplatePdfService pdfService;
@Override
public ReturnValue<Integer> insert(@RequestBody TemplatePdf obj) {
    return ReturnValue.get200OK(this.pdfService.insert(obj));
}

@Override
public ReturnValue<TemplatePdf> getByPrimaryKey(@RequestParam(name = "id") Integer id) {
    return ReturnValue.get200OK(this.pdfService.getByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id) {
    return ReturnValue.get200OK(this.pdfService.deleteByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> updateByPrimaryKey(@RequestBody TemplatePdf obj) {
    return ReturnValue.get200OK(this.pdfService.updateByPrimaryKey(obj));
}

@Override
public ReturnValue<List<TemplatePdf>> find(@RequestBody QueryPageParam<TemplatePdf> query) {
    return ReturnValue.get200OK(this.pdfService.find(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<QueryResult<TemplatePdf>> getQueryResult(@RequestBody QueryPageParam<TemplatePdf> query) {

    return ReturnValue.get200OK(this.pdfService.getQueryResult(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<TemplatePdf> getTop1(@RequestBody TemplatePdf obj) {
    return ReturnValue.get200OK(this.pdfService.findTop1(obj));
}
}
