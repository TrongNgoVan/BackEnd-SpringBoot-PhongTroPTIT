//package com.example.PhongTroPTITBE.repository;
//
//import com.example.PhongTroPTITBE.entity.Post;
//import com.example.PhongTroPTITBE.model.SearchDTO;
//import org.springframework.data.jpa.domain.Specification;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//public class PostSpecification implements Specification<Post> {
//    private SearchDTO searchForm;
//
//    public PostSpecification(SearchDTO searchForm) {
//        this.searchForm = searchForm;
//    }
//
//    @Override
//    public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
//        Predicate p = cb.disjunction();
//
//        //Search by motel and district
//        if (searchForm.getMotel() == 1 && searchForm.getIdDistrict() != 0) {
//            p.getExpressions().add(
//                    cb.and(cb.greaterThanOrEqualTo(root.get("accomodation").get("acreage"), searchForm.getAcreageStart()),
//                            cb.lessThanOrEqualTo(root.get("accomodation").get("acreage"), searchForm.getAcreageEnd()),
//                            cb.greaterThanOrEqualTo(root.get("accomodation").get("price"), searchForm.getPriceStart()),
//                            cb.lessThanOrEqualTo(root.get("accomodation").get("price"), searchForm.getPriceEnd()),
//                            cb.equal(root.get("accomodation").get("motel"), true),
//                            cb.equal(root.get("accomodation").get("district").get("id"), searchForm.getIdDistrict()),
//                            cb.equal(root.get("del"), false),
//                            cb.equal(root.get("approved"), true),cb.equal(root.get("notApproved"), false)));
//        }
//
//        if (searchForm.getMotel() == 2 && searchForm.getIdDistrict() != 0) {
//            p.getExpressions().add(
//                    cb.and(cb.greaterThanOrEqualTo(root.get("accomodation").get("acreage"), searchForm.getAcreageStart()),
//                            cb.lessThanOrEqualTo(root.get("accomodation").get("acreage"), searchForm.getAcreageEnd()),
//                            cb.greaterThanOrEqualTo(root.get("accomodation").get("price"), searchForm.getPriceStart()),
//                            cb.lessThanOrEqualTo(root.get("accomodation").get("price"), searchForm.getPriceEnd()),
//                            cb.equal(root.get("accomodation").get("motel"), false),
//                            cb.equal(root.get("accomodation").get("district").get("id"), searchForm.getIdDistrict()),
//                            cb.equal(root.get("del"), false),
//                            cb.equal(root.get("approved"), true),cb.equal(root.get("notApproved"), false)));
//        }
//        //Search by motel and district
//
//        //Search by motel
//        if (searchForm.getMotel() == 1 && searchForm.getIdDistrict() == 0) {
//            p.getExpressions().add(
//                    cb.and(cb.greaterThanOrEqualTo(root.get("accomodation").get("acreage"), searchForm.getAcreageStart()),
//                            cb.lessThanOrEqualTo(root.get("accomodation").get("acreage"), searchForm.getAcreageEnd()),
//                            cb.greaterThanOrEqualTo(root.get("accomodation").get("price"), searchForm.getPriceStart()),
//                            cb.lessThanOrEqualTo(root.get("accomodation").get("price"), searchForm.getPriceEnd()),
//                            cb.equal(root.get("accomodation").get("motel"), true),
//                            cb.equal(root.get("del"), false),
//                            cb.equal(root.get("approved"), true),cb.equal(root.get("notApproved"), false)));
//        }
//
//        if (searchForm.getMotel() == 2 && searchForm.getIdDistrict() == 0) {
//            p.getExpressions().add(
//                    cb.and(cb.greaterThanOrEqualTo(root.get("accomodation").get("acreage"), searchForm.getAcreageStart()),
//                            cb.lessThanOrEqualTo(root.get("accomodation").get("acreage"), searchForm.getAcreageEnd()),
//                            cb.greaterThanOrEqualTo(root.get("accomodation").get("price"), searchForm.getPriceStart()),
//                            cb.lessThanOrEqualTo(root.get("accomodation").get("price"), searchForm.getPriceEnd()),
//                            cb.equal(root.get("accomodation").get("motel"), false),
//                            cb.equal(root.get("del"), false),
//                            cb.equal(root.get("approved"), true),cb.equal(root.get("notApproved"), false)));
//        }
//        //Search by motel
//
//        //Search by district
//        if (searchForm.getMotel() == 0 && searchForm.getIdDistrict() != 0) {
//            p.getExpressions().add(
//                    cb.and(cb.greaterThanOrEqualTo(root.get("accomodation").get("acreage"), searchForm.getAcreageStart()),
//                            cb.lessThanOrEqualTo(root.get("accomodation").get("acreage"), searchForm.getAcreageEnd()),
//                            cb.greaterThanOrEqualTo(root.get("accomodation").get("price"), searchForm.getPriceStart()),
//                            cb.lessThanOrEqualTo(root.get("accomodation").get("price"), searchForm.getPriceEnd()),
//                            cb.equal(root.get("accomodation").get("district").get("id"), searchForm.getIdDistrict()),
//                            cb.equal(root.get("del"), false),
//                            cb.equal(root.get("approved"), true),cb.equal(root.get("notApproved"), false)));
//        }
//        //Search by district
//
//        //Search without motel and district
//        if (searchForm.getMotel() == 0 && searchForm.getIdDistrict() == 0) {
//            p.getExpressions().add(
//                    cb.and(cb.greaterThanOrEqualTo(root.get("accomodation").get("acreage"), searchForm.getAcreageStart()),
//                            cb.lessThanOrEqualTo(root.get("accomodation").get("acreage"), searchForm.getAcreageEnd()),
//                            cb.greaterThanOrEqualTo(root.get("accomodation").get("price"), searchForm.getPriceStart()),
//                            cb.lessThanOrEqualTo(root.get("accomodation").get("price"), searchForm.getPriceEnd()),
//                            cb.equal(root.get("del"), false),
//                            cb.equal(root.get("approved"), true),cb.equal(root.get("notApproved"), false)));
//        }
//        //Search without motel and district
//        return p;
//    }
//}
//
