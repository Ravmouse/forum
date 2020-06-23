package ru.vitaly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import ru.vitaly.utils.Utils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Vitaly Vasilyev, date: 08.06.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Controller
public class UploadController {

    private static final String PATH = Utils.getResourcesFolder("application.yml");

    @PostMapping("/create")
    public MultipartFile fileUpload(@RequestPart("file") MultipartFile file) throws IOException {
        try {
            final byte[] bytes = file.getBytes();
            final Path path = Paths.get(PATH + File.separator + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}