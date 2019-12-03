package com.morelinks.feign.micro.file.api.client;

import com.morelinks.feign.micro.file.api.service.IFileController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "${micro.feign.proxy.file.name:morelinks-file-service}")
public interface FileFeignClient extends IFileController {

}