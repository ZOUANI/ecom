package ma.zs.generated.ws.rest.provided.vo;


public class CityVo {

    private String name;

    private String id;

    private String postCode;

    private Long totalCommands;

    public CityVo(String name, Long totalCommands) {
        this.name = name;
        this.totalCommands = totalCommands;
    }

    public Long getTotalCommands() {
        return totalCommands;
    }

    public void setTotalCommands(Long totalCommands) {
        this.totalCommands = totalCommands;
    }

    public CityVo() {
        super();
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }


}