package org.example.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Model.Astronaut;
import org.example.Model.MissionEvent;
import org.example.Model.Supply;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileRepository {
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Astronaut> loadAstronauts(String path) throws IOException {
        return mapper.readValue(new File(path), new TypeReference<List<Astronaut>>() {
        });
    }

    public List<MissionEvent> loadEvents(String path) throws IOException {
        return mapper.readValue(new File(path), new TypeReference<List<MissionEvent>>() {
        });
    }

    public List<Supply> loadSupplies(String path) throws IOException {
        return mapper.readValue(new File(path), new TypeReference<List<Supply>>() {
        });
    }
    public void writeAstronautsToFile(List<Astronaut> astronauts, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Astronaut t : astronauts) {
                writer.write(t.toString() + System.lineSeparator());
            }
        }
    }
    public void writeReport(String content, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        }
    }


}
