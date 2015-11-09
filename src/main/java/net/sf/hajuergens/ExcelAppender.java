package net.sf.hajuergens;

import ch.qos.logback.core.OutputStreamAppender;
import net.sf.hajuergens.encoder.ExcelEncoder;


public class ExcelAppender<E> extends OutputStreamAppender<E> {

    public ExcelAppender() {
        super();
        this.setEncoder(new ExcelEncoder<E>());
    }

}