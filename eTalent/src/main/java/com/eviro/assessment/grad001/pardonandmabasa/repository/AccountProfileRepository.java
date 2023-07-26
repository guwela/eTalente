package com.eviro.assessment.grad001.pardonandmabasa.repository;

import com.eviro.assessment.grad001.ntwananoandmabasa.entity.AccountProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountProfileRepository extends CrudRepository<AccountProfile, Long> {
}
