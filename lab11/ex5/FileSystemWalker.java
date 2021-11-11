import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

public class FileSystemWalker {
    double size = 0;
    public Double walk(String pathString, boolean checkSub) {
        try {
			Path path = Paths.get(pathString);
			String[] stringArrayPath = (path + "").split("/");
			String stringPath = String.join("/", stringArrayPath);

            Files.walkFileTree(path, new FileVisitor<Path>() {
                @Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
					if (!checkSub && path != dir) {
                        // não queremos visitar os subdiretorios
						return FileVisitResult.SKIP_SUBTREE;
					}
					return FileVisitResult.CONTINUE;
				}

                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    // aqui é que temos de ir buscar o tamanho do ficheiro
                    String[] filePath = (file + "").split("/");
                    String dirname = String.join("/", filePath);

                    Long fileSize = attrs.size();
                    addToSize(fileSize.doubleValue());

                    if (dirname.equals(stringPath)) {
                        System.out.println(filePath[filePath.length - 1] + ": " + fileSize + " kb");
                    }
                    else if (checkSub && !dirname.equals(stringPath)) {
                        System.out.println(diff(dirname, stringPath) + "->" + filePath[filePath.length - 1] + ": " + fileSize + " kb");    
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
				public FileVisitResult visitFileFailed(Path dir, IOException exc) throws IOException {
					System.err.println("Error visiting the: " + dir);
					System.err.println("Stopping the process...");
					return FileVisitResult.TERMINATE;
				}

                @Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (path == dir){
                        // já chegou ao fim
                        System.out.println("Total size: "+ size + " kb");
                        return FileVisitResult.TERMINATE;
                    }
                    else if (exc == null) {
                        return FileVisitResult.CONTINUE;
                    }
                    throw exc;
				}
            });
        }
        catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}

        return null;
    }

    private String diff(String str1, String str2) {
		int index = str1.lastIndexOf(str2);
		if (index > -1) {
			return str1.substring(str2.length());
		}
		return str1;
	}

    private void addToSize(double size) {
        this.size += size;
    }
}