package com.github.jameshdev.citiesapi.cities;

import com.github.jameshdev.citiesapi.states.State;
import com.github.jameshdev.citiesapi.utils.PointType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity
@Table (name = "cidade")
@TypeDefs({
        @TypeDef(name = "point", typeClass = PointType.class)
})
public class City {

    @Id
    private Long id;

    @Column (name = "nome")
    private String name;

    /*@Column (name = "uf")
    private Integer ufId;*/

    @ManyToOne
    @JoinColumn (name = "uf", referencedColumnName = "id")
    private State state;

    @Column
    private Integer ibge;

    @Column (name = "lat_lon")
    private String geolocation;

    @Type(type = "point")
    @Column (name = "lat_lon", updatable = false, insertable = false)
    private Point location;


    public City() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /*public Integer getUfId() {
        return ufId;
    }*/

    public State getState() {
        return state;
    }

    public Integer getIbge() {
        return ibge;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public Point getLocation() {
        return location;
    }
}
