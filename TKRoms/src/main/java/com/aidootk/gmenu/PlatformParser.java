package com.aidootk.gmenu;

import com.aidootk.gmenu.model.Platform;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PlatformParser {
    private String romRoot;

    private ArrayList<Platform> platforms = new ArrayList<>();

    public PlatformParser(String romRoot) {
        this.romRoot = romRoot;
    }

    public void parse() {

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
        Platform platform = new Platform();
        platform.setName(platformPath.getFileName().toString().toLowerCase());
        platforms.add(platform);
    }

}
