package org.example.Service;

import org.example.Enums.AstronautStatus;
import org.example.Model.Astronaut;
import org.example.Model.MissionEvent;
import org.example.Model.Supply;

import java.util.*;
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
    public int calculateComputedPoints(MissionEvent event) {
        switch (event.getType()) {
            case EVA: return event.getBasePoints()+ (2 * event.getDay());
            case SYSTEM_FAILURE: return event.getBasePoints()-3-event.getDay();
            case SCIENCE: return event.getBasePoints()+(event.getDay()%4);
            case MEDICAL: return event.getBasePoints()-2*(event.getDay()%3);
            case COMMUNICATION: return event.getBasePoints()+5;
            default: return event.getBasePoints();

        }
    }
    public List<MissionEvent> getEvents() {
        return events;
    }






}
