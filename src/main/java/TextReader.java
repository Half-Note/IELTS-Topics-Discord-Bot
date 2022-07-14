import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class TextReader {
    public static String readFile(String filePath) {
        String string = "";

        try {
            string = Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return string;
    }

    public static String[] readDirectory(String directoryPath) {
        ArrayList<String> strings = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(i -> strings.add(readFile(i.toString())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strings.toArray(new String[0]);
    }

    public static String[] readResourcesDirectory(String directoryPath) {
        ArrayList<String> strings = new ArrayList<>();

        try {
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources(directoryPath + "*.txt");

            for (Resource resource : resources) {
                strings.add(new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strings.toArray(new String[0]);
    }
}
