package com.org.userservice.service;

import com.org.userservice.model.Album;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "PHOTO-SERVICE")
public interface AlbumService {
    //@Autowired


    @GetMapping("/users/1/albums")
    @CircuitBreaker(name="Photo-service-circuitbreaker",fallbackMethod = "getAlbumsFallback")
    @Retry(name="Photo-service-circuitbreaker")
    public List<Album> getAlbums();

    public default List<Album> getAlbumsFallback(Exception e)
    {
        Logger logger = LoggerFactory.getLogger(AlbumService.class);
        logger.info("Fallback method called for albums service call");
        logger.info(e.getMessage());
        logger.debug("Calling microservice");
        logger.debug(e.getMessage());
        System.out.println(e);
        return new ArrayList<Album>();

    }
}
