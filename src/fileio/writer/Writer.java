package fileio.writer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Writer {
    private final File file;

    public Writer(final String path) throws IOException {
        this.file = new File(path);
    }

    public void writeFile(AnnualChildrenWriter writerOutput) throws IOException {
        ObjectMapper om = new ObjectMapper();

        try {
            om.writerWithDefaultPrettyPrinter().writeValue(this.file, writerOutput);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectMapper om1 = new ObjectMapper();


    }

}
