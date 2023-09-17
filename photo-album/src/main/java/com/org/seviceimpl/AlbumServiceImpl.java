package com.org.seviceimpl;

import com.org.model.AlbumResponse;
import com.org.service.AlbumsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumsService {
    @Override
    public List<AlbumResponse> getAlbums(String userId) {
        List<AlbumResponse> returnValue = new ArrayList<>();

        AlbumResponse albumEntity = new AlbumResponse();
        albumEntity.setUserId(userId);
        albumEntity.setAlbumId("album1Id");
        albumEntity.setDescription("album 1 description");
        albumEntity.setId(1L);
        albumEntity.setName("album 1 name");

        AlbumResponse albumEntity2 = new AlbumResponse();
        albumEntity2.setUserId(userId);
        albumEntity2.setAlbumId("album2Id");
        albumEntity2.setDescription("album 2 description");
        albumEntity2.setId(2L);
        albumEntity2.setName("album 2 name");

        returnValue.add(albumEntity);
        returnValue.add(albumEntity2);

        return returnValue;
    }
}
