package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class RegexReader extends BufferedReader {

    public RegexReader(Reader r) {
        super(r);
    }

    @Override
    public String readLine() throws IOException {
        String line = super.readLine();
        if(line != null) line = line.replace("\\", "\\\\");
        return line;
    }
}
