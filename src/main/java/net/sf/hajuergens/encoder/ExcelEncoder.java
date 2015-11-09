package net.sf.hajuergens.encoder;

import ch.qos.logback.core.encoder.EncoderBase;

import java.io.IOException;

public class ExcelEncoder<E> extends EncoderBase<E> {

    @Override
    public void doEncode(E e) throws IOException {

    }

    @Override
    public void close() throws IOException {
        this.outputStream.close();
    }
}
