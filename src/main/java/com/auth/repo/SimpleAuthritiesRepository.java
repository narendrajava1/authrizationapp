package com.auth.repo;

import org.springframework.data.repository.CrudRepository;

import com.auth.model.SimpleGrantedAuthority;

public interface SimpleAuthritiesRepository extends CrudRepository<SimpleGrantedAuthority, Long>{

}
