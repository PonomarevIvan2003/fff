package lab5.client.data;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Flat implements Comparable <Flat> {
    private static Long idGen = Long.valueOf(0);
    private Long id; //поле не может быть null, Значение поля должно быть уникальным, Значение этого поля должно генерироваться автоматически.
    private String name; //Поле не может быть null, Строка не может быть пустой.
    private Coordinates coordinates; //Поле не может быть null.
    private java.time.LocalDateTime creationDate;
    private Long area; //Поле может быть null, Значение поля должно быть больше 0.
    private Integer numberOfRooms; //Максимальное значение поля: 15, Значение поля должно быть больше 0.
    private Integer height; //Поле может быть null, Значение поля должно быть больше 0.
    private Boolean newness; //Может быть null.
    private Transport transport; //Поле не может быть null.
    private House house; //Поле не может быть null.

    public Flat(String name, Coordinates coordinates, LocalDateTime creationDate, Long area, Integer numberOfRooms, Integer height, Boolean newness, Transport transport, House house) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.height = height;
        this.newness = newness;
        this.transport = transport;
        this.house = house;
        generateId();
    }
    public Flat(String name, Coordinates coordinates, LocalDate creationDate, Long area, Integer numberOfRooms, Integer height, Boolean newness, Transport transport, House house) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.height = height;
        this.newness = newness;
        this.transport = transport;
        this.house = house;
        generateId();
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Long getArea() {
        return area;
    }
    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public Integer getHeight() {
        return height;
    }

    public Boolean getNewness() {
        return newness;
    }

    public Transport getTransport() {
        return transport;
    }

    public House getHouse() {
        return house;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public void setupCoordinates(int x, Float y){
        coordinates = new Coordinates(x,y);
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setNewness(Boolean newness) {
        this.newness = newness;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void generateId(){
        id = idGen;
        idGen++;
    }

    @Override
    public String toString(){
        String idS = "id = " + id;
        String nameS = "name = " + name;
        String coordinateS = "coordinates = " + coordinates.toString();
        String creationDateS = "creationDate = " + creationDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String areaS = "area = " + area;
        String numberOfRoomS = "numberOfRoomS = " + numberOfRooms;
        String heightS = "height = " + height;
        String newnesS = "newness = " + newness;
        String transportS = "transport = " + transport;
        String houseS = "house = " + house.toString();
        return idS + "\n" + nameS + "\n" + coordinateS + "\n" + creationDateS + "\n" + areaS + "\n" + numberOfRoomS + "\n" + heightS + "\n" + newnesS + "\n" + transportS + "\n" + houseS;
    }
    @Override
    public int compareTo(Flat flat){
        Integer notNullNumberOfRooms = numberOfRooms;
        if (numberOfRooms == null){
            notNullNumberOfRooms = 1;
        }
        Integer notNullNumberOfRooms0 = flat.numberOfRooms;
        if (flat.numberOfRooms == null){
            notNullNumberOfRooms0 = 1;
        }
        Long notNullArea = area;
        if (area == null){
            notNullArea = 1L;
        }
        Long notNullArea0 = flat.area;
        if (flat.area == null){
            notNullArea0 = 1L;
        }
        Integer notNullHeight = height;
        if (height == null){
            notNullHeight = 1;
        }
        Integer notNullHeight0 = flat.height;
        if (flat.height == null){
            notNullHeight0 = 1;
        }
        Boolean notNullNewness = newness;
        if (newness == null){
            notNullNewness = false;
        }
        Boolean notNullNewness0 = flat.newness;
        if (flat.newness == null){
            notNullNewness0 = false;
        }
        if (notNullNumberOfRooms > notNullNumberOfRooms0){
            return 1;
        }
        else if (notNullNumberOfRooms < notNullNumberOfRooms0){
            return -1;
        }
        else if (notNullArea > notNullArea0){
            return 1;
        }
        else if (notNullArea < notNullArea0){
            return -1;
        }
        else if (notNullHeight > notNullHeight0){
            return 1;
        }
        else if (notNullHeight < notNullHeight0){
            return -1;
        }
        else if (notNullNewness.compareTo(notNullNewness0) > 0){
            return 1;
        }
        else if (notNullNewness.compareTo(notNullNewness0) < 0){
            return -1;
        }
        else if (house.compareTo(flat.house) > 0){
            return 1;
        }
        else if (house.compareTo(flat.house) < 0){
            return -1;
        }
        else if (coordinates.compareTo(flat.coordinates) > 0){
            return 1;
        }
        else if (coordinates.compareTo(flat.coordinates) < 0){
            return -1;
        }
        else if (name.compareTo(flat.name) > 0){
            return 1;
        }
        else if (name.compareTo(flat.name) < 0){
            return -1;
        }
        else return 0;
    }
}
