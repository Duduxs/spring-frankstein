package com.edudev.multitenant.entities;

public interface TenantSupport {

    String getTenantId();
    void setTenantId(String tenantId);

}
