package com.assignment.recruitment_marketplace.entities;
import jakarta.persistence.*;
import java.time.Instant;

/**
 * Organization (company) entity.
 */
@Entity
@Table(name = "organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="company_name", nullable = false)
    private String companyName;

    private String address;
    private String city;

    @Column(name="logo_url")
    private String logoUrl;

    private String email;
    private String website;

    @Column(name="account_manager")
    private String accountManager;

    @Column(name="created_at", updatable = false)
    private Instant createdAt = Instant.now();

    private boolean active = true;

    // getters + setters...
   
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getLogoUrl() { return logoUrl; }
    public void setLogoUrl(String logoUrl) { this.logoUrl = logoUrl; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }
    public String getAccountManager() { return accountManager; }
    public void setAccountManager(String accountManager) { this.accountManager = accountManager; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}

