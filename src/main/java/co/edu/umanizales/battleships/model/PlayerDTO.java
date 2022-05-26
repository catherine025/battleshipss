package co.edu.umanizales.battleships.model;

import org.jetbrains.annotations.NotNull;

public class PlayerDTO {
    @NotNull
    @Min(1)
    @Max(2)
    private byte numPlayer;
    @Valid
    @NotNull
    private User player;
}
}
