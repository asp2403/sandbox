package aspopov.api.dto;

public class PersonDto {
    private String name;
    private String email;

    public PersonDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public PersonDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
