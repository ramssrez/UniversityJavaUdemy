package enums;

public enum TypesFilesEnum {
    TXT(1,".txt"),
    JSON( 2,".json"),
    PROPERTIES(3,".properties"),
    yaml( 4,".yaml");

    private final String name;
    private final int option;

    TypesFilesEnum(int option,String name) {
        this.name = name;
        this.option = option;
    }

    public String getName() {
        return name;
    }

    public int getOption() {
        return option;
    }
}
