package com.assignment.recruitment_marketplace.entities;

import jakarta.persistence.*;
import java.time.Instant;

/**
 * Candidate entity.
 */
@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name") private String firstName;
    @Column(name="last_name") private String lastName;
    private String email;
    private String phone;

    @Column(name="resume_url")
    private String resumeUrl;

    @Column(name="primary_skills")
    private String primarySkills;

    @Column(name="total_experience")
    private Double totalExperience;

    @Column(name="current_location")
    private String currentLocation;

    @Column(name="preferred_location")
    private String preferredLocation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "organization_id")
    private Organization organization; // owner org (vendor)

    @Column(name = "created_at", updatable = false)
    private Instant createdAt = Instant.now();

    // getters/setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getResumeUrl() { return resumeUrl; }
    public void setResumeUrl(String resumeUrl) { this.resumeUrl = resumeUrl; }
    public String getPrimarySkills() { return primarySkills; }
    public void setPrimarySkills(String primarySkills) { this.primarySkills = primarySkills; }
    public Double getTotalExperience() { return totalExperience; }
    public void setTotalExperience(Double totalExperience) { this.totalExperience = totalExperience; }
    public String getCurrentLocation() { return currentLocation; }
    public void setCurrentLocation(String currentLocation) { this.currentLocation = currentLocation; }
    public String getPreferredLocation() { return preferredLocation; }
    public void setPreferredLocation(String preferredLocation) { this.preferredLocation = preferredLocation; }
    public Organization getOrganization() { return organization; }
    public void setOrganization(Organization organization) { this.organization = organization; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
