package com.assignment.recruitment_marketplace.entities;

import jakarta.persistence.*;

/**
 * Relation entity: vendor -> client mapping.
 */
@Entity
@Table(name = "vendor_client_relation")
public class VendorClientRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vendor_id")
    private Organization vendor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Organization client;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Organization getVendor() { return vendor; }
    public void setVendor(Organization vendor) { this.vendor = vendor; }
    public Organization getClient() { return client; }
    public void setClient(Organization client) { this.client = client; }
}

