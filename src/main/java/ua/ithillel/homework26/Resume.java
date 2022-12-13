package ua.ithillel.homework26;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.nio.file.Path;
@Getter
@Setter
@ToString
public class Resume {
    private Path lastReadFile;
    private int lastReadBytePosition;
    private int chunk;
}
