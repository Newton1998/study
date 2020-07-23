package spring.ioc.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.ioc.db.AppDB;
import spring.ioc.model.MyUser;

@Component
public class GeneralDao {

    //custom annotation
    //@Inject
    @Autowired
    private AppDB db;
    private String name;

    public GeneralDao() {
    }

    public GeneralDao(AppDB db, String name) {
        this.db = db;
        this.name = name;
    }

    public MyUser find(String email) {
        return db.getUserMap().get(email);
    }

    public AppDB getDb() {
        return db;
    }

    public void setDb(AppDB db) {
        this.db = db;
    }
}
