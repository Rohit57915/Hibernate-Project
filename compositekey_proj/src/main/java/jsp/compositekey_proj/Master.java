package jsp.compositekey_proj;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Master {

    @EmbeddedId
    private MasterId mid;

    private String sname;
    private String cname;

    // No-arg constructor
    public Master() {
    }

    // All-arg constructor (optional)
    public Master(MasterId mid, String sname, String cname) {
        this.mid = mid;
        this.sname = sname;
        this.cname = cname;
    }

    public MasterId getMid() {
        return mid;
    }

    public void setMid(MasterId mid) {
        this.mid = mid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Master [mid=" + mid + ", sname=" + sname + ", cname=" + cname + "]";
    }
}
