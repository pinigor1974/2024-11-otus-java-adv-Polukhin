package ru.otus.hw.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.*;

public class CacheControl {
    private final Map<String, MappedByteBuffer> cache = new ConcurrentHashMap<>();
    public void loadCache(String dir) throws IOException{

        try (Stream<Path> paths = Files.walk(Paths.get(dir))) {
            paths.filter(Files::isRegularFile).forEach(
                path ->{
                    try ( RandomAccessFile raf = new RandomAccessFile(path.toFile(), "rw")){
                        FileChannel channel = raf.getChannel();
                        MappedByteBuffer mappedBuf =  channel.map(FileChannel.MapMode.READ_WRITE, 0, raf.length());
                        cache.put(path.getFileName().toFile().getName(),mappedBuf);
                    } catch( IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            );
        }
    }
    public String get(String fileName){
        int count= cache.get(fileName).capacity();
        ByteBuffer bb = cache.get(fileName).rewind();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append((char)bb.get());
        }
        return sb.toString();
    }
}
