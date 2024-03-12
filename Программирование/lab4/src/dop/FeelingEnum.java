package dop;

public enum FeelingEnum {
    VISION("зрение"), HEARING("слух"), SMELL("обоняние"), TACTILITY("тактильность"), TASTE("вкус"), VESTUBULAR_APPARATUS("вестибулярный аппарат");
    private String value;
    private FeelingEnum(String s){
        value = s;
    }
    @Override
    public String toString(){
        return value;
    }
}