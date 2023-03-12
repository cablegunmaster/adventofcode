package adventofcode2020.day4;

import java.util.regex.Pattern;

public class Passport {

    String byr;
    String iyr;
    String eyr;
    String hgt;
    String hcl;
    String ecl;
    String pid;

    public boolean isValidPassport() {
        return byr != null &&
                iyr != null &&
                eyr != null &&
                hgt != null &&
                hcl != null &&
                ecl != null &&
                pid != null;
    }

    public void setByr(String byr) {
        this.byr = byr;
    }

    public void setIyr(String iyr) {
        this.iyr = iyr;
    }

    public void setEyr(String eyr) {
        this.eyr = eyr;
    }

    public void setHgt(String hgt) {
        this.hgt = hgt;
    }

    public void setHcl(String hcl) {
        this.hcl = hcl;
    }

    public void setEcl(String ecl) {
        this.ecl = ecl;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
