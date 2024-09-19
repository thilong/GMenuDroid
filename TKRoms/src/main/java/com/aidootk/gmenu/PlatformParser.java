package com.aidootk.gmenu;

import com.aidootk.gmenu.model.Platform;

import org.yaml.snakeyaml.Yaml;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class PlatformParser {

    public String getRomRoot() {
        return romRoot;
    }

    private final String romRoot;

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    private final ArrayList<Platform> platforms = new ArrayList<>();

    public PlatformParser(String romRoot) {
        this.romRoot = romRoot;
    }

    public void parse() {
        platforms.clear();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(romRoot))) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    Path configPath = Paths.get(entry.toString(), "platform.yml");
                    if (Files.exists(configPath)) {
                        parsePlatform(entry, configPath);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parsePlatform(Path platformPath, Path configPath) {
        //parse platform.yml to Platform object
        try {
            Yaml yaml = new Yaml();
            Platform platform = yaml.loadAs(Files.newInputStream(configPath), Platform.class);
            platform.setPath(platformPath.toString());
            platforms.add(platform);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseGenericPlatform(Path platformPath) {
        Platform platform = new Platform();
        platform.setName(platformPath.getFileName().toString().toLowerCase());
        platform.setPath(platformPath.toString());
        platforms.add(platform);
    }

}
