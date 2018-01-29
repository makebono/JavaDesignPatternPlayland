package com.makebono.javaplayland.iotools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** 
 * @ClassName: BonoWriter 
 * @Description: A simple BufferedWriter template for re-using.
 * @author makebono
 * @date 2018年1月29日 上午10:46:44 
 *  
 */
public class BonoWriter {
    private final BufferedWriter writer;
    private final StringBuilder content;
    private final StringBuilder writtenContent;

    public BonoWriter(final String path) throws IOException {
        this.writer = new BufferedWriter(new FileWriter(new File(path)));
        this.content = new StringBuilder();
        this.writtenContent = new StringBuilder();
    }

    public void append(final String content) {
        this.content.append(content);
    }

    public void appendln(final String content) {
        this.content.append(content + "\n");
    }

    public void write() {
        try {
            this.writer.write(this.content.toString());
            this.writer.flush();
            this.writtenContent.append(this.content);
            this.content.setLength(0);
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public String close() {
        try {
            this.writer.close();
            return "BufferedWriter closed. Content below written to file:\n\n" + this.writtenContent.toString();
        }
        catch (final Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
