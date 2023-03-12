package adventofcode2020.day4partTwo;

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
        int input = Integer.parseInt(byr);
        if (input >= 1920 &&
                input <= 2002 &&
                byr.length() == 4) {
            this.byr = byr;
        }
    }

    public void setIyr(String iyr) {
        int input = Integer.parseInt(iyr);
        if (input >= 2010 &&
                input <= 2020 &&
                iyr.length() == 4) {
            this.iyr = iyr;
        }else {
            //System.out.println("ex: iyr found:"+ iyr);
        }
    }

    public void setEyr(String eyr) {
        int input = Integer.parseInt(eyr.trim());
        if (input >= 2020 && input <= 2030) {
            this.eyr = eyr;
        }else {
            System.out.println("ex: eyr found:"+ eyr);
        }
    }

    public void setHgt(String hgt) {
        if (Pattern.matches("^([\\d]+(cm|in))", hgt.trim())) {
            int input = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
            if (hgt.contains("cm")) {
                if (input >= 150 && input <= 193) {
                    this.hgt = hgt;
                }
            }

            if (hgt.contains("in")) {
                if (input >= 59 && input <= 76) {
                    this.hgt = hgt;
                }
            }
        }else {
           // System.out.println("ex: hgt found:"+ hgt);
        }
    }

    public void setHcl(String hcl) {
        if (Pattern.matches("^#[0-9a-fA-F]{6}", hcl.trim())) {
            this.hcl = hcl;
        }
    }

    public void setEcl(String ecl) {
        switch (ecl) {
            case "amb":
            case "blu":
            case "brn":
            case "gry":
            case "grn":
            case "hzl":
            case "oth":
                this.ecl = ecl;
                break;
            default:
                break;
        }
    }

    public void setPid(String pid) {
        try {
            pid = pid.trim();
            Integer ok = Integer.parseInt(pid);
            if (pid.length() == 9) {
                this.pid = pid;
            }
        } catch (NumberFormatException ex) {
            //System.out.println("ex: PID found:"+ pid);
        }
    }
}
