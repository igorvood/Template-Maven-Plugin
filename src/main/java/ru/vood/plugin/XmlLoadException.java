package ru.vood.plugin;

public class XmlLoadException extends RuntimeException {
    public XmlLoadException(String message) {
        super(message);
    }

    public XmlLoadException(Throwable cause) {
        super(cause);
    }
}
