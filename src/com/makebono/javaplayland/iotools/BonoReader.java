package com.makebono.javaplayland.iotools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/** 
 * @ClassName: BonoReader 
 * @Description: Simple BufferedReader template for re-using.
 * @author makebono
 * @date 2018年1月29日 上午11:08:05 
 *  
 */
public class BonoReader {
    private final BufferedReader reader;
    private final StringBuilder readContent;

    public BonoReader(final String path) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(path));
        this.readContent = new StringBuilder();
    }

    public String read() {
        final StringBuilder temp = new StringBuilder();
        try {
            String newLine;
            while ((newLine = this.reader.readLine()) != null) {
                temp.append(newLine + "\n");
            }

            this.readContent.append(temp);
            return temp.toString();
        }
        catch (final Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String close() {
        try {
            this.reader.close();
            return "Reader closed. Read content as below:\n\n" + this.readContent.toString();
        }
        catch (final Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public StringBuilder getReadContent(){
    	return this.readContent;
    }
}
