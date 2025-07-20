package jsp.compositekey_proj;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class MasterId implements Serializable {
    private int sid;
    private int cid;

    public MasterId() {
        // Required no-arg constructor
    }

    public MasterId(int sid, int cid) {
        this.sid = sid;
        this.cid = cid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "MasterId [sid=" + sid + ", cid=" + cid + "]";
    }

    @Override
    public int hashCode() {
        return sid + cid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MasterId)) return false;
        MasterId other = (MasterId) obj;
        return this.sid == other.sid && this.cid == other.cid;
    }
}
