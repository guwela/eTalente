package com.eviro.assessment.grad001.pardonandmabasa.controller;

import com.eviro.assessment.grad001.pardonandmabasa.entity.AccountProfile;
import com.eviro.assessment.grad001.pardonandmabasa.repository.AccountProfileRepository;
import com.eviro.assessment.grad001.pardonandmabasa.service.FileParser;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/v1/api/image")
public class ImageController {

    private final FileParser fileParser;
    private final AccountProfileRepository accountProfileRepository;

    public ImageController(FileParser fileParser, AccountProfileRepository accountProfileRepository) {
        this.fileParser = fileParser;
        this.accountProfileRepository = accountProfileRepository;
    }

    @PostMapping("/upload")
    public void uploadCSV(@RequestParam("file") MultipartFile csvFile) {
        fileParser.parseCSV(csvFile);
    }

    @GetMapping("/{id}/image")
    public FileSystemResource getImageLink(@PathVariable Long id) throws IOException {
        AccountProfile accountProfile = accountProfileRepository.findById(id).orElseThrow();
        File imageFile = fileParser.convertCSDataToImage(accountProfile.getBase64ImageData());
        URI imageLink = fileParser.createImageLink(imageFile);
        return new FileSystemResource(imageLink.getPath());
    }
}
