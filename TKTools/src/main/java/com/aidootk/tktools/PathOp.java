package com.aidootk.tktools;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PathOp {

    public static boolean checkFolderWriteable(String folder) {
        File f = new File(combine(folder, ".check"));
        int result = 0;
        try {
            if (f.createNewFile()) {
                result = 1;
                if (f.delete()) result = 2;
            }
        } catch (Exception e) {
            return false;
        }

        return result == 2;
    }

    public static String combine(String parent, String... paths) {
        return Paths.get(parent, paths).toString();
    }

    public static boolean exists(String path) {
        return Files.exists(Paths.get(path));
    }

    public static boolean delete(String path) {
        try {
            return Files.deleteIfExists(Paths.get(path));
        } catch (Exception ignored) {
            return false;
        }
    }

    public static boolean mkdir(String path) {
        try{
            return Files.createDirectory(Paths.get(path)) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean copy(String src, String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File inputFile = new File(src);
            File outputFile = new File(dest);
            if (!outputFile.exists()) {
                File parentFile = outputFile.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    outputFile.getParentFile().mkdirs();
                }
                outputFile.createNewFile();
            }
            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream(outputFile);

            byte[] buffer = new byte[10240];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean copyFileFromAssets(Context context, String fromPath, String toPath) {
        FileOutputStream fos = null;
        InputStream fis = null;
        try {
            File file = new File(toPath);
            File parentPath = file.getParentFile();
            if (!parentPath.exists()) {
                parentPath.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            byte[] buffer = new byte[10240];
            int length;
            fis = context.getAssets().open(fromPath);
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            fos.flush();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ignored) {
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ignored) {
            }
        }

    }

}
