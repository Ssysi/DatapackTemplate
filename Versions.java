public class Versions {
    String[][] versions = {
        {"1.13", "1.13.1", "1.13.2", "1.14", "1.14.1", "1,14.2", "1.14.3", "1.14.4"},
        {"1.15", "1.15.2", "1.16", "1.16.1"},
        {"1.16.2", "1.16.3", "1.16.4", "1.16.5"},
        {"1.17", "1.17.1"},
        {"1.18", "1.18.1"},
        {"1.18.2"},
        {"1.19", "1.19.1", "1.19.2", "1.19.3"},
        {"1.19.4"},
        {"1.20", "1.20.1"},
        {"1.20.2"},
        {"1.20.3", "1.20.4"},
        {"1.20.5", "1.20.6"},
        {"1.21", "1.21.1"},
        {"1.21.2", "1.21.3"},
        {"1.21.4"},
        {"1.21.5"},
        {"1.21.6"},
        {"1.21.7", "1.21.8"},
        {"1.21.9","1.21.10"}
    };
    String version;

    Versions(String version){
        this.version = version;
    }

    public boolean validateVersion(String version){
        for(int ln = 0; ln < versions.length; ln++){
            for(int col = 0; col < versions[ln].length; col++){
                if(version.equals(versions[ln][col])) return true;
            }
        }
        System.out.println("Invalid version");
        return false;
    }
    public double versionNumber(String version){
        for(int ln = 0; ln < versions.length; ln++){
            for(int col = 0; col < versions[ln].length; col++){
                if(version.equals(versions[ln][col])){
                    switch(ln) {
                        case 0: return 4;
                        case 1: return 5;
                        case 2: return 6;
                        case 3: return 7;
                        case 4: return 8;
                        case 5: return 9;
                        case 6: return 10;
                        case 7: return 12;
                        case 8: return 15;
                        case 9: return 18;
                        case 10: return 26;
                        case 11: return 41;
                        case 12: return 48;
                        case 13: return 57;
                        case 14: return 61;
                        case 15: return 71;
                        case 16: return 80;
                        case 17: return 81;
                        case 18: return 88.1;
                    }
                }
            }
        }
        return 0;
    }
}

