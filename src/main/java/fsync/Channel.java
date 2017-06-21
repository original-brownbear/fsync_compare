package fsync;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

public class Channel implements IO {
    private final FileChannel channel;

    public Channel(File file) throws IOException {
        this.channel =
            FileChannel.open(file.toPath(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    @Override
    public void write(ByteBuffer buffer) throws IOException {
        this.channel.write(buffer);
    }

    @Override
    public void sync() throws IOException {
        this.channel.force(false);
    }

    @Override
    public void close() throws Exception {
        this.channel.close();
    }
}
