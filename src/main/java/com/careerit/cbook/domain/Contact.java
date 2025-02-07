package com.careerit.cbook.domain;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
public class Contact {
        private UUID id;
        private String fullName;
        private String email;
        private String mobile;
        private LocalDate dob;
}
