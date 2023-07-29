package com.oulku.Employee.repository;

import com.oulku.Employee.model.dto.ExampleDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class CustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ExampleDTO getExampleDTOByIdAndName(int employeeId, String name){
        //TypedQuery
        TypedQuery<ExampleDTO> query = entityManager.createQuery("SELECT NEW com.oulku.Employee.model.dto.ExampleDTO(e.employeeId,e.name,concat(e.employeeId,concat('-',e.name) ) ) "+
                "FROM Employee e "+
                "WHERE e.employeeId =:employeeId "+
                "AND e.name=:name",ExampleDTO.class).setParameter("employeeId",employeeId).setParameter("name",name);

        ExampleDTO exampleDTO = query.getSingleResult();
        return exampleDTO;

    }


}
