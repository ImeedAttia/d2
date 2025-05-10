package com.droovo.tn.usermessagingservice.Services;

import org.springframework.web.multipart.MultipartFile;
import com.droovo.tn.usermessagingservice.Entites.FileEntity;

import java.util.List;

public interface FileService {
    FileEntity storeFile(MultipartFile file, long userId);
    FileEntity getFile(long userId);
    public List<FileEntity> getAllFiles();
}
