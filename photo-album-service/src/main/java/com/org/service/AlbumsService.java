package com.org.service;

import com.org.model.AlbumResponse;

import java.util.List;

public interface AlbumsService {
    List<AlbumResponse> getAlbums(String userId);

}
