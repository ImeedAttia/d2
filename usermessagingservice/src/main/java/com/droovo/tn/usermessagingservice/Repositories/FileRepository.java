package com.droovo.tn.usermessagingservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.droovo.tn.usermessagingservice.Entites.FileEntity;

import java.util.Optional;

public interface FileRepository extends JpaRepository<FileEntity,Long> {
    Optional<FileEntity> findByUserId(Long userId);
}
