package persistence;


import model.Collection;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


// Represents a writer that writes JSON representation of collection to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String path;

    // EFFECTS: constructs a writer to write to the file on the correct path
    public JsonWriter(String path) {
        this.path = path;
    }

    // MODIFIES: this
    // EFFECTS: opens writer;
    //          throws FileNotFoundException if the file on the correct path cannot be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(path));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of collection to file
    public void write(Collection collection) {
        JSONObject json = collection.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: write string s to file
    private void saveToFile(String s) {
        writer.print(s);
    }

}

// Claim: The heavy amount of the above code is referred to the
//        sample code that is given with the phase 2 project