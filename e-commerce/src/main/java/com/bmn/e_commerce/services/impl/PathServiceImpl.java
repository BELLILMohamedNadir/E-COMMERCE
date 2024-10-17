package com.bmn.e_commerce.services.impl;

import com.bmn.e_commerce.models.Path;
import com.bmn.e_commerce.models.Product;
import com.bmn.e_commerce.repositories.PathRepository;
import com.bmn.e_commerce.services.interfaces.PathService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class PathServiceImpl implements PathService {

    private PathRepository repository;
    //TODO MENTION YOUR ABSOLUTE PATH WHEN PUSH IT IN GITHUB
    private final String FOLDER_PATH = "C:\\Users\\nadir\\Desktop\\e-commerce\\e-commerce\\images\\";

    public PathServiceImpl(PathRepository repository) {
        this.repository = repository;
    }

    @Override
    public Path upload(MultipartFile file, Long id) throws IOException {
        String filePath = FOLDER_PATH+file.getOriginalFilename();
        Path path = Path.builder()
                .name(file.getOriginalFilename())
                .path(filePath)
                .product(new Product(id))
                .build();
        file.transferTo(new File(filePath));
        return repository.save(path);
    }

    @Override
    public byte[] download(String pathName) throws IOException {
        //TODO CHECK THE FIND BY NAME OR ....
        Optional<Path> path = repository.findByName(pathName);
        if (path.isEmpty())
            return new byte[0];
        String filePath = path.get().getPath();
        return Files.readAllBytes(new File(filePath).toPath());
    }
}
