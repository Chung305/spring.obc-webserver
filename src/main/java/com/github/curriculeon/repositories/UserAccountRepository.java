package com.github.curriculeon.repositories;

import com.github.curriculeon.models.eap.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
}
