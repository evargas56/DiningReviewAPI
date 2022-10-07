package com.evargasw.diningReview.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class AdminReview {
    @Id
    @GeneratedValue
    private Long id;

    private Boolean accept;

    public AdminReview() {}

    public AdminReview(AdminReview adminReview) {
        this.accept = adminReview.getAccept();
    }

    public AdminReview(Boolean accept) {
        this.accept = accept;
    }
}
