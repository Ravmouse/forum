package ru.vitaly.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import static java.io.File.separator;

/**
 * @author Vitaly Vasilyev, date: 18.06.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
public class Utils {
    /**
     * @param name название файла.
     * @return путь к папке с изображениями в виде строки.
     */
    public static String getResourcesFolder(String name) {
        final URL resource = Utils.class.getClassLoader().getResource(name);
        File file = null;
        try {
            file = Paths.get(resource.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        String absolutePath = file.getAbsolutePath();
        String path = absolutePath.substring(0, absolutePath.lastIndexOf(separator));
        path = String.join(separator, path, "static", "images");

        createFolder(path);

        return path;
    }


    private static void createFolder(String path) {
        final File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }
}