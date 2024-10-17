package com.bmn.e_commerce.services.interfaces;

import com.bmn.e_commerce.models.Path;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PathService {

    Path upload(MultipartFile file, Long id) throws IOException;

    byte[] download(String fileName) throws IOException;
}
