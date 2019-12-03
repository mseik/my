package com.morelinks.feign.micro.file.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.file.api.dto.UploadFileResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/file")
public interface IFileController {
    @RequestMapping(value = "/uploadFile", method = {RequestMethod.POST})
    ReturnValue<UploadFileResult> uploadFile(@RequestParam(name = "scene") String scene,
                                             @RequestParam(name = "uploadFileName") String uploadFileName,
                                             @RequestParam(name = "generateName") Boolean generateName,
                                             @RequestParam(name = "file") byte[] bytes);
}