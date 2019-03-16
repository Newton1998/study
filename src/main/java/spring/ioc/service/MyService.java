package spring.ioc.service;

import spring.ioc.model.MyUser;
import spring.ioc.dao.GeneralDao;
import spring.ioc.exception.MyAppException;
import spring.ioc.exception.MyLoginException;
import spring.ioc.exception.MyValidationException;
import spring.ioc.validation.GeneralValidator;

public class MyService {


    private GeneralDao genDao;
    private GeneralValidator validator;


    public String login(String email, String pass) throws MyAppException {

        if (!validator.isValidate(email) || !validator.isValidPass(pass)){
            throw new MyValidationException();
        }

        MyUser found = genDao.find(email);

        if (found == null){
            throw new MyLoginException("wrong email or pass");
        }

        if (found.getPass().equals(pass)){
            return "AccessKey";
        }

        throw new MyLoginException("Wrong email or pass");
    }

    public GeneralDao getGenDao() {
        return genDao;
    }

    public void setGenDao(GeneralDao genDao) {
        this.genDao = genDao;
    }

    public GeneralValidator getValidator() {
        return validator;
    }

    public void setValidator(GeneralValidator validator) {
        this.validator = validator;
    }
}
