package com.example.openfeign.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder{

	@Override
	public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 400:
                log.error("CustomErrorDecoder => HTTP 400");
                return new Exception("HTTP 400");
            case 404:
                log.error("CustomErrorDecoder => HTTP 404");
                return new Exception("HTTP 404");
            default:
                log.error("CustomErrorDecoder => Generic error");
                return new Exception("Generic error");
        }
	}
    
}
