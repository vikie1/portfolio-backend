package io.github.vikie1.portfolio.projects.whatsoftware.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity @Table(name = "software")
public class SoftwareEntity {
    @Id @Column(name = "id", nullable = false) @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String description;
    @Column(nullable = false)
    private String downloadUrl;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) @JoinColumn(name = "types_id")
    private TypeEntity typeEntity;

    public SoftwareEntity(){}
    public SoftwareEntity(String name, String description, String downloadUrl,TypeEntity typeEntity){
        this.name = name;
        this.description = description;
        this.downloadUrl = downloadUrl;
        setTypeEntity(typeEntity);
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getDownloadUrl() { return downloadUrl; }
    @JsonIgnore
    public TypeEntity getTypeEntity() { return typeEntity; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setDownloadUrl(String downloadUrl) { this.downloadUrl = downloadUrl; }
    public void setTypeEntity(TypeEntity type) {
        this.typeEntity = type;
    }
}
