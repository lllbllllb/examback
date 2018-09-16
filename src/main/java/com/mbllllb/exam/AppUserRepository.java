package com.mbllllb.exam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface AppUserRepository extends PagingAndSortingRepository<AppUser, Long> {

    @Query("SELECT u FROM AppUser u WHERE u.alias=:key")
    AppUser findByKey(@Param("key") String key);

    @Query("SELECT count(u) FROM AppUser u WHERE u.alias=:key")
    int exist(@Param("key") String key);
}
