package com.subhuntmaster.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.subhuntmaster.domain.Member}
 */
public record MemberDto(String firstName, String lastName, Date accessionDate) implements Serializable {
}