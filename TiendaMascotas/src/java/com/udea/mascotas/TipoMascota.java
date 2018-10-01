/**
 * This file was generated by the Jeddict
 */
package com.udea.mascotas;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * @author Daniel
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "TipoMascota.findAll", query = "Select e from TipoMascota e")
    ,@NamedQuery(name = "TipoMascota.findByTipoMascota", query = "Select t from TipoMascota t where t.tipoMascota=:tipoMascota")
})
public class TipoMascota {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "No puede estar vacÃ­o")
    private Long id;

    @Column(name = "tipoMascota", nullable = false)
    @Basic
    @NotNull(message = "No puede estar vacio")
    private String tipoMascota;

    @OneToMany(targetEntity = Mascota.class, mappedBy = "tipoMascota")
    private List<Mascota> mascotas;

    public TipoMascota(Long id, String tipoMascota, List mascotas) {
        this.id = id;
        this.tipoMascota = tipoMascota;
        this.mascotas = mascotas;
    }

    public TipoMascota() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoMascota() {
        return this.tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public List<Mascota> getMascotas() {
        return this.mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!java.util.Objects.equals(getClass(), obj.getClass())) {
            return false;
        }
        final TipoMascota other = (TipoMascota) obj;
        if (!java.util.Objects.equals(this.getId(), other.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "TipoMascota{" + " id=" + id + ", tipoMascota=" + tipoMascota + '}';
    }

}