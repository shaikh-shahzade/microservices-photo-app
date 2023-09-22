package com.org.userservice.service;

import com.org.userservice.model.Album;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

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
    @Autowired
    Logger logger = LoggerFactory.getLogger(AlbumService.class);
    @CircuitBreaker(name="PHOTO-SERVICE",fallbackMethod = "getAlbumsFallback")
    @GetMapping("/users/1/albums")
    public List<Album> getAlbums();

    public default List<Album> getAlbumsFallback(Exception e)
    {

        logger.info("Fallback method called for albums service call");
        logger.info(e.getMessage());
        return new ArrayList<Album>();

    }
}
