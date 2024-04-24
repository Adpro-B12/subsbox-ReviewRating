package id.ac.ui.cs.advprog.rating.enums;

import lombok.Getter;

@Getter
public enum Status {
    PENDING("PENDING"),
    APPROVED("APPROVED"),
    REJECTED("REJECTED");

    private final String value;
    private Status(String value){
        this.value = value;
    }

    public static boolean contains(String param){
        for(Status status : Status.values()){
            if(status.name().equals(param)){
                return true;
            }
        }
        return false;
    }
}
