//package ua.com.owu.service.xxx;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Component;
//import ua.com.owu.dao.UserDAO;
//import ua.com.owu.entity.User;
//import ua.com.owu.service.UserService;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//@Component
//public class Test implements Specification<User> {
//    @Autowired
//    UserDAO userDAO;
//    User user;
//
//    public Test(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//
//        Predicate predicate = null;
//        if (user.getUsername() != null) {
//            predicate = criteriaBuilder.equal(root.get("username"), "");
//        }
//        if (user.getPassword() != null) {
//            Predicate predicate2 = criteriaBuilder.equal(root.get("password"), "");
//            predicate = criteriaBuilder.and(predicate, predicate2);
//        }
//
//        return predicate;
//    }
//
//
//    public void asd(Specification<User> userSpecification) {
//        userDAO.findAll(new Test(userDAO.findOne(1)));
//
//    }
//}
