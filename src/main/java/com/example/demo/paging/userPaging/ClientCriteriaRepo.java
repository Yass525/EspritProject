package com.example.demo.paging.userPaging;

import com.example.demo.entity.Client;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ClientCriteriaRepo {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public ClientCriteriaRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<Client> findAllWithFilters(ClientPage clientPage,
                                           ClientSearchCriteria clientSearchCriteria){
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> ClientRoot = criteriaQuery.from(Client.class);
        Predicate predicate = getPredicate(clientSearchCriteria, ClientRoot);
        criteriaQuery.where(predicate);
        setOrder(clientPage, criteriaQuery, ClientRoot);

        TypedQuery<Client> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(clientPage.getPageNumber() * clientPage.getPageSize());
        typedQuery.setMaxResults(clientPage.getPageSize());

        Pageable pageable = getPageable(clientPage);

        long clientCount = getEmployeesCount(predicate);

        return new PageImpl<>(typedQuery.getResultList(), pageable, clientCount);
    }

    private Predicate getPredicate(ClientSearchCriteria clientSearchCriteria,
                                   Root<Client> employeeRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if(Objects.nonNull(clientSearchCriteria.getNom())){
            predicates.add(
                    criteriaBuilder.like(employeeRoot.get("nom"),
                            "%" + clientSearchCriteria.getNom() + "%")
            );
        }
        if(Objects.nonNull(clientSearchCriteria.getPrenom())){
            predicates.add(
                    criteriaBuilder.like(employeeRoot.get("prenom"),
                            "%" + clientSearchCriteria.getPrenom() + "%")
            );
        }

        if(Objects.nonNull(clientSearchCriteria.getEmail())){
            predicates.add(
                    criteriaBuilder.like(employeeRoot.get("eMail"),
                            "%" + clientSearchCriteria.getEmail() + "%")
            );
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void setOrder(ClientPage clientPage,
                          CriteriaQuery<Client> criteriaQuery,
                          Root<Client> clientRoot) {
        if(clientPage.getSortDirection().equals(Sort.Direction.ASC)){
            criteriaQuery.orderBy(criteriaBuilder.asc(clientRoot.get(clientPage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(clientRoot.get(clientPage.getSortBy())));
        }
    }

    private Pageable getPageable(ClientPage clientPage) {
        Sort sort = Sort.by(clientPage.getSortDirection(), clientPage.getSortBy());
        return PageRequest.of(clientPage.getPageNumber(),clientPage.getPageSize(), sort);
    }

    private long getEmployeesCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Client> countRoot = countQuery.from(Client.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }
}
