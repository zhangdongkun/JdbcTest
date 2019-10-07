package com.zdk.jbdc.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "garage", schema = "test", catalog = "")
public class GarageEntity {
    private Integer gid;
    private String garagenum;

    @Id
    @Column(name = "gid")
    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    @Basic
    @Column(name = "garagenum")
    public String getGaragenum() {
        return garagenum;
    }

    public void setGaragenum(String garagenum) {
        this.garagenum = garagenum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GarageEntity that = (GarageEntity) o;
        return Objects.equals(gid, that.gid) &&
                Objects.equals(garagenum, that.garagenum);
    }

    @Override
    public int hashCode() {

        return Objects.hash(gid, garagenum);
    }
}
