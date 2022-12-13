package ua.ithillel.homework26;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StorageReaderClass implements StorageReader {
    private Resume resume = new Resume();

    @SneakyThrows
    public byte[] read(Path filePath) {
        int lastReadByte = 0;
        byte[] retBytes = {};

        try (RandomAccessFile srcFile = new RandomAccessFile(filePath.toFile(), "r");
             FileChannel channel = srcFile.getChannel()) {
            ByteBuffer buff = ByteBuffer.allocate(1024);
            channel.read(buff);
            buff.flip();
            retBytes = new byte[buff.limit()];
            int byteCount = 0;
            while (buff.hasRemaining()) {
                byte readByte = buff.get();
                lastReadByte = buff.position();
                retBytes[byteCount] = readByte;
                byteCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        resume.setLastReadBytePosition(lastReadByte);
        resume.setLastReadFile(filePath);
        resume.setChunk(retBytes.length);
        return retBytes;
    }

    @SneakyThrows
    public List<byte[]> read(Path filePath, int chunkSize) {
        int lastReadByte = 0;
        List<byte[]> retBytes = new ArrayList<>();

        try (RandomAccessFile srcFile = new RandomAccessFile(filePath.toFile(), "r");
             FileChannel channel = srcFile.getChannel()) {
            ByteBuffer buff = ByteBuffer.allocate(1024);
            channel.read(buff);
            buff.flip();
            int chunkCount = 0;
            byte[] chunkBytes = new byte[chunkSize];
            while (buff.hasRemaining()) {
                byte readByte = buff.get();
                lastReadByte = buff.position();
                chunkBytes[chunkCount] = readByte;
                chunkCount++;
                if (chunkCount == chunkSize || buff.position() == buff.limit()) {
                    retBytes.add(chunkBytes);
                    chunkBytes = new byte[chunkSize];
                    chunkCount = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        resume.setLastReadBytePosition(lastReadByte);
        resume.setLastReadFile(filePath);
        resume.setChunk(chunkSize);
        return retBytes;
    }

    @SneakyThrows
    public List<byte[]> read(Resume resume) {
        int bufferPosToStartRead = resume.getLastReadBytePosition();
        int chunkSize = resume.getChunk();
        int lastReadByte = 0;
        List<byte[]> retBytes = new ArrayList<>();

        try (RandomAccessFile srcFile = new RandomAccessFile(resume.getLastReadFile().toFile(), "r");
             FileChannel channel = srcFile.getChannel()) {
            ByteBuffer buff = ByteBuffer.allocate(1024);
            channel.read(buff);
            buff.flip();
            buff.position(bufferPosToStartRead);
            int chunkCount = 0;
            byte[] chunkBytes = new byte[chunkSize];
            while (buff.hasRemaining()) {
                byte readByte = buff.get();
                lastReadByte = buff.position();
                chunkBytes[chunkCount] = readByte;
                chunkCount++;
                if (chunkCount == chunkSize || buff.position() == buff.limit()) {
                    retBytes.add(chunkBytes);
                    chunkBytes = new byte[chunkSize];
                    chunkCount = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        resume.setLastReadBytePosition(lastReadByte);
        resume.setChunk(chunkSize);
        return retBytes;
    }
}
