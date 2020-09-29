package com.example.toyforhrteamproject.controller;

import com.example.toyforhrteamproject.service.S3Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/s3")
public class S3Controller {

    @Autowired
    S3Services s3Services;

    @GetMapping("/hello")
    public void hi(){
        System.out.println("hello");
    }
    /*
     * Download Files
     */
    @GetMapping("/api/file/{keyname}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String keyname) {
        ByteArrayOutputStream downloadInputStream = s3Services.downloadFile(keyname);

        return ResponseEntity.ok()
                .contentType(contentType(keyname))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + keyname + "\"")
                .body(downloadInputStream.toByteArray());
    }

    /*
     * List ALL Files
     */
    @GetMapping("/api/file/all")
    public List<String> listAllFiles(){
        return s3Services.listFiles();
    }

    private MediaType contentType(String keyname) {
        String[] arr = keyname.split("\\.");
        String type = arr[arr.length-1];
        switch(type) {
            case "txt": return MediaType.TEXT_PLAIN;
            case "png": return MediaType.IMAGE_PNG;
            case "jpg": return MediaType.IMAGE_JPEG;
            default: return MediaType.APPLICATION_OCTET_STREAM;
        }
    }

    /*
     * Upload a File
     */
    @PostMapping("/api/file/upload")
    public String uploadMultipartFile(@RequestParam("file") MultipartFile file) {
        String keyName = file.getOriginalFilename();
        s3Services.uploadFile(keyName, file);
        return "Upload Successfully -> KeyName = " + keyName;
    }
}
