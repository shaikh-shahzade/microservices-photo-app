package com.org.userservice.service;

import com.org.userservice.model.Album;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "PHOTO-SERVICE")
public interface AlbumService {
    @GetMapping("/users/1/albums")
    public List<Album> getAlbums();
}
