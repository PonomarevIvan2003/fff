package lab5.client.data;

public class House implements Comparable <House> {
    private String name; //Поле не может быть null.
    private int year; //Значение поля должно быть больше 0.
    private Integer numberOfLifts; //Значение поля должно быть больше 0.

    public House(String name, int year, Integer numberOfLifts){
        this.name = name;
        this.year = year;
        this.numberOfLifts = numberOfLifts;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setNumberOfLifts(Integer numberOfLifts){
        this.numberOfLifts = numberOfLifts;
    }
    public String getName(){
        return name;
    }
    public int getYear(){
        return year;
    }
    public Integer getNumberOfLifts(){
        return numberOfLifts;
    }
    @Override
    public String toString(){
        String nameS = "name =  " + name;
        String yearS = "year = " + year;
        String numberOfLiftS = "numberOfLifts = " + numberOfLifts;
        return nameS + "\n" + yearS + "\n" + numberOfLiftS + "\n";
    }
    @Override
    public int compareTo(House house){
        Integer notNullNumberOfLifts = numberOfLifts;
        if (numberOfLifts == null){
            notNullNumberOfLifts = 1;
        }
        Integer notNullNumberOfLifts0 = house.numberOfLifts;
        if (house.numberOfLifts == null){
            notNullNumberOfLifts0 = 1;
        }
        if (year > house.year){
            return 1;
        }
        else if (year < house.year){
            return -1;
        }
        else if (notNullNumberOfLifts > notNullNumberOfLifts0){
            return 1;
        }
        else if (notNullNumberOfLifts < notNullNumberOfLifts0){
            return -1;
        }
        else if (name.compareTo(house.name) > 0){
            return 1;
        }
        else if (name.compareTo(house.name) < 0){
            return -1;
        }
        else return 0;
    }

}
