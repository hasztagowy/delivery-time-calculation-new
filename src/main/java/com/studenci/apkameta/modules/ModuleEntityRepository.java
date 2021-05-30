package com.studenci.apkameta.modules;

import antlr.collections.List;
import com.studenci.apkameta.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ModuleEntityRepository extends JpaRepository<Module, Integer>  {
}
