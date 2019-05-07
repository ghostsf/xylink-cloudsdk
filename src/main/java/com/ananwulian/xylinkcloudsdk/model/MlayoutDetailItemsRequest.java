package com.ananwulian.xylinkcloudsdk.model;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: gzm
 * Date: 2018-10-09
 */
public class MlayoutDetailItemsRequest {


    /**
     * pi : 66304
     * di : 1006602@DESK
     * dn : Y2hlbmdmZWnnmoTnlLXohJE=
     */

    private String participantId;
    private long partiDeviceId;
    private String partiName;
    private int partitype;
    private String participantNumber;

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public long getPartiDeviceId() {
        return partiDeviceId;
    }

    public void setPartiDeviceId(long partiDeviceId) {
        this.partiDeviceId = partiDeviceId;
    }

    public String getPartiName() {
        return partiName;
    }

    public void setPartiName(String partiName) {
        this.partiName = partiName;
    }

    public int getPartitype() {
        return partitype;
    }

    public void setPartitype(int partitype) {
        this.partitype = partitype;
    }

    public String getParticipantNumber() {
        return participantNumber;
    }

    public void setParticipantNumber(String participantNumber) {
        this.participantNumber = participantNumber;
    }

    @Override
    public String toString() {
        return "MlayoutDetailItemsRequest{" +
                "participantId='" + participantId + '\'' +
                ", partiDeviceId='" + partiDeviceId + '\'' +
                ", partiName='" + partiName + '\'' +
                ", partitype=" + partitype +
                ", participantNumber='" + participantNumber + '\'' +
                '}';
    }
}
