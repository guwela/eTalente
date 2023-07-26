package com.eviro.assessment.grad001.pardonandmabasa.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public interface FileParser {
    void parseCSV(MultipartFile csvFile);

    File convertCSDataToImage(String base64ImageData) throws IOException;

    URI createImageLink(File fileImage);
}
