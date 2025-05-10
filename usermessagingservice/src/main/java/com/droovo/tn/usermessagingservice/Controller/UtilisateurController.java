package com.droovo.tn.usermessagingservice.Controller;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.droovo.tn.usermessagingservice.Entites.FileEntity;
import com.droovo.tn.usermessagingservice.Entites.Response.UploadFileResponse;
import com.droovo.tn.usermessagingservice.Entites.Utilisateur;
import com.droovo.tn.usermessagingservice.Services.EmailService;
import com.droovo.tn.usermessagingservice.Services.FileService;
import com.droovo.tn.usermessagingservice.Services.UtilisateurService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("utilisateur")
@AllArgsConstructor
public class UtilisateurController {
    private final UtilisateurService utilisateurService;
    private final EmailService emailService;
    private final FileService dbFileStorageService;



    @PostMapping
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur savedUtilisateur = utilisateurService.saveUtilisateur(utilisateur);
        return new ResponseEntity<>(savedUtilisateur, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Utilisateur> getUtilisateurByEmail(@PathVariable String email) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurByEmail(email);
        if (utilisateur != null) {
            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur updatedUtilisateur = utilisateurService.updateUtilisateur(id, utilisateur);
        if (updatedUtilisateur != null) {
            return new ResponseEntity<>(updatedUtilisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/uploadFile/{userId}")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @PathVariable long userId) {
        FileEntity dbFile = dbFileStorageService.storeFile(file, userId);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
                .path(String.valueOf(dbFile.getId())).toUriString();

        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
    }

    @GetMapping("/downloadFile/{userId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable long userId) {
        // Load file from database
        FileEntity dbFile = dbFileStorageService.getFile(userId);

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }
    @GetMapping("/files")
    public ResponseEntity<List<Resource>> getAllFiles() {
        List<FileEntity> files = dbFileStorageService.getAllFiles();
        List<Resource> resources = files.stream()
                .map(file -> new ByteArrayResource(file.getData()))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(resources);
    }
    @PostMapping("/mail/{userId}")
    public ResponseEntity<String> sendMail(@PathVariable long userId) {
        Utilisateur user = utilisateurService.getUtilisateurById(userId);
        emailService.sendEmailWithTemplate(user);
        return new ResponseEntity<String>("Mail sent", HttpStatus.OK);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countUtilisateur() {
        long count = utilisateurService.countUtilisateur();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

}