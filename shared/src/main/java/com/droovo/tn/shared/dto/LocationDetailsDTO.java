package com.droovo.tn.shared.dto;

/**
 * LocationDetailsDto is a Data Transfer Object representing location information.
 * <p>
 * This record is used to transfer address-related data between different layers of the application.
 * It encapsulates street, state, and country information in a compact and immutable format.
 * <p>
 * Fields:
 * <ul>
 *   <li>{@code street} - The street address.</li>
 *   <li>{@code state} - The state or province.</li>
 *   <li>{@code country} - The country name.</li>
 * </ul>
 */
public record LocationDetailsDTO(
        String street,
        String state,
        String country
) {
    public LocationDetailsDTO() {
        this("", "", "");
    }

    public LocationDetailsDTO(String street, String state, String country) {
        this.street = street;
        this.state = state;
        this.country = country;
    }
}

