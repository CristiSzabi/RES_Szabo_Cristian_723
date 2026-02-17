package org.example.Service;

import org.example.Enums.AstronautStatus;
import org.example.Model.Astronaut;
import org.example.Model.MissionEvent;
import org.example.Model.Supply;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NasaService {
    private final List<Astronaut> astronauts;
    private final List<MissionEvent> events;
    private final List<Supply> supplies;
    public NasaService(List<Astronaut>astronauts, List<MissionEvent> events, List<Supply> supplies) {
        this.astronauts = astronauts;
        this.events = events;
        this.supplies = supplies;
    }
    public List<Astronaut> getAstronautsBySpacecraft(String spacecraft) {
        return astronauts.stream()
                .filter(t -> t.getSpacecraft().equals(spacecraft) && t.getStatus()== AstronautStatus.ACTIVE)
                .collect(Collectors.toList());
    }
    public List<Astronaut> getSortedAstronauts() {
        return astronauts.stream()
                .sorted(Comparator.comparingInt(Astronaut::getExperienceLevel).reversed()
                        .thenComparing(Comparator.comparing(Astronaut::getName)))
                .collect(Collectors.toList());
    }


}
