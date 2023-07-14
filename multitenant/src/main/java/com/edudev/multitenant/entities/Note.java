package com.edudev.multitenant.entities;

import com.edudev.multitenant.filters.TenantContext;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "notes")
@FilterDef(name = "tenantFilter", parameters = {@ParamDef(name = "tenantId", type = String.class)})
@Filter(name = "tenantFilter", condition = "tenant_id = :tenantId")
public class Note implements TenantSupport {
    @Id
    @GeneratedValue(strategy = IDENTITY)

    private Long id;
    @Column(name = "title")
    private String title;

    @Column(name = "tenant_id")
    @JsonProperty(access = WRITE_ONLY)
    private String tenantId;

    public Note() {
    }

    public Note(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTenantId() {
        return tenantId;
    }

    @Override
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @PrePersist
    @PreUpdate
    void updateTenant() {
        if (!TenantContext.getCurrentTenant().isEmpty() && TenantContext.getCurrentTenant() != null) {
            setTenantId(TenantContext.getCurrentTenant());
        }
    }
}
