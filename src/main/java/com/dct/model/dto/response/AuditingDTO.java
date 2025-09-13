package com.dct.model.dto.response;

import com.dct.model.constants.BaseDatetimeConstants;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@SuppressWarnings("unused")
public class AuditingDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String createdBy;
    private String lastModifiedBy;

    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = BaseDatetimeConstants.Formatter.DD_MM_YYYY_HH_MM_SS_DASH,
        timezone = BaseDatetimeConstants.ZoneID.DEFAULT
    )
    private Instant createdDate;

    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = BaseDatetimeConstants.Formatter.DD_MM_YYYY_HH_MM_SS_DASH,
        timezone = BaseDatetimeConstants.ZoneID.DEFAULT
    )
    private Instant lastModifiedDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
