package monprojet.dto;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import lombok.*;

public interface PopulationParPays {
    String getName();
    Integer getPopulation();
}
